package processos.ex02.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;

import processos.ex02.controller.ProcessController;

import java.awt.FlowLayout;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Font;
import javax.swing.border.EtchedBorder;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class Frame extends JFrame {
	private JPanel contentPane;
	private JTextArea processesTextArea;
	private JTextField nameOrPIDTextField;

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
		setSize(new Dimension(450, 600));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		processesTextArea = new JTextArea();
		processesTextArea.setAutoscrolls(true);
		processesTextArea.setBounds(0, 5, 434, 401);
		contentPane.add(processesTextArea);

		JButton refreshButton = new JButton("");
		refreshButton.setBackground(Color.WHITE);
		refreshButton.setIcon(new ImageIcon(Frame.class.getResource("/processos/ex02/image/refresh.png")));
		refreshButton.setBounds(357, 408, 53, 53);
		refreshButton.addActionListener(event -> {
			String result = new ProcessController().listAllProcess(ProcessController.WINDOWS_OS);
			processesTextArea.setText(result);
		});
		contentPane.add(refreshButton);

		JPanel killZonePanel = new JPanel();
		killZonePanel.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "KILL ZONE",
				TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 255, 255)));
		killZonePanel.setBackground(new Color(255, 0, 0));
		killZonePanel.setBounds(0, 465, 434, 96);
		contentPane.add(killZonePanel);

		JLabel matarProcessoLabel = new JLabel("Matar Processo:");
		matarProcessoLabel.setFont(new Font("Calibri Light", Font.PLAIN, 14));
		matarProcessoLabel.setForeground(Color.WHITE);
		killZonePanel.add(matarProcessoLabel);

		nameOrPIDTextField = new JTextField();
		killZonePanel.add(nameOrPIDTextField);
		nameOrPIDTextField.setColumns(15);

		JPanel radioButtonsPanel = new JPanel();
		radioButtonsPanel.setBackground(Color.RED);
		killZonePanel.add(radioButtonsPanel);
		radioButtonsPanel.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Por",
				TitledBorder.LEADING, TitledBorder.TOP, null, Color.WHITE));
		radioButtonsPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JRadioButton rdbtnNome = new JRadioButton("Nome");
		radioButtonsPanel.add(rdbtnNome);

		JRadioButton rdbtnPid = new JRadioButton("PID");
		radioButtonsPanel.add(rdbtnPid);
		ButtonGroup group = new ButtonGroup();
		group.add(rdbtnPid);
		group.add(rdbtnNome);
	}
}
