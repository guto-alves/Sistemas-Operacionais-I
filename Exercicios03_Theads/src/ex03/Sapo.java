package ex03;

import java.security.SecureRandom;

import javax.swing.JLabel;

public class Sapo implements Runnable {
	public static final String COR_VERDE = "Verde";
	public static final String COR_VERMELHO = "Vermelho";
	public static final String COR_AZUL = "Azul";
	public static final String COR_PRETO = "Preto";
	public static final String COR_LARANJA = "Laranja";

	private final int SALTO_MAX = 60;

	private JLabel sapoLabel;
	private String cor;
	private TermineiCorridaListener listener;

	public Sapo(JLabel sapoLabel, TermineiCorridaListener listener) {
		this.sapoLabel = sapoLabel;
		this.listener = listener;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
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
				Thread.sleep(250);
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
				e.printStackTrace();
			}
		}
	}
}
