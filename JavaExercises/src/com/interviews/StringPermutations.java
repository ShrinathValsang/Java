package com.interviews;


/**
 * OPUS Technologies (for Mastercard) Sanjay Mehta 28th Oct 24
 * Find out all the permutations of characters in a given string.
 */
public class StringPermutations {

	public static void main(String[] args) {
		System.out.println("All permutations of string are : ");
		permutations("ABC", "");
	}
	
	public static void permutations(String str, String prefix) {
		if (str.isEmpty()) {
			System.out.println(prefix);
		} else {
			for (int i = 0; i < str.length(); i++) {
				char ch = str.charAt(i);
				String remaining = str.substring(0, i) + str.substring(i+1);
				permutations(remaining, prefix + ch);	
			}
		}
	}

}
