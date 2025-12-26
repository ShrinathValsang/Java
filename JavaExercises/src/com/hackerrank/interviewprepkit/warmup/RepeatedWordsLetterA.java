package com.hackerrank.interviewprepkit.warmup;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Program to find occurrence of a letter (not a string) in a sentence. 
 * 
 * Lilah has a string, s, of lowercase English letters that she repeated 
 * infinitely many times.
 * Given an integer, n, find and print the number of letter a's in 
 * the first n letters of Lilah's infinite string.
 * 
 * For example, if the string s='abcac' and n=10, the substring we consider 
 * is 'abcacabcac', the first 10 characters of her infinite string. There 
 * are 4 occurrences of a in the substring. (See samples below)
 * 
 * 
 * Sample 1:
 * input: aba 10
 * output: 7 
 * 
 * Sample 2:
 * input: a 10000000000
 * output: 10000000000
 * 
 * 
 */
public class RepeatedWordsLetterA {

	private static int getOccurrencesOfA(String s) {
		int occOfA = 0;
		char[] sarr = s.toCharArray();
		for (char c : sarr) {
			if (c == 'a') 
				occOfA++;
		}

		return occOfA;
	}
	
	// Complete the repeatedString function below.
	static long repeatedString(String s, long n) {
		long res = 0;
		int l = s.length(); // length of string s
		
		if (l >= n) {
			res = getOccurrencesOfA(s.substring(0, (int) n));
		} else {
			long occ = getOccurrencesOfA(s); 
			long q = n / l;
			int end = (int) (n - q * l);
			
			if (occ > 0) {
				res = q * occ + getOccurrencesOfA(s.substring(0, end));
			}
		}
		
		return res;
	}

	static long repeatedString1(String s, long n) {
		long res = 0;
		int l = s.length(); // length of string s
		
		if (l >= n) {
			res = getOccurrencesOfA(s.substring(0, (int) n));
		} else {
			int occ = getOccurrencesOfA(s); 
			int q = (int) (n / l);
			int end = (int) n - (q * l);
			
			if (occ > 0) {
				res = q * occ + getOccurrencesOfA(s.substring(0, end));
			}
		}
		
		return res;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		/*BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		String s = scanner.nextLine();

		long n = scanner.nextLong();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?"); */

		int n = 105;
		String s = "abcdeabcd";
		
		long result = repeatedString(s, n);
		System.out.println(result);
		
		long nl = 1000000000000L;
		result = repeatedString("a", nl);
		System.out.println(result);

		/*bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();

		bufferedWriter.close();

		scanner.close();/*/ 
	}		

}
