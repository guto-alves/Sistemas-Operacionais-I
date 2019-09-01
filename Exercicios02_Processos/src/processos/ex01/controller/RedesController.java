package processos.ex01.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.swing.JOptionPane;

import processos.ex01.model.Linux;
import processos.ex01.model.OS;
import processos.ex01.model.Windows;

public class RedesController {
	private InputStream stream;
	private InputStreamReader reader;
	private BufferedReader buffer;

	private OS os;

	public RedesController() {
		if (System.getProperty("os.name").contains("Windows"))
			os = new Windows();
		else
			os = new Linux();
	}

	public void getIP() {
		executeProcess(os.getCommandIP());

		String result = os.getIP(buffer);

		JOptionPane.showMessageDialog(null, result, "Resultado", JOptionPane.INFORMATION_MESSAGE);

		closeResources();
	}

	public void getPing() {
		executeProcess(os.getCommandPing());

		String result = os.getPing(buffer);

		JOptionPane.showMessageDialog(null, result, "Resultado", JOptionPane.INFORMATION_MESSAGE);

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
