package ex04;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import javax.swing.border.LineBorder;

public class Frame extends JFrame {
	private JPanel contentPane;

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
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Frame.class.getResource("/ex04/images/bandeiras.png")));
		setTitle("Corrida de Carros");
		setSize(new Dimension(700, 350));
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel car1Label = new JLabel();
		car1Label.setIcon(new ImageIcon(Frame.class.getResource("/ex04/images/car1.gif")));
		car1Label.setBounds(10, 11, 100, 100);
		contentPane.add(car1Label);

		JLabel car2Label = new JLabel();
		car2Label.setIcon(new ImageIcon(Frame.class.getResource("/ex04/images/car2.gif")));
		car2Label.setBounds(10, 110, 100, 100);
		contentPane.add(car2Label);

		JLabel linhaChegadaLabel = new JLabel();
		linhaChegadaLabel.setIcon(new ImageIcon(Frame.class.getResource("/ex04/images/linha_chegada.jpg")));
		linhaChegadaLabel.setBounds(621, 0, 63, 220);
		contentPane.add(linhaChegadaLabel);

		JLabel bgRuaLabel = new JLabel();
		bgRuaLabel.setIcon(new ImageIcon(Frame.class.getResource("/ex04/images/bg_rua.jpg")));
		bgRuaLabel.setBounds(0, 0, 626, 220);
		contentPane.add(bgRuaLabel);

		JPanel controlPanel = new JPanel();
		controlPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		controlPanel.setBackground(Color.WHITE);
		controlPanel.setBounds(0, 221, 684, 90);
		controlPanel.setLayout(null);
		contentPane.add(controlPanel);

		JButton runButton = new JButton("Correr");
		runButton.setBounds(146, 27, 72, 31);
		controlPanel.add(runButton);

		JLabel lblVencedor = new JLabel("Vencedor");
		lblVencedor.setForeground(Color.GREEN);
		lblVencedor.setBounds(310, 25, 64, 14);
		controlPanel.add(lblVencedor);

		JTextField winnerTextField = new JTextField();
		winnerTextField.setBounds(372, 22, 96, 20);
		winnerTextField.setHorizontalAlignment(JTextField.CENTER);
		winnerTextField.setEditable(false);
		winnerTextField.setColumns(10);
		controlPanel.add(winnerTextField);

		JLabel lblPerdedor = new JLabel("Perdedor");
		lblPerdedor.setForeground(Color.RED);
		lblPerdedor.setBounds(310, 53, 64, 14);
		controlPanel.add(lblPerdedor);

		JTextField loserTextField = new JTextField();
		loserTextField.setBounds(372, 53, 96, 20);
		loserTextField.setHorizontalAlignment(JTextField.CENTER);
		loserTextField.setEditable(false);
		loserTextField.setColumns(10);
		controlPanel.add(loserTextField);

		runButton.addActionListener(new Race(car1Label, car2Label, runButton, winnerTextField, loserTextField));
	}
}
