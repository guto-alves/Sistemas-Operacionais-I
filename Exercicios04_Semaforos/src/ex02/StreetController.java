package ex02;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

import javax.swing.JLabel;

public class StreetController {
	private Semaphore semaphore;

	static final int SEMAPHORE_LOCAL = 180;

	public enum Direction {
		RIGHT, UP, LEFT, DOWN
	};

	private JLabel[] jLabels;

	public StreetController() {
		semaphore = new Semaphore(1);
	}

	public StreetController(JLabel... jLabels) {
		this.jLabels = jLabels;
		semaphore = new Semaphore(1);
	}

	public void runCars() {
		ExecutorService executorService = Executors.newCachedThreadPool();

		Car[] cars = new Car[4];
		cars[0] = new Car(Direction.DOWN, jLabels[0], semaphore);
		cars[1] = new Car(Direction.LEFT, jLabels[1], semaphore);
		cars[2] = new Car(Direction.UP, jLabels[2], semaphore);
		cars[3] = new Car(Direction.RIGHT, jLabels[3], semaphore);

		for (int i = 0; i < 4; i++)
			executorService.execute(cars[i]);

		executorService.shutdown();
	}

}
