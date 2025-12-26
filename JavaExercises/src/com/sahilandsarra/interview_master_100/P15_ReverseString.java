package com.sahilandsarra.interview_master_100;

 
public class P15_ReverseString {

	public static void main(String[] args) {
		P15_ReverseString ts = new P15_ReverseString();

		int[] nums1 = {-1,0,3,5,9,12};
		
		int[] nums = {0, 1};
		//int target = 9;
		int target = 13;
		
		String s = "helloH";
		System.out.println(ts.reverseString1(s.toCharArray()));
		s = "hello";
		System.out.println(ts.reverseString1(s.toCharArray()));
	}
	
	//public char[] reverseString(char[] s) {
	public char[] reverseString1(char[] s) {
        int l = s.length;
        
        for (int i = 0; i < l/2; i++) {
        	char temp = s[l-i-1];
        	s[l-i-1] = s[i];
        	s[i] = temp;
        }
        
        return s;
        
        /*for (char c : s) {
            System.out.println(c);
        }*/
    }
	
	public void reverseString(char[] s) {
		int l = 0, r = s.length - 1;
		
		while (l < r) {
			char temp = s[l];
			s[l] = s[r];
			s[r] = temp;
			
			l++;
			r--;
		}
	}
	
	
}