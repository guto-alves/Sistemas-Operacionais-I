package ex02;

import java.security.SecureRandom;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

	public static void main(String[] args) {
		SecureRandom random = new SecureRandom();

		int[][] array = new int[3][5];

		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[0].length; j++)
				array[i][j] = random.nextInt(10);
		}

		ExecutorService executorService = Executors.newCachedThreadPool();

		int numberOfRow = 0;

		for (int[] row : array)
			executorService.execute(new PrintArraySumTask(numberOfRow++, row));

		executorService.shutdown();
	}

}
