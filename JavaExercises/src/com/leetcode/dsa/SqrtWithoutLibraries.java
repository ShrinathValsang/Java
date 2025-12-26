package com.leetcode.dsa;

public class SqrtWithoutLibraries {

	public static void main(String[] args) {
		// 9 81 10
		//System.out.println(new SqrtWithoutLibraries().sqrt(1600));
//		System.out.println("\nAnswer: " + new SqrtWithoutLibraries().sqrt2(81));
//
//		System.out.println("\nAnswer: " + new SqrtWithoutLibraries().sqrt2(1600));
		System.out.println("\nAnswer: " + new SqrtWithoutLibraries().sqrtFractional(100d));
	}
	
	public int sqrt(int n) {
		if (n < 0) return -1;
		if (n <= 1) return n;
		
		int left = 1, right = n;
		int iterations = 0;
		
		while (left <= right) {
			iterations++;
			int center = (left + right) / 2;
			if (center * center == n) {
				System.out.printf("\nn: %d, sqrt(n)= %d, iterations: %d ", n, right, iterations);
				return center;
			} else if (center * center > n) {
				right--;
				//right = right - 2;
			} else {
				 left++;
			}
		}
		
		System.out.printf("\nn: %d, sqrt(n)= %d, iterations: %d ", n, right, iterations);
		return right;
	}
	
	public int sqrt2(int n) {
		if (n < 0) return -1;
		if (n <= 1) return n;
		
		int left = 1, right = n;
		int iterations = 0;
		
		while (left <= right) {
			iterations++;
			int center = (left + right) / 2;
			if (center * center == n) {
				System.out.printf("n: %d, sqrt(n)= %d, iterations: %d ", n, center, iterations);
				return center;
			} else if (center * center > n) {
				right = center;
			} else {
				 left++;
			}
		}

		System.out.printf("n: %d, sqrt(n)= %d, iterations: %d ", n, right, iterations);
		return right;
	}
	
//	int num = Integer.parseInt(input("Please input an integer to be square rooted."));
//	while(0.0001 < Math.abs(guess * guess - num)){
//	    guess = (guess + num / guess) / 2;
//	}
//	output(Integer.toString(guess));
	
	public double sqrtFractional(double number) {
		if (number < 0) return -1d;
		if (number <= 1) return number;
		
		double d = 0;
		double sq = number / 2;
		System.out.printf("d= %.24f \t sq=%.24f", d, sq);
		do {
			d = sq;
			sq = (d + (number/d))/2;
			System.out.printf("\nd= %.24f \t sq=%.24f", d, sq);
		} while (d - sq != 0);
		
		return -0.0d;
	}

}
