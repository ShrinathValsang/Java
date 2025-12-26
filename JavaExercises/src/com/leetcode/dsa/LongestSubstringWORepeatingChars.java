package com.leetcode.dsa;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWORepeatingChars {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Input: s = "abcabcbb"
//		Output: 3
//		Explanation: The answer is "abc", with the length of 3.
//		Example 2:
//
//		Input: s = "bbbbb"
//		Output: 1
//		Explanation: The answer is "b", with the length of 1.
//		Example 3:
//
//		Input: s = "pwwkew"
//		Output: 3
//		Explanation: The answer is "wke", with the length of 3.
//		Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
		String s = "abcabcbb";
		String s2 = "bbbbb";
		String s3 = "pwwkew";
		String s4 = "abba";
		String s5 = "tmmzuxt";
		String s6 = "tmmz";
//		System.out.println(lengthOfLongestSubstring1(s3));
		System.out.println(lengthOfLongestSubstring2("baxyzabcab"));
//		System.out.println(lengthOfLongestSubstring("dvdf"));
//		System.out.println(lengthOfLongestSubstring("pwwkew"));
//		System.out.println(lengthOfLongestSubstring("qrdvokdfr"));
//		System.out.println(lengthOfLongestSubstring("ad"));
	}
	
    /*public static int lengthOfLongestSubstring(String s) {
    	s = "tmmz";
    	if (s == null || s.length() == 0) return 0;
        if (s.length() == 1) return 1;
        
    	/*Set<Character> set = new HashSet<>();
    	int maxl = 0, start = 0, j = 0; // start and end of stringfor (int i = 0; i < s.length(); i++) {
        	char c = s.charAt(i);
        	
        	if (!set.contains(c)) {
        		set.add(c);
        		//maxl = (i - start + 1) > maxl ? (i - start + 1) : maxl;
        		maxl = Math.max(maxl, set.size());
        	} else {
        		maxl = Math.max(maxl, set.size());
        		start = s.indexOf(c)
        		set.clear();
        		set.add(c);
        		start = i;
        	}
        }*/
    	
        /*Set<Character> set = new HashSet<>();
        int[] indices = new int[256];
        Arrays.fill(indices, -1); // if you have this, you wont need set!!
    	int maxl = 0, start = 0; // start and longest string (maxl)
    	
    	for (int i = 0; i < s.length(); i++) {
	    	char c = s.charAt(i);
	    	//index[s.charAt(i)] = i;
	    	
	    	if (set.contains(c)) {
	    		int k = i - 1;
	    		while (k-- > -1) set.remove(s.charAt(k));

	    		start = Math.max(start, index[s.charAt(i)] + 1); // more appropriate
	    		
	    		//maxl = Math.max(maxl, i - start + 1); CORRECT!!
	    		//maxl = Math.max(maxl, i - index[s.charAt(i)]);
	    		maxl = Math.max(maxl, i - Math.max(start, index[s.charAt(i)]));
	    		index[s.charAt(i)] = i; //set.remove(c);
	    		// CORRECT ABOVE WITH => index[s.charAt(i)] = i + 1;
	    	} else {
	    		index[s.charAt(i)] = i;
	    		set.add(c);
	    		maxl = Math.max(maxl, i - start + 1);
	    		//maxl = Math.max(maxl, i - index[s.charAt(i)]);
	    	}
	    	System.out.println("index i char c \tstart \tmaxl \tindex[s.charAt(i)] \tset");
	    	System.out.println(i + " \t" + c + " \t" + start + " \t" + maxl + " \t" + index[s.charAt(i)] + " \t" + set);
	    }
        return maxl;
    }*/

    public static int lengthOfLongestSubstring1(String s) {
        int l = s.length(), start = 0, maxl = 0;
        int[] arr = new int[128];//baxyzabcab

        int ind = 0;
    	System.out.println("index i\ts.charAt(i) \tstart \tmaxl \tarr[s.charAt(i)]=(i+1)");
    	System.out.println(ind + "\t" + s.charAt(ind) + " \t\t" + start + " \t" + maxl + " \t" + arr[s.charAt(ind)]);
        
    	for (int i = 0; i < l; i++) {
            start = Math.max(start, arr[s.charAt(i)]);
            maxl = Math.max(maxl, i - start + 1);
            arr[s.charAt(i)] = i + 1;
            
        	System.out.println(i + "\t" + s.charAt(i) + " \t\t" + start + " \t" + maxl + " \t" + arr[s.charAt(i)]);
        }
    	
        return maxl;
    }	
    
    public static int lengthOfLongestSubstring2(String s) {
        int l = s.length(), start = 0, maxl = 0;
        int[] arr = new int[28];//baxyzabcab

        int ind = 0;
    	System.out.println("i   start  maxl  s.charAt(i)  arr[s.charAt(i)]");
    	//System.out.println(ind + "\t" + s.charAt(ind) + " \t\t" + start + " \t" + maxl + " \t" + arr[s.charAt(ind) - 97]);
        for (int i = 0; i < l; i++) {
            start = Math.max(start, arr[s.charAt(i) - 97]);
            maxl = Math.max(maxl, i - start + 1);
            arr[s.charAt(i) - 97] = i + 1;
            
        	System.out.println(i + "   " + start + "\t   " + maxl + " \t " + s.charAt(i) + " \t\t" + arr[s.charAt(i) - 97]);
        }
    	
        return maxl;
    }
	
	public static int lengthOfLongestSubstring(String s) {
        int start = 0, i = 0, maxl = 0;
        int[] arr = new int[128];
        
        while (i < s.length()) {
            arr[s.charAt(i)]++;
            
            while (arr[s.charAt(i)] > 1) {
                arr[s.charAt(start)]--;
                start++;
            }
            
            maxl = Math.max(maxl, i - start + 1);
            i++;
        }

        return maxl;
    }
}
