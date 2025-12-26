package com.grokking.codinginterviewpatterns;


public class ValidPalindrome {
	
	public static void main(String...strings) {
		String s = "ababababa";
		System.out.println(s + " palindrome? - " + isPalindrome(s));
	}
	
	public static boolean isPalindrome(String s) {
		int start = 0, end = s.length() - 1;

		for (int i = 0; i < s.length()/2; i++) {
			if (s.charAt(i) != s.charAt(end - i))
				return false;
		}

		// Replace this placeholder return statement with your code
		return true;
	}
}
