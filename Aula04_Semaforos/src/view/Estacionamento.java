package view;

import java.util.concurrent.Semaphore;

import controller.ThreadCarro;

public class Estacionamento {

	public static void main(String[] args) {
		int permissoes = 3;

		Semaphore semaphore = new Semaphore(permissoes);
		
		for (int idCarro = 1; idCarro <= 10; idCarro++) {
			Thread carro = new ThreadCarro(idCarro, semaphore);
			carro.start();		
		}

	}
}
