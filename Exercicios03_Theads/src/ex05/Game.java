package ex05;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.JTextField;

public class Game extends MouseAdapter implements Listener {
	private final int TOTAL_FIGURES = 3;
	private Figure[] figures = new Figure[TOTAL_FIGURES];

	private boolean running = false;
	private int conterOfFiguresRunning = 0;

	private JTextField[] textFields;

	public Game(JTextField... textFields) {
		this.textFields = textFields;

		for (int i = 0; i < TOTAL_FIGURES; i++)
			figures[i] = new Figure(textFields[i], this);
	}

	public void start() {
		running = true;

		ExecutorService executorService = Executors.newCachedThreadPool();

		for (int i = 0; i < TOTAL_FIGURES; i++)
			executorService.execute(figures[i]);

		executorService.shutdown();
	}

	public void stop() {
		running = false;
		conterOfFiguresRunning = 0;
	}

	@Override
	public void finished() {
		if (++conterOfFiguresRunning == textFields.length)
			stop();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int xPos = e.getX();
		int yPos = e.getY();

		if ((xPos > 521 && xPos < 557) && (yPos > 44 && yPos < 80)) {
			if (!running)
				start();
		}
	}

}
