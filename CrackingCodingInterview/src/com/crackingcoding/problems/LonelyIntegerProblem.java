package com.crackingcoding.problems;

/**
 * Lonely integer problem using bit manipulation.
 * XORing all the integers gives the result
 * 
 * https://www.youtube.com/watch?v=eXWjCgbL01U
 *
 */
public class LonelyIntegerProblem {

	public static void main(String[] args) {
		int[] arr = {4, 3, 8, 1, 7, 3, 1, 4, 7};
		int loneInt = findLonelyInteger(arr);
		System.out.println("Lonely integer: " + loneInt);
	}

	private static int findLonelyInteger(int[] arr) {
		if (arr.length % 2 == 0) { // or or more than one lonely integers
			return -1;
		}
		
		int loneInt = 0;
		for (int i : arr) {
			loneInt = loneInt ^ i; 
		}
		
		return loneInt;
	}

}
