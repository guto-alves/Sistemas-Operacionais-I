package ex05;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class Frame extends JFrame {
	private JPanel contentPane;

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
		setIconImage(Toolkit.getDefaultToolkit().getImage(Frame.class.getResource("/ex05/images/icon.png")));
		setTitle("Slot Machine");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(new Dimension(640, 350));
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel label = new JLabel();
		label.setBounds(135, 115, 95, 95);
		contentPane.add(label);

		JLabel label_1 = new JLabel();
		label_1.setBounds(240, 115, 95, 95);
		contentPane.add(label_1);

		JLabel label_2 = new JLabel();
		label_2.setBounds(345, 115, 95, 95);
		contentPane.add(label_2);

		JLabel slotMachineLabel = new JLabel();
		slotMachineLabel.setIcon(new ImageIcon(Frame.class.getResource("/ex05/images/slot_machine.jpg")));
		slotMachineLabel.addMouseListener(new Game(label, label_1, label_2));
		slotMachineLabel.setBounds(0, 0, 624, 311);
		contentPane.add(slotMachineLabel);
	}
}
