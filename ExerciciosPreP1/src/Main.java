import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter a um number: ");
		int number = scanner.nextInt();
		scanner.close();

		FactotialTask factotialTask = new FactotialTask(number);
		FactorialRecursiveTask factorialRecursiveTask = new FactorialRecursiveTask(number);

		ExecutorService executorService = Executors.newCachedThreadPool();

		executorService.execute(factorialRecursiveTask);
		executorService.execute(factotialTask);

		executorService.shutdown();
	}

}
