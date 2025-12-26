package com.sahilandsarra.interview_master_100;

import java.util.HashSet;
import java.util.Set;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

public class P11_SingleNumber {

	public static void main(String[] args) {
		P11_SingleNumber ts = new P11_SingleNumber();

		int[] nums = {-1,0,3,5,9,12};
		//int target = 9;
		int target = 13;
		
		
 	}

	public int singleNumber(int[] nums) {
		if (nums.length == 1) return nums[0];

        int xor = 0;
        for (int i : nums) {
        	xor = xor ^ i;
        }
        
        return xor;
    }
	
}