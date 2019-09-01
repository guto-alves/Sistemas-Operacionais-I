package processos.ex02.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ProcessController {
	public static final String WINDOWS_OS = "Windows";
	public static final String LINUX_OS = "Linux";

	private String os;

	public ProcessController() {
		os = getOS();
	}

	public String getOS() {
		return System.getProperty("os.name").contains(WINDOWS_OS) ? WINDOWS_OS : LINUX_OS;
	}

	public void listAllProcess() {
		String command = os.equals(WINDOWS_OS) ? "TASKLIST /FO TABLE" : "ps aux";
		String result = "";

		BufferedReader buffer = execProcess(command);

		try {
			String line;

			while ((line = buffer.readLine()) != null)
				result += line + "\n";

			JOptionPane.showMessageDialog(null, result);

			closeBuffer(buffer);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void listAllProcesses(DefaultTableModel tableModel, String os) {
		tableModel.setNumRows(0);
		String command = os.equals(WINDOWS_OS) ? "TASKLIST /FO TABLE" : "ps aux";

		BufferedReader buffer = execProcess(command);

		try {
			String line = buffer.readLine();

			String[] columnsNames = line.split("\\s+");
			for (String columnName : columnsNames) {
				tableModel.addColumn(columnName);
				System.out.print(columnName + "   ");
			}

			while ((line = buffer.readLine()) != null) {
				if (!line.contains("=")) {
					String[] rowData = line.split("\\s+");

					tableModel.addRow(rowData);
					System.out.println(Arrays.toString(rowData));
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public <T> void killProcess(T pid) {
		String command = os.equals(WINDOWS_OS) ? "TASKKILL /PID " : "killall ";
		command += pid;

		execProcess(command);
	}

	public BufferedReader execProcess(String command) {
		try {
			Process processResult = Runtime.getRuntime().exec(command);
			InputStream stream = processResult.getInputStream();
			InputStreamReader reader = new InputStreamReader(stream);
			return new BufferedReader(reader);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

	public void closeBuffer(BufferedReader bufferedReader) {
		try {
			bufferedReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
