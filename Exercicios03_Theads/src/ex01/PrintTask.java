package ex01;

public class PrintTask implements Runnable {
	private int taskNumber;

	public PrintTask(int taskNumber) {
		this.taskNumber = taskNumber;
	}

	@Override
	public void run() {
		System.out.println(taskNumber);
	}

}
