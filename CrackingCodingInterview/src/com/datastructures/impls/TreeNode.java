package com.datastructures.impls;

/**
 * Simple implementation of data structure Binary Search Tree.
 * 
 * A TreeNode represents a node the Tree data structure.
 * 
 * In Binary Search Tree, every (root) node has exactly two child nodes. 
 * A child node is smaller than its parent node which is in turn smaller than 
 * all its right-hand side nodes.
 */
public class TreeNode {
	TreeNode left, right;
	int data;
	
	public TreeNode(int value) {
		this.data = value;
	}
	
	public void insert(int value1) {
		if (value1 <= data) {
			if (left == null) {
				left = new TreeNode(value1);
			} else {
				left.insert(value1);
			}
		} else {
			if (right == null) {
				right = new TreeNode(value1);
			} else {
				right.insert(value1);
			}
		}
	}
	
	public boolean contains(int value) {
		boolean contains = false;
				
		if (value == this.data) {
			contains = true;
		} else if (value < this.data) {
			if (left == null) {
				contains = false;
			} else {
				left.contains(value);
			}
		} else {
			if (right == null) {
				contains = false;
			} else {
				right.contains(value);
			}
		}
		
		return contains;
	}
	
}
