package ex03_version2;

import java.security.SecureRandom;

import javax.swing.JLabel;

public class Sapo implements Runnable {
	private final int SALTO_MAX = 20;

	private int id;
	private JLabel sapoLabel;

	private TermineiCorridaListener listener;

	public Sapo(int id, JLabel sapoLabel, TermineiCorridaListener listener) {
		this.id = id;
		this.sapoLabel = sapoLabel;
		this.listener = listener;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public void run() {
		SecureRandom random = new SecureRandom();

		while (true) {
			int x = sapoLabel.getX();

			int salto = random.nextInt(SALTO_MAX);

			sapoLabel.setBounds(x + salto, sapoLabel.getY(), sapoLabel.getWidth(), sapoLabel.getHeight());

			if (x + sapoLabel.getWidth() >= Corrida.FIM_CORRIDA) {
				sapoLabel.setVisible(false);
				listener.terminei(this);
				break;
			}

			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
				e.printStackTrace();
			}
		}
	}
}
