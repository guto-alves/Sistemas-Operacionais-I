package processos.ex01.model;

import java.io.BufferedReader;
import java.io.IOException;

import javax.swing.JOptionPane;

public class Linux extends OS {

	public Linux() {
		super("Linux", "ifconfig", "ping -c 10 www.google.com");
	}

	@Override
	public String getIP(BufferedReader buffer) {
		try {
			Adapter adapter = new Adapter();
			String result = "";

			String line;

			while ((line = buffer.readLine()) != null) {
				if (line.contains("encap:Ethernet"))
					adapter.setName(line.split(" ")[0]);
				else if (line.contains("inet addr:")) {
					int beginIndex = line.indexOf('1'); // beginning of IPv4
					int endIndex = line.indexOf("  ", 20); // end of IPv4

					adapter.setAddres(line.substring(beginIndex, endIndex));
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
		String regex = "/";
		int indexOfAverage = 4;

		try {
			String line;
			String lastLine = ""; // line that goes contains the average
			String average;

			while ((line = buffer.readLine()) != null)
				lastLine = line;

			average = lastLine.split(regex)[indexOfAverage];

			return String.format("Média = %sms", average);

		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

}
