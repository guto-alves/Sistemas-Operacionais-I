
public class FactorialRecursiveTask implements Runnable {
	private int number;

	public FactorialRecursiveTask(int number) {
		this.number = number;
	}

	@Override
	public void run() {
		long initialTime = System.nanoTime();

		double result = factorial(number);

		long finalTime = System.nanoTime();

		long time = finalTime - initialTime;

		System.out.println(String.format("Recursive:\n\t%d! = %,.0f \n\ttime = %d nano", number, result, time));
	}

	private double factorial(int number) {
		if (number < 0)
			throw new IllegalArgumentException("Exception: argument invalid");

		return number < 1 ? 1 : number * factorial(number - 1);
	}

}
