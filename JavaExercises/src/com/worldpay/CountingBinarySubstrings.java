package com.worldpay;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * Worldpay Hackerrank 26 Sept 2025
 * Coding Question 2
 * 
 * 
 * A binary string is a string consisting of only 0s and 1s. A substring is a contiguous group of 
 * characters within a string.
 * Given a binary string , find the number of substrings that contain an equal numbers of 0s and 1s 
 * and all the 0s and 1s are grouped together.
 * 
 * Example - s = 011001
 * The substrings 01,10,1100 and 01 have equal numbers of 0s and 1s with all 0s and 1s grouped 
 * consecutively. Hence, the answer is 4.
 * 
 * e
 * https://www.hackerrank.com/contests/goc-cdc-series-9/challenges/count-binary-substring
 * https://algo.monster/liteproblems/696 -- something diff??
 */
public class CountingBinarySubstrings {

	public static void main(String[] args) {
		String s = "011001";
		
//		System.out.println("countBinarySubstrings(" + s + ") -- " + countBinarySubstrings(s));
//		System.out.println("countBinarySubstrings2(" + s + ") -- " + countBinarySubstrings2(s));
		
		// second example
		s = "01";
		List<String> result1 = printBinarySubstrings(s);
		System.out.println(result1);
	}
	
	public static int countBinarySubstrings(String s) {
		int count = 0, i = 1, prev = 0, curr = 1; // prev is previous group length, curr is current group length
		/*while (i < s.length()) {
			if (s.charAt(i) != s.charAt(i -1)) {
				count += Math.min(prev, curr);
				prev = curr;
				curr = 1;
			} else {
				curr++;
			}
			i++;
		}*/
		
		for (int k = 1; k < s.length(); k++) {
			if (s.charAt(k) != s.charAt(k - 1)) {
				count += Math.min(prev, curr);
				prev = curr;
				curr = 1;
			} else {
				curr++;
			}
		}
		
		return count += Math.min(prev, curr);
	}
	
 	public static int countBinarySubstrings2(String s) { // copmlexity is more!! but it is working
		int count = 1;
		List<Integer> groupLengths = new ArrayList<>();
		
		for (int i = 1; i < s.length(); i++) {
			if (s.charAt(i) == s.charAt(i-1)) count++;
			else {
				groupLengths.add(count);
				count = 1;
			}
		}
		groupLengths.add(count);
		
		int result = 0;
		for (int i = 1; i < groupLengths.size(); i++) {
			result += Math.min(groupLengths.get(i), groupLengths.get(i-1));
		}
		
		return result;
	}
	
 	
 	public static List<String> printBinarySubstrings(String s) { //Big(0) -- O(n), O(n) 
 		List<String> result = new ArrayList<>();
 		int slen = s.length();
 		int prev = 0, curr = 1, prevSwitch = -1, currSwitch = -1;
 		
 		for (int k = 1; k < slen; k++) {
 			if (s.charAt(k) == s.charAt(k - 1)) {
 				curr++;
 			} else {
 				prevSwitch = currSwitch;
 				currSwitch = k;
				int gl = Math.min(prev, curr);
				
				for (int j = 1; j < gl + 1; j++) {
					if ((prevSwitch - j) >= 0 && (prevSwitch + j) <= slen) {
						result.add(s.substring(prevSwitch - j, prevSwitch + j));
					}
				}
				
 				prev = curr;
 				curr = 1;
 			}
 		}
 		
 		for (int j = 1; j < curr + 1; j++) {
			if ((currSwitch - j) >= 0 && (currSwitch + j) <= slen) {
				result.add(s.substring(currSwitch - j, currSwitch + j));
			}
		}

        return result;
 	}
 	
}
