package ex02;

import java.awt.Rectangle;
import java.security.SecureRandom;
import java.util.concurrent.Semaphore;

import javax.swing.JLabel;

import ex02.StreetController.Direction;

public class Car implements Runnable {
	private final SecureRandom random = new SecureRandom();

	private Direction direction;
	private JLabel carJLabel;
	private Rectangle carRectangle;

	private Semaphore semaphore;

	private Listener listener;

	public Car(Direction direction, JLabel carJLabel, Semaphore semaphore, Listener listener) {
		this.direction = direction;
		this.carJLabel = carJLabel;
		this.semaphore = semaphore;
		this.listener = listener;

		carRectangle = carJLabel.getBounds();
	}

	@Override
	public void run() {
		runNormal();

		try {
			semaphore.acquire();
			runInTheCrosswalk();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaphore.release();
		}

		runNormal();
	}

	private void runNormal() {
		while (!isIntersection()) {
			move(random.nextInt(4) + 5);

			carJLabel.setBounds(carRectangle);

			if (isFinish()) {
				listener.callback();
				break;
			}

			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
				e.printStackTrace();
			}
		}
	}

	private void runInTheCrosswalk() {
		while (isIntersection()) {
			move(random.nextInt(2) + 3);

			carJLabel.setBounds(carRectangle);

			try {
				Thread.sleep(60);
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
				e.printStackTrace();
			}
		}
	}

	private void move(int displacement) {
		switch (direction) {
		case RIGHT:
			carRectangle.x += displacement;
			break;
		case UP:
			carRectangle.y -= displacement;
			break;
		case LEFT:
			carRectangle.x -= displacement;
			break;
		case DOWN:
			carRectangle.y += displacement;
			break;
		}
	}

	private boolean isIntersection() {
		return carRectangle.intersects(StreetController.intersectionRectangle);
	}

	private boolean isFinish() {
		return carRectangle.x < -100 || carRectangle.x > 700 || carRectangle.y < -100 || carRectangle.y > 700;
	}
}
