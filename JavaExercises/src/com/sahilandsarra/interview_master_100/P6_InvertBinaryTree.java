package com.sahilandsarra.interview_master_100;

//Definition for a binary tree node.
class TreeNode {
	
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class P6_InvertBinaryTree {

	public static void main(String[] args) {
		P6_InvertBinaryTree ts = new P6_InvertBinaryTree();

		String prices = "A man, a plan, a canal: Panama";
		//System.out.println(ts.isPalindrome(prices));
		
		String s = "0P";
		//System.out.println(ts.invertTree(s));
 	}
	
    public TreeNode invertTree(TreeNode root) {
    	if (root == null) return null;
    	
    	TreeNode temp = root.left;
    	root.left = invertTree(root.right);
    	root.right = invertTree(temp);
    	
        return root;
    }
	
	
}