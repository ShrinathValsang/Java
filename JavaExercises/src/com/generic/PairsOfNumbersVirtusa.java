package com.generic;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
/*

5 2  
1 5 3 4 2 

 */
public class PairsOfNumbersVirtusa {

	// Complete the pairs function below.
	static int pairs(int k, int[] arr) {
		int pairs = 0;
		Arrays.sort(arr);
		Set<Integer> set = new HashSet<>();

		for (int i=0; i < arr.length; i++) {
			set.add(arr[i]);
			if (set.contains(arr[i] - k)) {
				pairs++;
			}
		}

		return pairs;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
//		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
		String[] nk = scanner.nextLine().split(" ");
		int n = Integer.parseInt(nk[0]);
		int k = Integer.parseInt(nk[1]);
		int[] arr = new int[n];

		String[] arrItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < n; i++) {
			int arrItem = Integer.parseInt(arrItems[i]);
			arr[i] = arrItem;
		}

		int result = pairs(k, arr);
		System.out.println(result);
//		bufferedWriter.write(String.valueOf(result));
//		bufferedWriter.newLine();
//		bufferedWriter.close();

		scanner.close();
	}
}

