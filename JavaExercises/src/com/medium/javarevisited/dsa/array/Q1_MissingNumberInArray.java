package com.medium.javarevisited.dsa.array;

import java.util.Arrays;
import java.util.stream.IntStream;


/**
 * How do you find the missing number in a given integer array of 1 to 100?
 * 
 */
public class Q1_MissingNumberInArray {

	public static void main(String[] args) {
		final int[] arr = new int[100];
		// method 1
		IntStream.range(0, arr.length).forEach(i -> arr[i] = i+1);
		
		// method 2 - more simpler
		int[] arr1 = IntStream.range(1, 101).toArray();
		arr[66] = 0;
		
		// calculate sum of numbers 1-100
		// sum = no. of termns * (low + high) / 2
		int sum = 100 * (1 + 100) / 2;
		int arraySum = IntStream.of(arr).parallel().sum(); Arrays.stream(arr).sum();
		int missing = sum - arraySum;
		System.out.println("Missing number: " + missing);
		

	}

}
