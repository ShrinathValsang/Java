package com.hackerrank.interviewprepkit.warmup;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

/**
 * We define an hourglass in A to be a subset of values with indices falling
 * in this pattern in arr's graphical representation:
 * 
 * 	a b c
 *    d 
 *  e f g
 *  
 * There are 16 hourglasses in arr, and an hourglass sum is the sum of an 
 * hourglass' values. Calculate the hourglass sum for every hourglass in arr
 * , then print the maximum hourglass sum.
 * 
 * (We can use Short instead of Integer)
 *
 */
public class TwoDimArrayHourGlassSum {

//	-9 -9 -9 1 1 1
//	0 -9 0 4 3 2
//	-9 -9 -9 1 2 3
//	0 0 8 6 6 0
//	0 0 0 -2 0 0
//	0 0 1 2 4 0
	
	// Complete the hourglassSum function below.
	static int hourglassSum(int[][] arr) {
		int sum = Integer.MIN_VALUE;
		int row = arr.length;
		int col = arr[0].length;
		
		
		for (int i = 0; i < row-2; i++) {
			for (int j = 0; j < col-2; j++) {
				/*int res = arr[i][j] + arr[i][j+1] + arr[i][j+2] +
				arr[i+1][j+1] + 
				arr[i+2][j] + arr[i+2][j+1] + arr[i+2][j+2]; */
				
				int res = thisHourglassSum(i, j, arr);
				sum = (res > sum) ? res : sum;
			}
		}
		
		return sum;
	}
	
	private static int thisHourglassSum(int i, int j, int[][] arr) {
		int sum = Integer.MIN_VALUE;
		for (int k=j; k <= j+2; k++) {
			sum = sum + arr[i][k];
			sum = sum + arr[i+2][k];
		}
		
		sum = sum + arr[i+1][j+1];
		return sum;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
//		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//		int[][] arr = new int[6][6];
//
//		for (int i = 0; i < 6; i++) {
//			String[] arrRowItems = scanner.nextLine().split(" ");
//			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//			for (int j = 0; j < 6; j++) {
//				int arrItem = Integer.parseInt(arrRowItems[j]);
//				arr[i][j] = arrItem;
//			}
//		}


		int[][] grid = {
		{1, 1, 1, 0, 0, 0},
		{0, 1, 0, 0, 0, 0},
		{1, 1, 1, 0, 0, 0},
		{0, 0, 2, 4, 4, 0},
		{0, 0, 0, 2, 0, 0},
		{0, 0, 1, 2, 4, 0}};
		
		int result = hourglassSum(grid);
		System.out.println(result);

//		bufferedWriter.write(String.valueOf(result));
//		bufferedWriter.newLine();
//
//		bufferedWriter.close();
//
//		scanner.close();
	}
}
