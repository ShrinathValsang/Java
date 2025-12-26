package com.sahilandsarra.interview_master_100;

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

public class P10_MaximumDepthBinaryTree {

	public static void main(String[] args) {
		P10_MaximumDepthBinaryTree ts = new P10_MaximumDepthBinaryTree();

		int[] nums = {-1,0,3,5,9,12};
		//int target = 9;
		int target = 13;
 	}

    public int maxDepth(TreeNode root) {
    	if (root == null) return 0;
    	
    	int leftDepth = maxDepth(root.left);
    	int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }
	
}