package ex01;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class Main {

	public static void main(String[] args) {
		Semaphore semaphore = new Semaphore(1);

		ExecutorService executorService = Executors.newCachedThreadPool();

		for (int id = 1; id <= 4; id++) {
			People people = new People(id, semaphore);
			executorService.execute(people);
		}

		executorService.shutdown();
	}

}
