package processos.ex03.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import processos.ex03.controller.ActionListenerCancel;
import processos.ex03.controller.ActionListenerOK;
import processos.ex03.controller.ActionListenerSearch;

import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.Font;

public class Frame extends JFrame {
	private JPanel contentPane;
	private JTextField textField;
	private JButton btnOK;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame frame = new Frame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Frame() {
		setTitle("Executar");
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Frame.class.getResource("/processos/ex03/image/logo.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(10, 509, 415, 215);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblIcon = new JLabel("");
		lblIcon.setIcon(new ImageIcon(Frame.class.getResource("/processos/ex03/image/icon_logo.png")));
		lblIcon.setBounds(12, 15, 48, 39);
		contentPane.add(lblIcon);

		JLabel lblDescription1 = new JLabel("Digite o nome de um programa, pasta, documento ou");
		lblDescription1.setFont(new Font("Arial", Font.PLAIN, 12));
		lblDescription1.setBounds(76, 20, 306, 16);
		contentPane.add(lblDescription1);

		JLabel lblDescription2 = new JLabel("recurso da Internet e o Windows o abrirá para você.");
		lblDescription2.setFont(new Font("Arial", Font.PLAIN, 12));
		lblDescription2.setBounds(76, 35, 306, 16);
		contentPane.add(lblDescription2);

		JLabel lblAbrir = new JLabel("Abrir:");
		lblAbrir.setFont(new Font("Arial", Font.PLAIN, 12));
		lblAbrir.setBounds(20, 73, 48, 14);
		contentPane.add(lblAbrir);

		textField = new JTextField();
		textField.setBounds(76, 69, 306, 23);
		textField.setColumns(10);
		textField.addActionListener(new ActionListenerOK(textField, this));
		textField.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
				if (textField.getText().isEmpty())
					btnOK.setEnabled(false);
				else
					btnOK.setEnabled(true);
			}

			@Override
			public void keyPressed(KeyEvent e) {
			}
		});
		contentPane.add(textField);

		JPanel panelButtons = new JPanel();
		panelButtons.setBounds(0, 109, 409, 77);
		panelButtons.setLayout(null);
		contentPane.add(panelButtons);

		btnOK = new JButton("OK");
		btnOK.setEnabled(false);
		btnOK.setBounds(74, 22, 89, 23);
		btnOK.addActionListener(new ActionListenerOK(textField, this));
		panelButtons.add(btnOK);

		JButton btnCancel = new JButton("Cancelar");
		btnCancel.setBounds(173, 22, 89, 23);
		btnCancel.addActionListener(new ActionListenerCancel(this));
		panelButtons.add(btnCancel);

		JButton btnSearch = new JButton("Procurar...");
		btnSearch.setBounds(272, 22, 89, 23);
		btnSearch.addActionListener(new ActionListenerSearch(this, textField, btnOK));
		panelButtons.add(btnSearch);
	}
}
