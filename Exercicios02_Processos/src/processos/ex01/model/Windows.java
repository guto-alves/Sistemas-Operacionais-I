package processos.ex01.model;

import java.io.BufferedReader;
import java.io.IOException;

import javax.swing.JOptionPane;

public class Windows extends OS {

	public Windows() {
		super("Windows", "ipconfig", "ping -n 10 www.google.com");
	}

	@Override
	public String getIP(BufferedReader buffer) {
		try {
			Adapter adapter = new Adapter();
			String result = "";

			String line;

			while ((line = buffer.readLine()) != null) {
				if (line.contains("Ethernet"))
					adapter.setName(line);
				else if (line.contains("IPv4")) {
					int beginIndex = line.indexOf('1');
					adapter.setAddres(line.substring(beginIndex));

					result += adapter;
				}
			}

			return result;

		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Erro ao obter o(s) adaptador(es) Ethernet", "Error",
					JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public String getPing(BufferedReader buffer) {
		String regex = "=";
		int indexOfAverage = 3;

		try {
			String line;
			String lastLine = ""; // line that goes contains the average
			String average;

			while ((line = buffer.readLine()) != null)
				lastLine = line;

			average = lastLine.split(regex)[indexOfAverage];

			return String.format("Média = %s", average);

		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

}
