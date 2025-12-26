package com.interviews;

@FunctionalInterface
interface MyBiFunction<T, U, R> {
	R apply(T t, U u);
}

public class LongestSubarrayTargetSum {

	public static void main(String[] args) {
		int[] arr = {15, 4, 1, -3, -1, 5, -2, 7, -3, 4, 2, -5};
		int targetSum = 5;
		
		int longestSubarray = getLongestSubarrayWithTargetsum(arr, targetSum);
	}
	
	

	private static int getLongestSubarrayWithTargetsum(int[] arr, int targetSum) {
		
		MyBiFunction<Integer, Integer, Integer> myFunction = (a, b) -> a + b;
		
		MyBiFunction<Integer, Integer, Integer> add = (a, b) -> a + b; 
		System.out.println("Sum: " + add.apply(10, 20)); 
		
		// Example 2: Concatenate two strings 
		MyBiFunction<String, String, String> concat = (s1, s2) -> s1 + s2; 
		System.out.println("Concat: " + concat.apply("Hello ", "Shrinath"));
		
		
		return 0;
	}

}
