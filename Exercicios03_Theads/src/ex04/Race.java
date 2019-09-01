package ex04;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Race implements ActionListener, FinishedRaceListener {
	public static final int DISTANCIA = 600;
	private static final int TOTAL_CARROS = 2;

	private JLabel car1Label, car2Label;

	private List<Car> rankingCars = new ArrayList<>();

	private JTextField winnerTextField, loserTextField;
	private JButton runButton;

	public Race(JLabel car1, JLabel car2, JButton runButton, JTextField winnerTextField, JTextField loserTextField) {
		this.car1Label = car1;
		this.car2Label = car2;
		this.runButton = runButton;
		this.winnerTextField = winnerTextField;
		this.loserTextField = loserTextField;
	}

	public void start() {
		runButton.setVisible(false);

		car1Label.setBounds(10, 11, 100, 100);
		car2Label.setBounds(10, 110, 100, 100);

		winnerTextField.setText("");
		loserTextField.setText("");

		ExecutorService executorService = Executors.newCachedThreadPool();

		Car car1 = new Car("Ônibus", car1Label, this);
		Car car2 = new Car("Carro", car2Label, this);

		executorService.execute(car1);
		executorService.execute(car2);

		executorService.shutdown();
	}

	public void stop() {
		runButton.setVisible(true);

		winnerTextField.setText(rankingCars.get(0).getName());
		loserTextField.setText(rankingCars.get(1).getName());

		rankingCars.clear();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		start();
	}

	@Override
	public void finished(Car car) {
		rankingCars.add(car);

		if (rankingCars.size() == TOTAL_CARROS)
			stop();
	}
}
