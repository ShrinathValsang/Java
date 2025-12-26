package com.leetcode.dsa;

public class JewelsAndStones {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String jewels = "aA", stones = "aAAbbbb";
		System.out.println(new JewelsAndStones().numJewelsInStones(jewels, stones));
	}
	
    public int numJewelsInStones(String jewels, String stones) {
        char[] stonesArr = new char[60];
        for (char c : stones.toCharArray()) {
        	System.out.println(c + 1);
            stonesArr[c - 'A']++;
        }
        
        int res = 0;
        for (char c : jewels.toCharArray()) {
            res = res + stonesArr[c - 'A'];
        }
        
        return res;
    }

}
