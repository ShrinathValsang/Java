package com.leetcode.dsa;

import java.util.HashSet;
import java.util.Set;

public class SimpleTest {

	public static void main(String[] args) {
		int[] nums = {1,2,3,1};
        Set<Integer> set = new HashSet<Integer>();
        int iter = 1;
        
        System.out.println("set size -- " + set.size());
        for (int i = 0; i < nums.length; i++) {
        	System.out.println("set size 2 -- " + set.size() + " " + set);
        	iter++;
        }
	}

}
