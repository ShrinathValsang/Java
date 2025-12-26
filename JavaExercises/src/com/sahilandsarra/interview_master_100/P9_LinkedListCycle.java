package com.sahilandsarra.interview_master_100;

import java.util.HashMap;
import java.util.Map;

// Definition for singly-linked list.
class Node {
	int val;
    Node next;
    Node(int x) {
        val = x;
        next = null;
    }
}

public class P9_LinkedListCycle {

	public static void main(String[] args) {
		P9_LinkedListCycle ts = new P9_LinkedListCycle();

		int[] nums = {-1,0,3,5,9,12};
		//int target = 9;
		int target = 13;
 	}
	
	public boolean hasCycle(Node head) {
		if (head == null || head.next == null) return false;
		
		Node slow = head;
		Node fast = head.next;
		
		while (slow != fast) {
			if (fast == null || fast.next == null) return false;
			
			slow = slow.next;
			fast = fast.next.next;
		}
		
		return false;
	}
	
}