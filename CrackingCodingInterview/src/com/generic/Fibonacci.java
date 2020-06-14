package com.generic;

public class Fibonacci {

	public static void main(String[] args) {
		//long start = System.nanoTime();
		//long timeElapsed = System.nanoTime() - start;
		
		int n = 4;
		System.out.format("\nfib %d => %d", n, fib(n));
		System.out.format("\nfibWithMemo %d => %d", n, fibWithMemo(n, new int[n+1]));
		
		// Performance test of non-memoized and memoized solutions
		n = 10;
		System.out.print("\n\nPerformance test of non-memoized and memoized solutions");
		long start = System.nanoTime();
		int sum = fib(n);
		long elapsed = System.nanoTime() - start;
		System.out.format("\nfib (non-memoized) %d => %d, time taken: %d", n, sum, elapsed);
		
		n = 10;
		long start1 = System.nanoTime();
		int sum1 = fibWithMemo(n, new int[n+1]);
		long elapsed1 = System.nanoTime() - start1;
		System.out.format("\nfib (memoized) %d => %d, time taken: %d", n, sum1, elapsed1);
	}

	private static int fib(int n) {
		if (n <= 0) {
			return 0;
		} else if (n == 1) {
			return 1;
		} else {
			return fib(n-1) + fib(n-2);
		}
	}

	private static int fibWithMemo(int n, int[] memo) {
		if (n <= 0) {
			return 0;
		} else if (n == 1) {
			return 1;
		} else if (memo[n] == 0){
			memo[n] = fibWithMemo(n-1, memo) + fibWithMemo(n-2, memo);
		}
		
		return memo[n];
	}
	
	//private static int[] memo = new int[n+1];
	/*private static int fibWithMemo1(int n) {
		while (n >= 0) {
			if (n <= 0) {
				memo[0] = 0;
			} else if (n == 1) {
				memo[0] = 1;
			} else if (memo[n] == 0) {
				memo[n] = fibWithMemo1(n-1) + fibWithMemo1(n-2);  
			}
			
			fibWithMemo1(--n);
		}
		
		return 0;
	}*/

}
