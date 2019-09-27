package ex04;

public class FactotialTask implements Runnable {
	private int number;

	public FactotialTask(int number) {
		this.number = number;
	}

	@Override
	public void run() {
		long initialTime = System.nanoTime();

		double result = factorial(number);

		long finalTime = System.nanoTime();

		long time = finalTime - initialTime;

		System.out.println(String.format("Normal:\n\t%d! = %,.0f \n\ttime = %d nano", number, result, time));
	}

	private double factorial(int number) {
		double result = 1;

		for (int i = number; i > 1; i--)
			result *= i;

		return result;
	}

}
