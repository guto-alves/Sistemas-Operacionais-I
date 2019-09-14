package ex05;

import java.security.SecureRandom;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Figure implements Runnable {
	private final SecureRandom random = new SecureRandom();

	private final int MAX_GIROS = 150;

	private final int TOTAL_FIGURES = 7;
	private String[] figures = new String[TOTAL_FIGURES];
	private int currentFigureIndex;

	private JLabel figureLabel;

	private Listener listener;

	public Figure(JLabel figureLabel, Listener listener) {
		this.figureLabel = figureLabel;
		this.listener = listener;

		figures[0] = "/ex05/images/rules_p1.png";
		figures[1] = "/ex05/images/rules_p2.png";
		figures[2] = "/ex05/images/rules_p3.png";
		figures[3] = "/ex05/images/rules_p4.png";
		figures[4] = "/ex05/images/rules_p5.png";
		figures[5] = "/ex05/images/rules_p6.png";
		figures[6] = "/ex05/images/rules_p7.png";

		currentFigureIndex = random.nextInt(TOTAL_FIGURES);
		this.figureLabel.setIcon(new ImageIcon(getClass().getResource(figures[currentFigureIndex])));
	}

	@Override
	public void run() {
		int giros = random.nextInt(MAX_GIROS) + 1;

		for (int i = 0; i < giros; i++) {
			try {
				Thread.sleep(giros - i <= 3 ? 150 : 50);
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
				e.printStackTrace();
			}

			currentFigureIndex = (currentFigureIndex + 1) % TOTAL_FIGURES;

			figureLabel.setIcon(new ImageIcon(getClass().getResource(figures[currentFigureIndex])));
		}

		listener.finished();
	}

}
