package processos.ex03.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ActionListenerOK implements ActionListener {
	private JTextField textField;
	private JFrame frame;

	public ActionListenerOK(JTextField textField, JFrame frame) {
		this.textField = textField;
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		executeProcess(textField.getText());
	}

	private void executeProcess(String command) {
		try {
			Runtime.getRuntime().exec("cmd /c start " + command);
			frame.dispose();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, String.format(
					"O Windows não pode encontrar '%s'. Certifique-se de que o nome foi digitado corretamente e tente novamente.",
					command), command, JOptionPane.ERROR_MESSAGE);
		}
	}
}
