package ex01;

import java.security.SecureRandom;
import java.util.concurrent.Semaphore;

public class People implements Runnable {
	private final SecureRandom random = new SecureRandom();

	private int id;
	private Semaphore semaphore;

	public People(int id, Semaphore semaphore) {
		this.id = id;
		this.semaphore = semaphore;
	}

	@Override
	public void run() {
		andar();

		try {
			if (!semaphore.tryAcquire()) {
				esperar();
				semaphore.acquire();
			}

			passarPelaPorta();

		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaphore.release();
		}
	}

	private void andar() {
		final int PORTA = 200;

		int distanciaPercorrida = 0;

		while ((distanciaPercorrida += random.nextInt(3) + 4) < PORTA) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			System.out.printf("Pessoa #%d percorreu %dm%n", id, distanciaPercorrida);
		}

		System.out.printf("Pessoa #%d chegou na porta%n", id);
	}

	private void esperar() {
		System.out.printf("Pessoa #%d está esperando na frente da porta%n", id);
	}

	private void passarPelaPorta() {
		System.out.printf("Pessoa #%d passando pela porta%n", id);

		int tempoParaAbrirPorta = random.nextInt(1001) + 1000;

		try {
			Thread.sleep(tempoParaAbrirPorta);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
			e.printStackTrace();
		}

		System.out.printf("Pessoa #%d passou!%n", id);
	}

}
