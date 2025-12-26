package com.medium.javarevisited.dsa.array;

import java.util.List;
import java.util.stream.IntStream;

/**
 * How do you find all pairs of an integer array whose sum is equal to a given number?
 * 
 */
public class Q4_PairSumInArray {

	public static void main(String[] args) {
		// this produces unmodifiable collection
		List<Integer> list = IntStream.range(1, 101).boxed().toList();
		
		int sum = 21;
		int[] arr = { 10, 3, 19, 8, 11, 20, 6, 12, 17, 24, 7, 14, 18, 01 };
		
		IntStream.range(0, arr.length).forEach(x -> 
			IntStream.range(x, arr.length).forEach(y -> {
				if (x != y && arr[x] + arr[y] == sum) {
					System.out.print("{" + arr[x] + ", " + arr[y] +"} ");
				}
			})
		);	
		
	}

}
