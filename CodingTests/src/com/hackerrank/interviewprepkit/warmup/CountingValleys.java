package com.hackerrank.interviewprepkit.warmup;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

/**
 * Roger is an avid hiker. He tracks his hikes meticulously, paying close 
 * attention to small details like topography. During his last hike he took 
 * exactly n steps. For every step he took, he noted if it was an uphill,
 * U, or a downhill, D step. Gary's hikes start and end at sea level and 
 * each step up or down represents a  unit change in altitude. 
 * 
 * We define the following terms:
 * n: the number of steps Gary takes
 * s: a string describing his path (uphill downhill)
 * Input Format
 * 
 * Sample Input:
 * 8
 * UDDDUDUU
 * Sample Output
 * 1
 * 
 */
public class CountingValleys {

	// Complete the countingValleys function below.
	static int countingValleys(int n, String s) {
		int count = 0, sl = 0;
		
		char[] arr = s.toCharArray();
		
		for (char c : arr) {
			if (c == 'U') {
				// when you come "UP" to sea level (i.e. sl from -1 to 0) 
				// then increase valley count
				if (sl == -1) { 
					count++;
				}
				sl += 1;
			} else if (c == 'D') {
				sl -= 1;
			}
		}
		
		return count;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		/*BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		String s = scanner.nextLine();

		int result = countingValleys(n, s);

		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();
		bufferedWriter.close();
		scanner.close();*/
		
		int result = countingValleys(8, "UDDDUDUU");
		int result2 = countingValleys(8, "DDUUDDUDUUUD");
		
		System.out.println(result);
		System.out.println(result2);
	}
}
