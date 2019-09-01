package processos.ex02.view;

import javax.swing.JOptionPane;

import processos.ex02.controller.ProcessController;

public class Main {
	private static ProcessController processController = new ProcessController();

	public static void main(String[] args) {
		int option = 0;

		do {
			String input = JOptionPane.showInputDialog(null,
					"Digite o número da opção:\n\n1 - Listar Processos.\n" + "2 - Matar Processo\n" + "9 - Sair.",
					"Menu Principal", JOptionPane.QUESTION_MESSAGE);

			if (isValidInput(input)) {
				option = Integer.parseInt(input);

				switch (option) {
				case 1:
					processController.listAllProcess();
					break;
				case 2:
					displayViewKillProcess();
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

	public static void displayViewKillProcess() {
		while (true) {
			String input = JOptionPane.showInputDialog(null, "Digite o nome ou PID do processo para matar-lo: ",
					"Matar Processo", JOptionPane.QUESTION_MESSAGE);

			if (input == null)
				return;

			processController.killProcess(input);
		}
	}

	private static boolean isValidInput(String input) {
		return input.matches("\\d");
	}
}
