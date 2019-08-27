package processos.ex02.view;

import processos.ex02.controller.ProcessController;

public class Main {

	public static void main(String[] args) {
		ProcessController controller = new ProcessController();

		System.out.println(controller.listAllProcess(controller.getOS()));
	}

}
