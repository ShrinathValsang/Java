package com.crackingcoding.datastructures;

import java.util.*;
import java.io.*;

/*
7
3
5
2
1
4
6
7

*/
class Node {
	Node left, right;
	int data;

	Node(int data) {
		this.data = data;
		left = right = null;
	}
}

class SimpleBinaryTree {

	public static int getHeight(Node root) {
		// Write your code here
		// int rh = 0, lh = 0;
		
		if (root == null) {
			return -1;
		} else {
			int lh = getHeight(root.left);
			int rh = getHeight(root.right);

			int max = lh > rh ? lh : rh;
			return max;
		}
	}

	public static Node insert(Node root, int data) {
		if (root == null) {
			return new Node(data);
		} else {
			Node cur;
			if (data <= root.data) {
				cur = insert(root.left, data);
				root.left = cur;
			} else {
				cur = insert(root.right, data);
				root.right = cur;
			}
			return root;
		}
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		Node root = null;
		while (t-- > 0) {
			int data = sc.nextInt();
			root = insert(root, data);
		}

		int height = getHeight(root);
		System.out.println(height);
	}
}
