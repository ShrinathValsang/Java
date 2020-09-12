package com.generic;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

/*
2
hello
world
hi
world

*/
public class TwoStrings {

	// Complete the twoStrings function below.
	static String twoStrings(String s1, String s2) {
		String s, l;
		
		if (s1.length() > s2.length()) {
			l = s1.toLowerCase();
			s = s2.toLowerCase();
		} else {
			l = s2.toLowerCase();
			s = s1.toLowerCase();
		}

		final int ENG_ALPHABETS = 26;
		boolean[] exists = new boolean[ENG_ALPHABETS];
		char[] ar = s.toCharArray();

		for (char c : ar) {
			exists[c - 'a'] = true;
		}

		for (int i = 0; i < l.length(); i++) {
			if (exists[l.charAt(i) - 'a']) {
				return "YES";
			}
		}

		return "NO";
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
//		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int q = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int qItr = 0; qItr < q; qItr++) {
			String s1 = scanner.nextLine();
			String s2 = scanner.nextLine();

			String result = twoStrings(s1, s2);
			System.out.println(result);

//			bufferedWriter.write(result);
//			bufferedWriter.newLine();
		}

//		bufferedWriter.close();

		scanner.close();
	}
}

