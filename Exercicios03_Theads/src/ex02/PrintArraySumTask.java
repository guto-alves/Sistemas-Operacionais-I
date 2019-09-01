package ex02;

import java.util.stream.IntStream;

public class PrintArraySumTask implements Runnable {
	private int row;
	private int[] array;

	public PrintArraySumTask(int row, int[] array) {
		this.row = row;
		this.array = array;
	}

	@Override
	public void run() {
		System.out.printf("Row %d -> Sum = %d%n", row, IntStream.of(array).sum());
	}

}
