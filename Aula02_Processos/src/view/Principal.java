package view;

import controller.ProcController;

public class Principal {

	public static void main(String[] args) {
		ProcController controller = new ProcController();
		System.out.println(controller.getOS());

		String process = "regedit.exe";
		// controller.callProcesso(process);

		// TASKLIST /FO TABLE - Tarefas
		// process = "ping -t www.google.com.br";
		// procController.readProcess(process);

		process = "notepad.exe";
		controller.killProcess(process);
	}

}
