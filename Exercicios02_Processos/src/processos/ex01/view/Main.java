package processos.ex01.view;

import javax.swing.JOptionPane;

import processos.ex01.controller.RedesController;

public class Main {

	public static void main(String[] args) {
		RedesController redesController = new RedesController();

		int option = 0;

		do {
			String input = JOptionPane.showInputDialog(
					"Digite o número da opção:\n\n1 - Adaptadores ethernet e IPv4.\n" + "2 - Ping.\n" + "9 - Sair.");

			if (isValidInput(input)) {
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
					JOptionPane.showMessageDialog(null, "Opção inválida!", "Erro", JOptionPane.ERROR_MESSAGE);
					break;
				}
			} else
				JOptionPane.showMessageDialog(null, "Por favor, digite o número da opção!", "Erro",
						JOptionPane.ERROR_MESSAGE);

		} while (option != 9);
	}

	private static boolean isValidInput(String option) {
		return option.matches("\\d");
	}
}
