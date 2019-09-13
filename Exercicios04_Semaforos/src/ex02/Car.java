package ex02;

import java.awt.Rectangle;
import java.security.SecureRandom;
import java.util.concurrent.Semaphore;

import javax.swing.JLabel;

import ex02.StreetController.Direction;

public class Car implements Runnable {
	private Direction direction;
	private JLabel carJLabel;
	private Semaphore semaphore;

	public Car(Direction direction, JLabel carJLabel, Semaphore semaphore) {
		this.direction = direction;
		this.carJLabel = carJLabel;
		this.semaphore = semaphore;
	}

	@Override
	public void run() {
		walk();

		try {
			semaphore.acquire();
			passarNaFixaDePedestre();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaphore.release();
		}
	}

	private void walk() {
		SecureRandom random = new SecureRandom();

		int travelledDistance = 0;

		Rectangle rectangle;

		while (true) {
			rectangle = carJLabel.getBounds();

			travelledDistance += random.nextInt(2) + 1;

			switch (direction) {
			case RIGHT:
				rectangle.x += travelledDistance;
				break;
			case UP:
				rectangle.y -= travelledDistance;
				break;
			case LEFT:
				rectangle.x -= travelledDistance;
				break;
			case DOWN:
				rectangle.y += travelledDistance;
				break;
			}

			carJLabel.setBounds(rectangle);

			if (isFaixa(rectangle))
				break;

			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
				e.printStackTrace();
			}
		}
	}

	private void passarNaFixaDePedestre() {
		SecureRandom random = new SecureRandom();

		int travelledDistance = 0;

		Rectangle rectangle;

		while (isFaixa(rectangle = carJLabel.getBounds())) {
			travelledDistance += random.nextInt(2) + 3;

			try {
				Thread.sleep(350);
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
				e.printStackTrace();
			}

			switch (direction) {
			case RIGHT:
				rectangle.x += travelledDistance;
				break;
			case UP:
				rectangle.y -= travelledDistance;
				break;
			case LEFT:
				rectangle.x -= travelledDistance;
				break;
			case DOWN:
				rectangle.y += travelledDistance;
				break;
			}

			carJLabel.setBounds(rectangle);
		}
	}

	private boolean isFaixa(Rectangle rectangle) {
		if ((rectangle.x >= 200 && rectangle.x <= 320) && (rectangle.y >= 150 && rectangle.y <= 260))
			return true;
		else
			return false;
	}

}
