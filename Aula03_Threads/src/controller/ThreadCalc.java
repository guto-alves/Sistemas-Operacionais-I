package controller;

public class ThreadCalc extends Thread {
	private int a;
	private int b;
	private int op;

	public ThreadCalc(int a, int b, int op) {
		this.a = a;
		this.b = b;
		this.op = op;
	}

	@Override
	public void run() {
		calcular();
	}

	private void calcular() {
		try {
			Thread.sleep(op * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		int resultado = 0;
		String operacao = "";

		switch (op) {
		case 0:
			resultado = a + b;
			operacao = "+";
			break;
		case 1:
			resultado = a - b;
			operacao = "-";
			break;
		case 2:
			resultado = a * b;
			operacao = "*";
			break;
		case 3:
			resultado = a / b;
			operacao = "/";
			break;
		}

		System.out.printf("%d %s %d = %d%n", a, operacao, b, resultado);
	}
}
