 package com.leetcode.dsa;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {

	public static void main(String[] args) {
//		String s = "egg", t = "add";
//		String s = "foo", t = "bar";
		String s = "paperb", t = "titled";
		
		System.out.println(new IsomorphicStrings().isIsomorphic2(s, t));

	}

	/*public boolean isIsomorphic(String s, String t) {
        if (s.length() == t.length()) {
            Map<Character, Character> map = new HashMap<>();

            for (int i = 0; i < s.length(); i++) {
                char s1 = s.charAt(i);
                char t1 = t.charAt(i);

                if (map.containsKey(s1) && !map.get(s1).equals(t1)
                    || !map.containsKey(s1) && map.containsValue(t1)) {
                        return false;
                } else {
                    map.put(s1, t1);
                }
            }
        }
        
        return true;
    }*/
	
	public boolean isIsomorphic(String s, String t) {
		// char to index mapping
	    Map<Character, Integer> s_map = new HashMap<>();
	    Map<Character, Integer> t_map = new HashMap<>();

	    for (Integer i = 0; i < s.length(); ++i)
	      if (s_map.put(s.charAt(i), i) != t_map.put(t.charAt(i), i))
	        return false;

	    return true;
	}
	
	public boolean isIsomorphic1(String s, String t) {
	    Map<Character, Integer> charToIndex_s = new HashMap<>();
	    Map<Character, Integer> charToIndex_t = new HashMap<>();

	    for (Integer i = 0; i < s.length(); ++i)
	      if (charToIndex_s.put(s.charAt(i), i) != charToIndex_t.put(t.charAt(i), i))
	        return false;

	    return true;
	}
	
	
	
    // approach #3
	public boolean isIsomorphic2(String s, String t) {
		int[] A = new int[256];
		int[] B = new int[256];
	    
	    if (s.length() != t.length()) {
	        return false;
	    }
	    
	    for (int i = 0; i < s.length(); i++) {
	        char c1 = s.charAt(i);
	        char c2 = t.charAt(i);
	        
	        if (A[c1] != B[c2]) {
	            return false;
	        }
	        
	        A[c1] = i + 1;
	        B[c2] = i + 1;
	    }
	    
	    return true;
	}

}
