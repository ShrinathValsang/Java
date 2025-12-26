package com.leetcode.dsa;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FirstUniqueChar {

	public static void main(String[] args) {
		System.out.println(new FirstUniqueChar().firstUniqChar("lovveleetcode"));
	}
    
    public int firstUniqChar(String s) {
        // non repeating character map
        /*Map<Character, Integer> map = new HashMap<>();
        Set<Character> uniqueSet = new HashSet<>();
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int occ = map.getOrDefault(c, 0);
            
            if (occ > 0) {
            	uniqueSet.remove(c);
            } else {
            	uniqueSet.add(c);
            }
            
            map.put(c, occ + 1);
        }
        
        for (int j = 0; j < s.length(); j++) {
        	char c = s.charAt(j);
        	if (uniqueSet.contains(c) && map.get(c) == 1) {
        		return j;
        	}
        }
        
		return -1;*/
    	
    	int[] freq_char = new int[26];
    	char[] arr = s.toCharArray();
    	
    	for (char c : arr) {
    		freq_char[c - 'a']++;
    	}
    	
    	for (int i = 0; i < arr.length; i++) {
    		if (freq_char[arr[i] - 'a'] == 1) {
    			return i;
    		}
    	}
    	
    	return -1;
    }

}
