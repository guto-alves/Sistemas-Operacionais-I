package processos.ex02.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class KillProcessListener implements ActionListener {
	private JTextField textField;
	private JRadioButton nameRadioButton, pidRadioButton;

	private ProcessController controller;

	public KillProcessListener(JTextField textField, JRadioButton nameRadioButton, JRadioButton pidRadioButton) {
		this.textField = textField;
		this.nameRadioButton = nameRadioButton;
		this.pidRadioButton = pidRadioButton;
		controller = new ProcessController();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String process = textField.getText();

		if (!process.isEmpty()) {
			if (nameRadioButton.isSelected())
				controller.killProcess(controller.getOS(), process);
			else
				controller.killProcess(controller.getOS(), process);

			textField.setText("");
			JOptionPane.showMessageDialog(null, "Fatality!");
		}
	}
}
