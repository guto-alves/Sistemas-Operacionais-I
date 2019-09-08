package ex03_version2;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Toolkit;
import javax.swing.JTable;

public class Frame extends JFrame {
	private JPanel contentPane;
	private Corrida corrida;

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

	public Frame() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Frame.class.getResource("/ex03_version2/images/icon.jpg")));
		setTitle("Corrida de Sapos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(900, 700);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel pistaPanel = new JPanel();
		pistaPanel.setBackground(Color.WHITE);
		contentPane.add(pistaPanel, BorderLayout.CENTER);
		pistaPanel.setLayout(null);

		JLabel bandeiraLabel = new JLabel();
		bandeiraLabel.setIcon(new ImageIcon(Frame.class.getResource("/ex03_version2/images/chegada.gif")));
		bandeiraLabel.setBounds(703, 0, 171, 172);
		pistaPanel.add(bandeiraLabel);

		JPanel linhaChegadaPanel = new JPanel();
		linhaChegadaPanel.setBackground(Color.RED);
		linhaChegadaPanel.setBounds(800, 11, 21, 629);
		pistaPanel.add(linhaChegadaPanel);

		JLabel sapo1Label = new JLabel();
		sapo1Label.setIcon(new ImageIcon(Frame.class.getResource("/ex03_version2/images/frog.gif")));
		sapo1Label.setBounds(10, 145, 100, 73);
		pistaPanel.add(sapo1Label);

		JLabel sapo2Label = new JLabel();
		sapo2Label.setIcon(new ImageIcon(Frame.class.getResource("/ex03_version2/images/frog.gif")));
		sapo2Label.setBounds(10, 229, 100, 73);
		pistaPanel.add(sapo2Label);

		JLabel sapo3Label = new JLabel();
		sapo3Label.setIcon(new ImageIcon(Frame.class.getResource("/ex03_version2/images/frog.gif")));
		sapo3Label.setBounds(10, 315, 100, 73);
		pistaPanel.add(sapo3Label);

		JLabel sapo4Label = new JLabel();
		sapo4Label.setIcon(new ImageIcon(Frame.class.getResource("/ex03_version2/images/frog.gif")));
		sapo4Label.setBounds(10, 414, 100, 73);
		pistaPanel.add(sapo4Label);

		JLabel sapo5Label = new JLabel();
		sapo5Label.setIcon(new ImageIcon(Frame.class.getResource("/ex03_version2/images/frog.gif")));
		sapo5Label.setBounds(10, 498, 100, 73);
		pistaPanel.add(sapo5Label);

		JLabel[] saposLabels = new JLabel[5];
		saposLabels[0] = sapo1Label;
		saposLabels[1] = sapo2Label;
		saposLabels[2] = sapo3Label;
		saposLabels[3] = sapo4Label;
		saposLabels[4] = sapo5Label;

		JLabel winningSapoLabel = new JLabel();
		winningSapoLabel.setBounds(339, 156, 160, 160);
		winningSapoLabel.setIcon(new ImageIcon(Frame.class.getResource("/ex03_version2/images/winner_frog.gif")));
		winningSapoLabel.setVisible(false);
		pistaPanel.add(winningSapoLabel);

		JPanel controlPanel = new JPanel();
		controlPanel.setBackground(Color.ORANGE);
		contentPane.add(controlPanel, BorderLayout.SOUTH);

		DefaultTableModel tableModel = new DefaultTableModel();
		JTable table = new JTable(tableModel);
		table.setCellSelectionEnabled(false);

		JButton startButton = new JButton("START!");
		startButton.setBackground(Color.GREEN);
		startButton.setForeground(Color.WHITE);
		startButton.addActionListener(event -> {
			if (startButton.getText().equals("START!"))
				corrida.start();
			else
				corrida.create();

			repaint();
		});

		controlPanel.add(startButton);
		controlPanel.add(table);

		corrida = new Corrida(saposLabels, winningSapoLabel, tableModel, startButton);

		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 385, 800, 4);
		pistaPanel.add(panel);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 299, 800, 5);
		pistaPanel.add(panel_1);
		panel_1.setBackground(Color.BLACK);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.BLACK);
		panel_2.setBounds(0, 214, 800, 5);
		pistaPanel.add(panel_2);

		JPanel panel_3 = new JPanel();
		panel_3.setBounds(0, 485, 800, 5);
		pistaPanel.add(panel_3);
		panel_3.setBackground(Color.BLACK);

		JPanel panel_4 = new JPanel();
		panel_4.setBounds(0, 570, 800, 5);
		pistaPanel.add(panel_4);
		panel_4.setBackground(Color.BLACK);

		JLabel label = new JLabel("1");
		label.setBounds(0, 174, 20, 14);
		pistaPanel.add(label);

		JLabel label_1 = new JLabel("2");
		label_1.setBounds(0, 251, 20, 14);
		pistaPanel.add(label_1);

		JLabel label_2 = new JLabel("3");
		label_2.setBounds(0, 337, 20, 14);
		pistaPanel.add(label_2);

		JLabel label_3 = new JLabel("4");
		label_3.setBounds(0, 430, 20, 14);
		pistaPanel.add(label_3);

		JLabel label_4 = new JLabel("5");
		label_4.setBounds(0, 521, 20, 14);
		pistaPanel.add(label_4);
		corrida.create();
	}
}
