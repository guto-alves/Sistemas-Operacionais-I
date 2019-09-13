package ex02;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;
import java.awt.Color;
import javax.swing.JLabel;

public class StreetFrame extends JFrame {

	private JPanel contentPane;

	private StreetController streetController;

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
		setSize(new Dimension(600, 500));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel car1JLabel = new JLabel("C1");
		car1JLabel.setBounds(250, 11, 20, 14);
		contentPane.add(car1JLabel);

		JLabel car2JLabel = new JLabel("C2");
		car2JLabel.setBounds(536, 226, 20, 14);
		contentPane.add(car2JLabel);

		JLabel car3JLabel = new JLabel("C3");
		car3JLabel.setBounds(290, 436, 20, 14);
		contentPane.add(car3JLabel);

		JLabel car4JLabel = new JLabel("C4");
		car4JLabel.setBounds(10, 194, 20, 14);
		contentPane.add(car4JLabel);

		JPanel panel = new JPanel();
		panel.setBackground(Color.CYAN);
		panel.setBounds(240, 180, 70, 70);
		contentPane.add(panel);

		streetController = new StreetController(car1JLabel, car2JLabel, car3JLabel, car4JLabel);
		
		streetController.runCars();
	}
}
