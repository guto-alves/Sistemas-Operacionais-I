package view;

import java.security.SecureRandom;

import controller.ThreadSeq;

public class Main {

	public static void main(String[] args) {
		// int a = 10;
		// int b = 2;
		//
		// for (int op = 0; op < 4; op++) {
		//	 Thread thread = new ThreadCalc(a, b, op);
		//	 thread.start();
		// }

		int[] array = new SecureRandom().ints(10, 100000, 200000).toArray();

		for (int i : array) {
			Thread thread = new ThreadSeq(i);
			thread.start();
		}
	}
}
