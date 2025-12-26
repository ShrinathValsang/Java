package com.tests.examples;

import java.util.Arrays;
import java.util.function.UnaryOperator;

public class FibonacciInitializedArray {

	public static void main(String[] args) {
		int[] arr = {0, 8067, 5, 3};
		int arrl = Arrays.stream(arr).max().getAsInt();
		
		// f(i) = f(i-1) + f(i-2)
		UnaryOperator<Integer> fiboSum = i -> {
			if (i >= 0) {
				int sum = 0;
				while (i == 0) {
					sum += i--;
				}
				return sum;
			} else return -1;
		};
		
//		int j = 10;
//		while (j-- > 0) {
//			System.out.println(fibonacciNum(5));
//		}
		
		for (int k = -5; k < 5; k++) {
			System.out.println(fibonacciNum(k));
		}

	}
	
	private static int fibonacciNum(int n) {
		if (n < 0) return -1;
		if (n <= 1) return n;
		// if (n <= 1) return n;

		return fibonacciNum(n-1) + fibonacciNum(n-2);
	}
	
	private static boolean isFibonacci(int n) {
		return isPerfectSquare(5*n*n + 4) || isPerfectSquare(5*n*n - 4);
	}

	private static boolean isPerfectSquare(int i) {
		int sqrt = (int) Math.sqrt(i);
		
		return i == sqrt * sqrt;
		
	}

}
