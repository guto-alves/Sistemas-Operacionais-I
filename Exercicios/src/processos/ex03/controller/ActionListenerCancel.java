package processos.ex03.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class ActionListenerCancel implements ActionListener {
	private JFrame frame;

	public ActionListenerCancel(JFrame frame) {
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		frame.dispose();
	}
}
