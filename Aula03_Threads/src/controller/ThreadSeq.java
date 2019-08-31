package controller;

public class ThreadSeq extends Thread {
	private int n;

	public ThreadSeq(int n) {
		this.n = n;
	}

	@Override
	public void run() {
		calcularSerie();
	}

	private void calcularSerie() {
		double result = 0;
		boolean flag = true;

		for (int i = 1; i < n; i += 2) {
			if (flag) {
				result += (double) 1 / i;
				flag = false;
			} else {
				result -= (double) 1 / i;
				flag = true;
			}
		}

		System.out.printf("Resultado da série com %d: %f%n", n, result * 4);
	}
}
