package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ProcController {

	public ProcController() {
		super();
	}

	public String getOS() {
		String os = System.getProperty("os.name");
		String arch = System.getProperty("os.arch");
		String version = System.getProperty("os.version");
		String language = System.getProperty("user.language");
		return String.format("SO: %s v. %s%nArquitetura: %s%nIdioma: %s%n", os, version, arch, language);
	}

	public void callProcesso(String processo) {
		try {
			Runtime.getRuntime().exec(processo);
		} catch (Exception e) {
			if (e.getMessage().contains("740")) {
				StringBuffer buffer = new StringBuffer();
				buffer.append("cmd /c ");
				buffer.append(processo);
				try {
					Runtime.getRuntime().exec(buffer.toString());
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			} else
				e.printStackTrace();
		}
	}

	public void readProcesso(String processo) {
		try {
			Process process = Runtime.getRuntime().exec(processo);
			InputStream stream = process.getInputStream();
			InputStreamReader reader = new InputStreamReader(stream);
			BufferedReader buffer = new BufferedReader(reader);

			String line;

			while ((line = buffer.readLine()) != null) {
				System.out.println(line);
				line = buffer.readLine();
			}

			buffer.close();
			reader.close();
			stream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void killProcess(String param) {
		String cmdPID = "TASKKILL /PID";
		String cmdNome = "TASKKILL /IM";
		int pid = 0;
		StringBuffer buffer = new StringBuffer();

		try {
			pid = Integer.parseInt(param);
			buffer.append(cmdPID);
			buffer.append(" ");
			buffer.append(pid);
		} catch (Exception e) {
			buffer.append(cmdNome);
			buffer.append(" ");
			buffer.append(param);
		}

		callProcesso(buffer.toString());
	}

}
