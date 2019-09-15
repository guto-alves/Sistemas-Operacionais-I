package ex02;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class StreetFrame extends JFrame {
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StreetFrame frame = new StreetFrame();
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
	public StreetFrame() {
		setTitle("Street");
		setSize(new Dimension(679, 700));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel car1JLabel = new JLabel();
		car1JLabel.setIcon(new ImageIcon(StreetFrame.class.getResource("/ex02/images/car_top.png")));
		car1JLabel.setBounds(259, 0, 64, 100);
		contentPane.add(car1JLabel);

		JLabel car2JLabel = new JLabel();
		car2JLabel.setIcon(new ImageIcon(StreetFrame.class.getResource("/ex02/images/car_right.png")));
		car2JLabel.setBounds(571, 260, 100, 64);
		contentPane.add(car2JLabel);

		JLabel car3JLabel = new JLabel();
		car3JLabel.setIcon(new ImageIcon(StreetFrame.class.getResource("/ex02/images/car_bottom.png")));
		car3JLabel.setBounds(367, 571, 64, 100);
		contentPane.add(car3JLabel);

		JLabel car4JLabel = new JLabel();
		car4JLabel.setIcon(new ImageIcon(StreetFrame.class.getResource("/ex02/images/car_left.png")));
		car4JLabel.setBounds(0, 366, 100, 64);
		contentPane.add(car4JLabel);

		JPanel intersectionPanel = new JPanel();
		intersectionPanel.setBackground(Color.LIGHT_GRAY);
		intersectionPanel.setBounds(239, 239, 192, 192);
		contentPane.add(intersectionPanel);
		intersectionPanel.setLayout(null);

		JButton runButton = new JButton("Run");
		runButton.setForeground(Color.WHITE);
		runButton.setBackground(Color.GREEN);
		runButton.setBounds(55, 81, 89, 23);
		runButton.addActionListener(
				new StreetController(runButton, intersectionPanel, car1JLabel, car2JLabel, car3JLabel, car4JLabel));
		intersectionPanel.add(runButton);

		JLabel street1JLabel = new JLabel();
		street1JLabel.setIcon(new ImageIcon(StreetFrame.class.getResource("/ex02/images/bg_street1.jpg")));
		street1JLabel.setBounds(0, 239, 684, 192);
		contentPane.add(street1JLabel);

		JLabel street2JLabel = new JLabel();
		street2JLabel.setIcon(new ImageIcon(StreetFrame.class.getResource("/ex02/images/bg_street2.jpg")));
		street2JLabel.setBounds(239, 0, 192, 671);
		contentPane.add(street2JLabel);

		JLabel rocks1Label = new JLabel();
		rocks1Label.setIcon(new ImageIcon(StreetFrame.class.getResource("/ex02/images/bg_rocks.jpg")));
		rocks1Label.setBounds(0, 0, 239, 239);
		contentPane.add(rocks1Label);

		JLabel label_3 = new JLabel();
		label_3.setIcon(new ImageIcon(StreetFrame.class.getResource("/ex02/images/bg_rocks.jpg")));
		label_3.setBounds(431, 0, 239, 239);
		contentPane.add(label_3);

		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setIcon(new ImageIcon(StreetFrame.class.getResource("/ex02/images/bg_rocks.jpg")));
		lblNewLabel.setBounds(431, 431, 239, 239);
		contentPane.add(lblNewLabel);

		JLabel label_4 = new JLabel();
		label_4.setIcon(new ImageIcon(StreetFrame.class.getResource("/ex02/images/bg_rocks.jpg")));
		label_4.setBounds(0, 431, 239, 239);
		contentPane.add(label_4);
	}
}
