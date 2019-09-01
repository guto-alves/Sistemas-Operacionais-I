package processos.ex02.view;

import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import processos.ex02.controller.KillProcessListener;
import processos.ex02.controller.UpdateTableListener;

import java.awt.FlowLayout;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Font;
import javax.swing.border.EtchedBorder;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import java.awt.BorderLayout;

public class Frame extends JFrame {
	private JPanel contentPane;
	private JTextField nameOrPIDTextField;
	private JTable table;
	private DefaultTableModel tableModel = new DefaultTableModel();

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
		setTitle("Process Killer");
		setSize(new Dimension(750, 600));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel tablePanel = new JPanel();
		tablePanel.setBounds(10, 11, 711, 396);
		tablePanel.setLayout(new BorderLayout(0, 0));
		contentPane.add(tablePanel);

		table = new JTable(tableModel);
		tablePanel.add(new JScrollPane(table), BorderLayout.CENTER);

		JButton refreshButton = new JButton("");
		refreshButton.setBackground(Color.WHITE);
		refreshButton.setIcon(new ImageIcon(Frame.class.getResource("/processos/ex02/image/refresh.png")));
		refreshButton.setBounds(357, 408, 53, 53);
		refreshButton.addActionListener(new UpdateTableListener(tableModel));
		contentPane.add(refreshButton);

		JPanel killZonePanel = new JPanel();
		killZonePanel.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "KILL ZONE",
				TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 255, 255)));
		killZonePanel.setBackground(new Color(255, 0, 0));
		killZonePanel.setBounds(0, 465, 744, 96);
		contentPane.add(killZonePanel);

		JLabel matarProcessoLabel = new JLabel("Processo:");
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
		rdbtnNome.setSelected(true);
		radioButtonsPanel.add(rdbtnNome);

		JRadioButton rdbtnPid = new JRadioButton("PID");
		radioButtonsPanel.add(rdbtnPid);
		ButtonGroup group = new ButtonGroup();
		group.add(rdbtnPid);
		group.add(rdbtnNome);

		JButton killProcessButton = new JButton("");
		killProcessButton.setIcon(new ImageIcon(Frame.class.getResource("/processos/ex02/image/death.png")));
		killProcessButton.addActionListener(new KillProcessListener(nameOrPIDTextField, rdbtnNome, rdbtnPid));
		killZonePanel.add(killProcessButton);
	}
}
