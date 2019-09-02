package ex05;

import java.security.SecureRandom;

import javax.swing.JTextField;

public class Figure implements Runnable {
	private final SecureRandom random = new SecureRandom();

	private final int MAX_GIROS = 150;

	private int currentNumber = 1;

	private JTextField textField;

	private Listener listener;

	public Figure(JTextField textField, Listener listener) {
		this.textField = textField;
		this.listener = listener;
	}

	@Override
	public void run() {
		int giros = random.nextInt(MAX_GIROS) + 1;

		for (int i = 0; i < giros; i++) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
				e.printStackTrace();
			}

			textField.setText(String.valueOf(currentNumber));

			currentNumber = currentNumber + 1 > 7 ? 1 : ++currentNumber;
		}

		listener.finished();
	}

}
