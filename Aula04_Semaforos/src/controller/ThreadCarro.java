package controller;

import java.util.concurrent.Semaphore;

public class ThreadCarro extends Thread {
	private int idCarro;
	private static int posChegada;
	private static int posSaida;
	private Semaphore semaphore;

	public ThreadCarro(int idCarro, Semaphore semaphore) {
		this.idCarro = idCarro;
		this.semaphore = semaphore;
	}

	@Override
	public void run() {
		carroAndando();
		try {
			if (!semaphore.tryAcquire()) {
				System.out.println("Carro #" + idCarro + " na fila");
				semaphore.acquire();
			}

			carroEstacionado();
			carroSaindo();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaphore.release();
		}
	}

	private void carroAndando() {
		int distanciaFinal = (int) ((Math.random() * 1001) + 1000);
		int distanciaPercorrida = 0;

		int variacaoDistancia = 100;
		int tempo = 100;

		while (distanciaPercorrida <= distanciaFinal) {
			distanciaPercorrida += variacaoDistancia;
			try {
				Thread.sleep(tempo);
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
				e.printStackTrace();
			}

			// System.out.println("Carro #" + idCarro + " percorreu " + distanciaPercorrida
			// + "m.");
		}

		posChegada++;
		System.out.println("Carro #" + idCarro + " foi o " + posChegada + "o. a chegar");
	}

	private void carroEstacionado() {
		System.out.println("Carro #" + idCarro + " entrou");
		int tempoParado = (int) ((Math.random() * 1001) + 1000);

		try {
			Thread.sleep(tempoParado);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
			e.printStackTrace();
		}
	}

	private void carroSaindo() {
		posSaida++;
		System.out.println("Carro #" + idCarro + " foi o " + posSaida + "o. a sair");
	}
}
