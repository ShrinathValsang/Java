package com.crackingcoding.problems;

import java.io.IOException;

/**
 * Given two strings the class returns how many characters do we need 
 * to remove from either to make them anagrams.
 * 
 * e.g. HELLO and BILLION - HE--- and BI--I-N = 6 letters
 * 
 * 
 * https://www.youtube.com/watch?v=eXWjCgbL01U
 *
 */
public class AnagramProblemOfTwoStrings {

	/**
	 * No of English alphabets. Approach - case insensitive.
	 * 
	 * If we want to consider more number of characters other than just 
	 * alphabets, we can choose HashMaps for storing characters and their
	 * number of occurrence in a string.
	 * 
	 * 
	 * https://www.youtube.com/watch?v=3MwRGPPB4tw
	 * 
	 */
	private static final int CHARACTERS = 26;

	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		String first = br.readLine();
//		String second = br.readLine();
//		System.out.println(numberNeeded(first, second));
		
		System.out.println(numberNeeded("hello", "billion"));
	}

	private static int numberNeeded(String first, String second) {
		int [] charCounts1 = getCharCounts(first);
		int [] charCounts2 = getCharCounts(second);
		int delta = getCharDelta(charCounts1, charCounts2);
		
		return delta;
	}

	private static int[] getCharCounts(String first) {
		int[] arr = new int[CHARACTERS];
	
		for (int i = 0; i < first.length(); i++) {
			char c = first.charAt(i);
			int p = c - 'a';
			arr[p]++;
		}
		
		return arr;
	}

	private static int getCharDelta(int[] charCounts1, int[] charCounts2) {
		if (charCounts1.length != charCounts2.length) return -1;
		
		int delta = 0;
		for (int j = 0; j < charCounts1.length; j++) {
			int diff = Math.abs(charCounts1[j] - charCounts2[j]);
			delta += diff;
		}
		
		return delta;
	}

}
