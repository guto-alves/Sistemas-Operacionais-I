package ex02;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class StreetController implements ActionListener, Listener {
	public static Rectangle intersectionRectangle;

	private Semaphore semaphore;

	private static int CARS_ON_THE_STREET;
	private JButton runButton;

	public enum Direction {
		RIGHT, UP, LEFT, DOWN
	};

	private JLabel[] carsJLabels;

	public StreetController(JButton runButton, JPanel intersectionPanel, JLabel... carsJLabels) {
		this.runButton = runButton;
		intersectionRectangle = intersectionPanel.getBounds();
		this.carsJLabels = carsJLabels;
		semaphore = new Semaphore(1);
	}

	public void runCars() {
		runButton.setVisible(false);
		runButton.setText("Again");
		CARS_ON_THE_STREET = 4;

		carsJLabels[0].setBounds(259, 0, 64, 100);
		carsJLabels[1].setBounds(571, 260, 100, 64);
		carsJLabels[2].setBounds(367, 571, 64, 100);
		carsJLabels[3].setBounds(0, 366, 100, 64);

		Car[] cars = new Car[4];

		cars[0] = new Car(Direction.DOWN, carsJLabels[0], semaphore, this);
		cars[1] = new Car(Direction.LEFT, carsJLabels[1], semaphore, this);
		cars[2] = new Car(Direction.UP, carsJLabels[2], semaphore, this);
		cars[3] = new Car(Direction.RIGHT, carsJLabels[3], semaphore, this);

		ExecutorService executorService = Executors.newCachedThreadPool();

		for (int i = 0; i < 4; i++)
			executorService.execute(cars[i]);

		executorService.shutdown();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		runCars();
	}

	@Override
	public void callback() {
		if (--CARS_ON_THE_STREET == 0)
			runButton.setVisible(true);
	}

}
