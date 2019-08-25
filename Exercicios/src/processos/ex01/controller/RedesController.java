package processos.ex01.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.swing.JOptionPane;

public class RedesController {
	public static final int WINDOWS = 0;
	public static final int LINUX = 1;

	private InputStream stream;
	private InputStreamReader reader;
	private BufferedReader buffer;

	private int os;

	public RedesController() {
		setOS(System.getProperty("os.name"));
	}

	public RedesController(int os) {
		if (os != WINDOWS && os != LINUX)
			throw new IllegalArgumentException("Invalid Operating System");

		this.os = os;
	}

	private void setOS(String os) {
		if (os.contains("Windows"))
			this.os = WINDOWS;
		else if (os.contains("Linux")) {
			this.os = LINUX;
		}
	}

	public void getIP() {
		String command = (os == WINDOWS) ? "ipconfig" : "ifconfig";

		executeProcess(command);

		if (os == WINDOWS)
			getIPInTheWindows();
		else
			getIPInTheLinux();

		closeResources();
	}

	private void getIPInTheWindows() {
		try {
			String result = "";
			String line;

			while ((line = buffer.readLine()) != null) {
				if (line.contains("Ethernet"))
					result += line + "\n";
				else if (line.contains("IPv4")) {
					int beginIndex = line.indexOf('1');
					result += line.substring(beginIndex) + "\n";
				}
			}
			JOptionPane.showMessageDialog(null, result);

		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Error to the get IP", "Error", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}

	private void getIPInTheLinux() {
		try {
			String result = "";
			String line;

			while ((line = buffer.readLine()) != null) {
				if (line.contains("inet addr:")) {
					int beginIndex = line.indexOf(":");
					int endIndex = line.indexOf("  ", 20);

					result += line.substring(beginIndex, endIndex) + "\n";
				}
			}
			JOptionPane.showMessageDialog(null, result);

		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Error to the get IP", "Error", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}

	public void getPing() {
		String command = "ping www.google.com";
		int totalMs = 0;

		executeProcess(command);

		try {
			String line;

			while ((line = buffer.readLine()) != null) {
				if (line.contains("ms")) {
					line = line.substring(line.indexOf("="));
					line = line.replace("=", "").replaceAll("\\w", " ");
					System.out.println(line);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		closeResources();
	}

	private void executeProcess(String command) {
		try {
			Process process = Runtime.getRuntime().exec(command);
			stream = process.getInputStream();
			reader = new InputStreamReader(stream);
			buffer = new BufferedReader(reader);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void closeResources() {
		try {
			stream.close();
			reader.close();
			buffer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
