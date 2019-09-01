package ex01;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newCachedThreadPool();

		for (int i = 0; i < 5; i++)
			executorService.execute(new PrintTask(i));

		executorService.shutdown();
	}

}
