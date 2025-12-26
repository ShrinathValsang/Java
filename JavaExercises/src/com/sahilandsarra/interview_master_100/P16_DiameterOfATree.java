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
class P16_DiameterOfATree {
	
	int maxdiam = 0;

	public static void main(String[] args) {
		P16_DiameterOfATree ts = new P16_DiameterOfATree();

		int[] nums1 = {-1,0,3,5,9,12};
		
		int[] nums = {0, 1};
		//int target = 9;
		int target = 13;
		
		String s = "helloH";
		// System.out.println(ts.reverseString1(s.toCharArray()));
		s = "hello";
		//System.out.println(ts.reverseString1(s.toCharArray()));
	}
	
    public int diameterOfBinaryTree(TreeNode root) {
        getDepth(root);
        return maxdiam;
    }
    
    private int getDepth(TreeNode root) {
    	if (root == null) return 0;
    	int right = getDepth(root.right);
    	int left = getDepth(root.left);
    	
    	maxdiam = Math.max(maxdiam, right + left);
    	return Math.max(right, left) + 1;
    }
}
