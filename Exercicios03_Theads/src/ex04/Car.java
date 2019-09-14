package ex04;

import java.awt.Rectangle;
import java.security.SecureRandom;

import javax.swing.JLabel;

public class Car implements Runnable {
	private int velocidadeMaxima = 20;
	private JLabel carLabel;

	private String name; // id from car

	private FinishedRaceListener finishedRaceListener;

	public Car(String name, JLabel carJLabel, FinishedRaceListener finishedRaceListener) {
		this.name = name;
		this.carLabel = carJLabel;
		this.finishedRaceListener = finishedRaceListener;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		SecureRandom random = new SecureRandom();

		Rectangle rectangle = carLabel.getBounds();

		while (rectangle.x + rectangle.width < Race.DISTANCIA_FINAL) {
			int deslocamento = random.nextInt(velocidadeMaxima);

			rectangle.x += deslocamento;

			carLabel.setBounds(rectangle);

			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
				e.printStackTrace();
			}
		}

		finishedRaceListener.finished(this);
	}

}
