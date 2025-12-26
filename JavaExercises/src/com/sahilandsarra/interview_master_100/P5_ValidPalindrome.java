package com.sahilandsarra.interview_master_100;

import java.util.stream.Collectors;

public class P5_ValidPalindrome {

	public static void main(String[] args) {
		P5_ValidPalindrome ts = new P5_ValidPalindrome();

		String prices  = "A man, a plan, a canal: Panama";
		//System.out.println(ts.isPalindrome(prices));
		
		String s = "0P";
		System.out.println(ts.isPalindrome(s));
 	}
	
	// This is already O(n) time and O(1) space — ideal for large inputs (up to 200,000 characters). 
	// No need to build intermediate strings or use extra memory.
	public boolean isPalindrome(String s) {
		/*Character[] ccc = s.chars().mapToObj(c -> (char) c).toArray(Character[] :: new);*/
		/*String s1 = s.chars().mapToObj(c -> (char) c)
			.filter(Character::isAlphabetic)
			.map(Character::toLowerCase)
			.map(String::valueOf)
			.collect(Collectors.joining());*/
		
        char[] chars = s.toCharArray();
        int sl = chars.length;
        int left = 0, right = sl - 1 ;
        
        while (left < right) {
        	//if (!Character.isAlphabetic(chars[left])) left++;
        	//else if (!Character.isAlphabetic(chars[right])) right--;
        	if (!Character.isLetterOrDigit(chars[left])) left++;
        	else if (!Character.isLetterOrDigit(chars[right])) right--;
        	else if (Character.toLowerCase(chars[left]) != Character.toLowerCase(chars[right])) return false;
        	else {
        		left++;
        		right--;
        	}
        }
        	
        return true;
    }
	
}