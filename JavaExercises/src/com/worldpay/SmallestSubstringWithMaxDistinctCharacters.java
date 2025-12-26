package com.worldpay;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * You are given a string S that is made of lowercase English alphabets. Determine the length of 
 * the smallest substring that contains the maximum number of distinct characters.
 * 
 * e.g. S = abcda, answer = 4
 * 
 * Smallest substring
 * https://www.hackerearth.com/practice/algorithms/searching/binary-search/practice-problems/algorithm/smallest-substring-e1862fcf/
 */
public class SmallestSubstringWithMaxDistinctCharacters {

	public static void main(String[] args) {
		String s = "abcbbck"; //abcabcbb";
		String res = printSmallestSubstring(s);
		System.out.println(res);
	}
	
	public static String printSmallestSubstring(String s) {
		int sl = s.length();
		int minLen = sl;
		int maxDistinct = (int) s.chars().distinct().count();
		String result = s;
		
		for (int l = 0; l < sl; l++) {
			Set<Character> seen = new HashSet<>();
			
			for (int r = l; r < sl; r++) {
				seen.add(s.charAt(r));
				
				if (seen.size() == maxDistinct) {
					int len = r - l + 1;
					if (len < minLen) {
						minLen = len;
						result = s.substring(l, r + 1);	
					}
					break;
				}
					
			}
		}
		
		return result;
	}


}
