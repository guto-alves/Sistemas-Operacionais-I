package processos.ex02.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.table.DefaultTableModel;

public class UpdateTableListener implements ActionListener {
	private DefaultTableModel tableModel;

	public UpdateTableListener(DefaultTableModel tableModel) {
		this.tableModel = tableModel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		updateProcessList();
	}

	public void updateProcessList() {
		ProcessController controller = new ProcessController();
		controller.listAllProcesses(tableModel, controller.getOS());
	}
}
