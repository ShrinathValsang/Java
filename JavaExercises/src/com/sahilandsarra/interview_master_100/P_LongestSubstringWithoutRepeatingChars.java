package com.sahilandsarra.interview_master_100;

import java.util.HashMap;
import java.util.Map;

public class P_LongestSubstringWithoutRepeatingChars {

	public static void main(String[] args) {
		P_LongestSubstringWithoutRepeatingChars ts = new P_LongestSubstringWithoutRepeatingChars();
		
		String s = "abbcabcbbcaaad";
		String ss = ts.printLongestSubstring(s);
		System.out.println("lengthOfLongestSubstring -- " + ts.lengthOfLongestSubstring(s));
		System.out.println("printLongestSubstring -- " + ss);
		System.out.println("printLongestSubstring lenght -- " + ss.length());
		
	}
	
	public String printLongestSubstring(String s) {
		int sl = s.length(), maxLen = 0, l = 0, startIndex = 0;
		Map<Character, Integer> seen = new HashMap<>();
		
    	for (int r = 0; r < sl; r++) {
    		char ch = s.charAt(r);
    		
    		//if (seen.containsKey(ch)) {
			if (seen.containsKey(ch) && seen.get(ch) >= l) {
    			l = seen.get(ch) + 1;
    		}
    		seen.put(ch, r);
    		
    		if (r - l + 1 > maxLen) {
				maxLen = r - l + 1;
				startIndex = l;
			}
    	}
    	
		return s.substring(startIndex, startIndex + maxLen);
	}

	public int lengthOfLongestSubstring(String s) {
		int n = s.length();
        int maxLength = 0;
        int[] lastIndex = new int[128];
        
        for (int start = 0, end = 0; end < n; end++) {
            char currentChar = s.charAt(end);
            start = Math.max(start, lastIndex[currentChar]);
            maxLength = Math.max(maxLength, end - start + 1);
            lastIndex[currentChar] = end + 1;
        }
    	
		return maxLength;
	}
	
	public int lengthOfLongestSubstringFaster(String s) {
		int sl = s.length(), maxLen = 0;
		int[] lastIndexArr = new int[128]; // ASCII size
		
		for (int left = 0, right = 0; right < sl; right++) {
    		char ch = s.charAt(right);
    		
    		left = Math.max(left, lastIndexArr[ch]);
    		maxLen = Math.max(maxLen, right - left + 1);
    		lastIndexArr[ch] = right + 1; // why right + 1? to avoid left = 0 issue
    	}
    	
		return maxLen;
	}

    /*public String longestSubstring1(String s) {
    	int sl = s.length();
    	for (int i = 0; i < sl; i++) {
    		for (int j = i + 1; j < sl; j++) {
    			StringBuilder sb = new StringBuilder(s);
    			sb.delete(i, j+1);
    			
    			if (hasAllUniqueChars(sb.toString())) {
    				return s.substring(i, j+1);
    			}
    		}
    	}

        return "";
    }
    
    private boolean hasAllUniqueChars(String s) {
		int sl = s.length();
		boolean[] seen = new boolean[256];
		
		for (int i = 0; i < sl; i++) {
			char ch = s.charAt(i);
			if (seen[ch]) return false;
			seen[ch] = true;
		}
		
		return true;
	} */

}