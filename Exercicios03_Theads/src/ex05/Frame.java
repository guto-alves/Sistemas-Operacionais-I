package ex05;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class Frame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(new Dimension(640, 350));
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textField = new JTextField();
		textField.setBounds(141, 98, 85, 130);
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setFont(new Font("Serif", Font.BOLD, 50));
		textField.setHorizontalAlignment(JTextField.CENTER);
		contentPane.add(textField);

		textField_1 = new JTextField();
		textField_1.setBounds(245, 98, 83, 130);
		textField_1.setEditable(false);
		textField_1.setFont(new Font("Serif", Font.BOLD, 50));
		textField_1.setHorizontalAlignment(JTextField.CENTER);
		textField_1.setColumns(10);
		contentPane.add(textField_1);

		textField_2 = new JTextField();
		textField_2.setBounds(350, 98, 89, 130);
		textField_2.setHorizontalAlignment(JTextField.CENTER);
		textField_2.setFont(new Font("Serif", Font.BOLD, 50));
		textField_2.setEditable(false);

		textField_2.setColumns(10);
		contentPane.add(textField_2);

		JLabel slotMachineLabel = new JLabel();
		slotMachineLabel.setIcon(new ImageIcon(Frame.class.getResource("/ex05/images/slot_machine.jpg")));
		slotMachineLabel.setBounds(0, 0, 624, 311);
		slotMachineLabel.addMouseListener(new Game(textField, textField_1, textField_2));
		contentPane.add(slotMachineLabel);
	}
}
