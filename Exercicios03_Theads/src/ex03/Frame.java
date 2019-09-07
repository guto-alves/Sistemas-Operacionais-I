package ex03;

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
		setIconImage(Toolkit.getDefaultToolkit().getImage(Frame.class.getResource("/ex03/images/icon.jpg")));
		setTitle("Corrida de Sapos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(900, 600);
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
		bandeiraLabel.setIcon(new ImageIcon(Frame.class.getResource("/ex03/images/chegada.gif")));
		bandeiraLabel.setBounds(703, 0, 171, 172);
		pistaPanel.add(bandeiraLabel);

		JPanel linhaChegadaPanel = new JPanel();
		linhaChegadaPanel.setBackground(Color.RED);
		linhaChegadaPanel.setBounds(800, 11, 21, 496);
		pistaPanel.add(linhaChegadaPanel);

		JLabel sapo1Label = new JLabel();
		sapo1Label.setIcon(new ImageIcon(Frame.class.getResource("/ex03/images/sapo1.png")));
		pistaPanel.add(sapo1Label);

		JLabel sapo2Label = new JLabel();
		sapo2Label.setIcon(new ImageIcon(Frame.class.getResource("/ex03/images/sapo2.png")));
		pistaPanel.add(sapo2Label);

		JLabel sapo3Label = new JLabel();
		sapo3Label.setIcon(new ImageIcon(Frame.class.getResource("/ex03/images/sapo3.png")));
		pistaPanel.add(sapo3Label);

		JLabel sapo4Label = new JLabel();
		sapo4Label.setIcon(new ImageIcon(Frame.class.getResource("/ex03/images/sapo4.png")));
		pistaPanel.add(sapo4Label);

		JLabel sapo5Label = new JLabel();
		sapo5Label.setIcon(new ImageIcon(Frame.class.getResource("/ex03/images/sapo5.png")));
		pistaPanel.add(sapo5Label);

		JLabel[] saposLabels = new JLabel[5];
		saposLabels[0] = sapo1Label;
		saposLabels[1] = sapo2Label;
		saposLabels[2] = sapo3Label;
		saposLabels[3] = sapo4Label;
		saposLabels[4] = sapo5Label;

		JLabel winningSapoLabel = new JLabel();
		winningSapoLabel.setBounds(339, 156, 160, 160);
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
		corrida.create();
	}
}
