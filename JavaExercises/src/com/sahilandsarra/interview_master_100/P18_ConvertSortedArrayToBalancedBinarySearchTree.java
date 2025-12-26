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
class P18_ConvertSortedArrayToBalancedBinarySearchTree {
	
	int maxdiam = 0;

	public static void main(String[] args) {
		P18_ConvertSortedArrayToBalancedBinarySearchTree ts = new P18_ConvertSortedArrayToBalancedBinarySearchTree();
		int[] nums = new int[] {0, 1, 4, 5, 6, 9, 12, 17, 20};
		
		ts.buildBinarySearchTree(nums, 0, nums.length);
	}
	
	private TreeNode buildBinarySearchTree(int[] nums, int left, int right) {
		if (left > right) return null;
		
		int mid = left + (right - left) / 2;
		TreeNode node = new TreeNode(nums[mid]);
		node.left = buildBinarySearchTree(nums, left, mid - 1);
		node.right = buildBinarySearchTree(nums, mid + 1, right);
		
		return node;
	}
	
    
}
