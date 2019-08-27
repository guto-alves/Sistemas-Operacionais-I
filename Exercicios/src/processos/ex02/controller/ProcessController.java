package processos.ex02.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ProcessController {
	public static final String WINDOWS_OS = "Windows";
	public static final String LINUX_OS = "Linux";

	public String getOS() {
		return System.getProperty("os.name").contains(WINDOWS_OS) ? WINDOWS_OS : "Linux";
	}

	public String listAllProcess(String os) {
		String result = "";
		String command = os.equals(WINDOWS_OS) ? "TASKLIST /FO TABLE" : "ps aux";

		BufferedReader buffer = execProcess(command);

		try {
			String line;

			while ((line = buffer.readLine()) != null)
				result += line + "\n";

			return result;

		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

	public void killProcess(String os, int pid) {
		String command = os.equals(WINDOWS_OS) ? "TASKKILL /PID " : "killall ";
		command += pid;

		execProcess(command);
	}

	public void killProcess(String os, String name) {
		String command = os.equals(WINDOWS_OS) ? "TASKKILL /PID " : "killall ";
		command += name;

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
