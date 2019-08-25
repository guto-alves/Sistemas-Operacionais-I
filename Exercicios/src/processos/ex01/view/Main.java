package processos.ex01.view;

import javax.swing.JOptionPane;

import processos.ex01.controller.RedesController;

public class Main {

	public static void main(String[] args) {
		RedesController redesController = new RedesController();

		int option = 0;

		do {
			String input = JOptionPane
					.showInputDialog("Hello! enter the action number:\n\n1 - Get Ethernet Adapter and IPv4.\n"
							+ "2 - Get Ping from a web page.\n" + "9 - Exit");

			if (isInteger(input)) {
				option = Integer.parseInt(input);

				switch (option) {
				case 1:
					redesController.getIP();
					break;
				case 2:
					redesController.getPing();
					break;
				case 9:
					break;
				default:
					JOptionPane.showMessageDialog(null, "Invalid option!", "Error", JOptionPane.ERROR_MESSAGE);
					break;
				}
			} else
				JOptionPane.showMessageDialog(null, "Please, enter the option number!", "Error",
						JOptionPane.ERROR_MESSAGE);

		} while (option != 9);
	}

	private static boolean isInteger(String option) {
		return option.matches("\\d");
	}
}
