package processos.ex03.controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ActionListenerSearch implements ActionListener {
	private JTextField textField;
	private Component parent;
	private JButton btnOK;

	public ActionListenerSearch(Component parent, JTextField textField, JButton btnOK) {
		this.textField = textField;
		this.parent = parent;
		this.btnOK = btnOK;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setDialogTitle("Procurar");
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		fileChooser.setFileFilter(new FileNameExtensionFilter("Programas", "exe"));
		fileChooser.setAcceptAllFileFilterUsed(false);
		int result = fileChooser.showOpenDialog(parent);

		if (result == JFileChooser.APPROVE_OPTION) {
			textField.setText(fileChooser.getSelectedFile().getAbsolutePath());
			btnOK.setEnabled(true);
		}
	}
}
