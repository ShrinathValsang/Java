package com.hackerrank.interviewprepkit.warmup;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

/**
 * Large pile of socks that he must pair by color for sale. 
 * Given an array of integers representing the color of each sock, 
 * determine how many pairs of socks with matching colors there are.
 * For example, there are n=6 socks with colors int[] arr = [3, 1, 3, 2, 1, 6].
 * There is one pair of color 3 and one of color 1. There are two odd 
 * socks left, one of each color 2 and 6. The number of pairs is 2. 
 *
 */
public class SockMerchantNoOfPairs {

	// Complete the sockMerchant function below.
	static int sockMerchant(int n, int[] ar) {
		Set<Integer> colours = new HashSet<>();
		int pairs = 0;		

		for (int i : ar) {
			if (colours.contains(i)) {
				pairs++;
				colours.remove(i);
			} else {
				colours.add(i);
			}
		}
		
		return pairs;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		int[] ar = new int[n];

		String[] arItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < n; i++) {
			int arItem = Integer.parseInt(arItems[i]);
			ar[i] = arItem;
		}

		int result = sockMerchant(n, ar);

		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();

		bufferedWriter.close();

		scanner.close();
	}
}
