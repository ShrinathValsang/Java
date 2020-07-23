package com.hackerrank.interviewprepkit.warmup;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

/**
 * Emma is playing a new mobile game that starts with consecutively 
 * numbered clouds. Some of the clouds are thunderheads and others are 
 * cumulus. She can jump on any cumulus cloud having a number that is 
 * equal to the number of the current cloud plus 1 or 2. She must avoid 
 * the thunderheads. Determine the minimum number of jumps it will take
 * Emma to jump from her starting postion to the last cloud. It is always
 * possible to win the game.
 * 
 * For each game, Emma will get an array of clouds numbered 0 if they are
 * safe or 1 if they must be avoided. For example, c = [0, 1, 0, 0, 0, 1, 0]
 * indexed from . The number on each cloud is its index in the list so she 
 * must avoid the clouds at indexes  and . She could follow the following 
 * two paths: 0 -> 2 -> 4 -> 6 or 0 -> 2 -> 3 -> 4 -> 6.
 * 
 * The first path takes 3 jumps while the second takes 4.
 * 
 * c[0]=c[n-1]= 0 **important
 * 
 */
public class JumpingOnTheClouds {

	// Complete the jumpingOnClouds function below.
	static int jumpingOnClouds(int[] c) {
		int jmps = -1;
		
		for (int i = 0; i < c.length; i++, jmps++) {
			if ((i+2) < c.length && c[i+2] == 0) {
				i++;
			} /*else {
				break; // two consecutive thunderheads, no jumps possible.
			}*/
		}
		
		return jmps;
	}
	
	static int jumpingOnClouds1(int[] c) { // my solution
		int jmps = 0, l = c.length;
		
		for (int i = 0; i < (c.length-1); i++) {
			if ((i+2) < c.length && c[i+2] == 0) {
				jmps++;
				i++;
			} else if (c[i+1] == 0) {
				jmps++;
			} else {
				break; // two consecutive thunderheads, no jumps possible.
			}
		}
		
		return jmps;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		/*BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		int[] c = new int[n];

		String[] cItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < n; i++) {
			int cItem = Integer.parseInt(cItems[i]);
			c[i] = cItem;
		}

		int[] c = {0, 1, 0, 0, 0, 1, 0};
		int result = jumpingOnClouds(c);

		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();

		bufferedWriter.close();

		scanner.close();*/
		

		int[] c1 = {0, 1, 0, 0, 0, 1, 0};
		int result = jumpingOnClouds(c1);
		System.out.println(result);
		
		int[] c2 = {0, 0, 1, 0, 0, 1, 0};
		int result2 = jumpingOnClouds(c2);
		System.out.println(result2);
		
		int[] c3 = {0, 0, 0, 1, 0, 0};
		int result3 = jumpingOnClouds(c3);
		System.out.println(result3);
 }
}

