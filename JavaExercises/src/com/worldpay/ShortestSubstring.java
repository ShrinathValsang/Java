package com.worldpay;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Worldpay Hackerrank 26 Sept 2025
 * Coding Question 1 - Shortest Substring with unique characters
 * 
 * 
 * Given a string, find the shortest substring that satisfies a specific condition 
 * (e.g., contains all unique characters of the string, occurs only once, etc.).
 */
public class ShortestSubstring {

	public static void main(String[] args) {
		String s = "abcbbck"; //abcabcbb";
		String res = shortestSubstring(s);
		System.out.println(res);
	}
	
	public static String shortestSubstring(String s) {
		int sl = s.length();
		int minlen = Integer.MAX_VALUE; // why MAX length? should be just string length?
		String result = "";
		
		for (int left = 0; left < sl; left++) {
			for (int right = left; right < sl; right++) {
				StringBuilder rem = new StringBuilder(s);
				rem.delete(left, right + 1);
				
				if (hasAllUniqueCharacters(rem.toString())) {
					int len = right - left + 1;
					if (len < minlen) {
						minlen = len;
						result = s.substring(left, right + 1);
					}
				}
			}
		}
		
		
		return result;
	}
	private  static boolean hasAllUniqueCharacters(String str) {
		Set<Character> seen = new HashSet<>();
		for (char ch : str.toCharArray()) {
			if (!seen.add(ch)) 
				return false;
		}
		return true;
	}

	public static int shortestSubstring1(String s) {
		Set<Character> uniChars = new HashSet<>();
		s.chars().mapToObj(c -> (char) c).forEach(uniChars::add);
		
		int req = uniChars.size();
		Map<Character, Integer> windowCounts = new HashMap<>();
		int left = 0, right = 0, formed = 0, minl = Integer.MAX_VALUE;
		
		while (right < s.length()) {
			char ch = s.charAt(right);
			windowCounts.put(ch, windowCounts.getOrDefault(ch, 0) + 1);
			
			if (windowCounts.get(ch) == 1) formed++;
			
			while (left <= right && formed == req) {
				minl = Math.min(minl, right-left+1);
				char leftch = s.charAt(left);
				
				windowCounts.put(leftch, windowCounts.get(leftch) - 1);
				if (windowCounts.get(leftch) == 0) formed--;
				
				left++;
			}
			right++;
		}
		
		return minl == Integer.MAX_VALUE ? -1 : minl;
	}

}
