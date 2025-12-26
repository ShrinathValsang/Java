package com.sahilandsarra.interview_master_100;

import java.util.HashMap;
import java.util.Map;

public class P7_ValidAnagram {

	public static void main(String[] args) {
		P7_ValidAnagram ts = new P7_ValidAnagram();

		String prices  = "A man, a plan, a canal: Panama";
		//System.out.println(ts.isPalindrome(prices));
		
		String s = "anagram"; String t = "nagaram";
		
		System.out.println(ts.isAnagram(s, t));
		
		s = "ab"; t = "a";
		System.out.println(ts.isAnagram(s, t));
 	}
	
	public boolean isAnagram(String s, String t) {
		if (s.length() != t.length()) return false;
		
		int[] count = new int[26];
		
		for (char c : s.toCharArray()) count[c - 'a']++;
		for (char c : t.toCharArray()) {
			count[c - 'a']--;
			if (count[c - 'a'] < 0) return false;
		}
		
		return true;
	}
	
	public boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) return false;
        
        int sl = s.length();
        
        int[] sa = new int[26];
        s.chars().forEach(sc -> sa[sc-97]++);
        t.chars().forEach(tc -> sa[tc-97]--);
        
        for (int j = 0; j < sa.length; j++) {
        	if (sa[j] != 0) return false;
        	else continue;
        }

        return true;        
    }
	
	
}