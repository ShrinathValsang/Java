package com.generic;

/**
 * Dynamic programming with memoization (example - fibonacci series)
 * 
 * Time comparison of both examples with and without memoization is done in the
 * example.
 */
public class FibonacciSpaceOptimized {

	public static void main(String[] args) {
		//long start = System.nanoTime();
		//long timeElapsed = System.nanoTime() - start;
		
		int n = 10;
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
		
		System.out.println();
		n = 10;
		long start2 = System.nanoTime();
		int sum2 = fibWithMemo(n, new int[n+1]);
		long elapsed2 = System.nanoTime() - start2;
		System.out.format("\n1 fib (space optimized) %d => %d, time taken: %d", n, sum2, elapsed2);
		
		long start3 = System.nanoTime();
		int sum3 = fibWithMemo(n, new int[n+1]);
		long elapsed3 = System.nanoTime() - start3;
		System.out.format("\n1 fib (memoized) %d => %d, time taken: %d", n, sum3, elapsed3);
		
		n = 100;
		long start4 = System.nanoTime();
		int sum4 = fibWithMemo(n, new int[n+1]);
		long elapsed4 = System.nanoTime() - start4;
		System.out.format("\n2 fib (space optimized) %d => %d, time taken: %d", n, sum4, elapsed4);
		
		long start5 = System.nanoTime();
		int sum5 = fibWithMemo(n, new int[n+1]);
		long elapsed5 = System.nanoTime() - start5;
		System.out.format("\n2 fib (memoized) %d => %d, time taken: %d", n, sum5, elapsed5);
		
		n = 1000;
		long start6 = System.nanoTime();
		int sum6 = fibWithMemo(n, new int[n+1]);
		long elapsed6 = System.nanoTime() - start6;
		System.out.format("\n3 fib (space optimized) %d => %d, time taken: %d", n, sum6, elapsed6);
		
		long start7 = System.nanoTime();
		int sum7 = fibWithMemo(n, new int[n+1]);
		long elapsed7 = System.nanoTime() - start7;
		System.out.format("\n3 fib (memoized) %d => %d, time taken: %d", n, sum7, elapsed7);
		
		n = 2000;
		long start8 = System.nanoTime();
		int sum8 = fibWithMemo(n, new int[n+1]);
		long elapsed8 = System.nanoTime() - start8;
		System.out.format("\n4 fib (space optimized) %d => %d, time taken: %d", n, sum8, elapsed8);
		
		long start9 = System.nanoTime();
		int sum9 = fibWithMemo(n, new int[n+1]);
		long elapsed9 = System.nanoTime() - start9;
		System.out.format("\n4 fib (memoized) %d => %d, time taken: %d", n, sum9, elapsed9);
		
		n = 10000;
		long start10 = System.nanoTime();
		int sum10 = fibWithMemo(n, new int[n+1]);
		long elapsed10 = System.nanoTime() - start10;
		System.out.format("\n4 fib (space optimized) %d => %d, time taken: %d", n, sum10, elapsed10);
		
		long start11 = System.nanoTime();
		int sum11 = fibWithMemo(n, new int[n+1]);
		long elapsed11 = System.nanoTime() - start11;
		System.out.format("\n4 fib (memoized) %d => %d, time taken: %d", n, sum11, elapsed11);
	}

	static int i = 0;
	private static int fib(int n) {
		i++;
		int a = 0, b = 1, c = 0;
		if (n <= 1)
			return n;
		
		for (int i = 2; i <= n; i++) {
			c = a + b;
			a = b;
			b = c;
		}
		
		return c;
	}

	static int i1 = 0;
	private static int fibWithMemo(int n, int[] memo) {
		i1++;
		/*int a = 0, b = 1, c = 0;
		if (n <= 1)
			return n;
		
		for (int i = 2; i <= n; i++) {
			memo[n] = a + b;
			a = b;
			b = c;
		}
		
		return memo[n];*/
	
		
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
