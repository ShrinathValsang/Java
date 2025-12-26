package com.sahilandsarra.interview_master_100;

import java.util.HashMap;
import java.util.Map;

// Definition for singly-linked list.
/*class Node {
	int val;
    Node next;
    Node(int x) {
        val = x;
        next = null;
    }
}*/

public class P17_MiddleOfALinkedList {

	public static void main(String[] args) {
		P17_MiddleOfALinkedList ts = new P17_MiddleOfALinkedList();

		int[] nums = {-1,0,3,5,9,12};
		//int target = 9;
		int target = 13;
 	}
	
	public ListNode middleNode(ListNode head) {
		if (head == null || head.next == null) return head; // not necessary
		
		ListNode slow = head;
		//ListNode fast = head.next;
		ListNode fast = head;
		
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		
		return slow;
	}
	
}