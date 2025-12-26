package com.crackingcoding.problems;

/**
 * Dynamic programming - 1. simple 2. space optimized and 3. memoization 
 * 
 */
public class FibonacciDPSpaceOptimizedAndMemoization {

	public static void main(String[] args) throws Exception {
		//long start = System.nanoTime();
		//long timeElapsed = System.nanoTime() - start;
//		long sum111 = fibSimple(10000);
		
//		int n = 10;
//		long start = System.nanoTime();
//		long sum = fibSimple(n);
//		long elapsed = System.nanoTime() - start;
//		System.out.format("\n1 fibSimple %d => %d, time taken: %d", n, sum, elapsed);
//
//		long sum0 = fibSpaceOptimized(n);
//		System.out.format("\n1 fibSpaceOptimized %d => %d", n, sum0);

		int n = 50;
		long start1 = System.nanoTime();
		long sum00 = fibRecursive(n);
		long elapsed1 = System.nanoTime() - start1;
		System.out.format("\n1 fibRecursive %d => %d, time taken: %d", n, sum00, elapsed1);

		long sum01 = fibSpaceOptimized(n);
		System.out.format("\n1 fibSpaceOptimized %d => %d", n, sum01);

		long sum02 = fib(n);
		System.out.format("\n1 fib %d => %d", n, sum02);
		
	}
	
	// infinite loop
	public static long fibRecursive(int n) {
		if (n < 2) return n;
		if (n < 0) return 0;
		
		long temp1 = fibRecursive(n-1);
		long temp2 = fibRecursive(n-2);
		return temp1 + temp2;
	}
	
	public static long fibSpaceOptimized(int n) {
		long a = 0, b = 1, c = 0;
		// c = a + b [1], a = b, b = c 
		
		while (n-- > 1) {
			c = a + b;
			a = b;
			b = c;
		}
		
		return c;
	}
	
	// mostly same as above impl -- fibSpaceOptimized
	private static long fib(int n) {
		long a = 0, b = 1, c = 0;
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
	
	public long fibonacciWithoutCornerCase(int n) {
		if (n == 0 || n == 1) return n;
		return (fibonacci(n-1) + fibonacci(n-2));
	}
	
	public long fibonacci(int n) {
		long fib = 0;
		if (n > -1) {
			if (n < 2) return n;
			
			fib = (fibonacci(n-1) + fibonacci(n-2));
		}
		
		return fib;
	}

	// THIS IS WRONG! fn = fn-1 + fn-2 ... f0
	/*public static long fibSimple(int n) throws Exception {
		long fibSum = 0;
		while (n > 0) {
			fibSum += n;
			n--;
		}
		
		return fibSum;
	}*/
	


}

//static int i = 0;
//// WRONG! -- infinite loop
//private static int fibSimple1(int n) throws Exception {
//	if (n < -1) return 0;
//	if (n == 0 || n == 1) return n;
//	
//	return fibSimple1(n-1) + fibSimple1(n-1);
//}
