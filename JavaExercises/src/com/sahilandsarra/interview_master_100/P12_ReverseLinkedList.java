package com.sahilandsarra.interview_master_100;

// Definition for singly-linked list.
class ListNode1 {
    int val;
    ListNode1 next;
    ListNode1() {}
    ListNode1(int val) { this.val = val; }
    ListNode1(int val, ListNode1 next) { this.val = val; this.next = next; }
 }
 
public class P12_ReverseLinkedList {

	public static void main(String[] args) {
		P12_ReverseLinkedList ts = new P12_ReverseLinkedList();

		int[] nums = {-1,0,3,5,9,12};
		//int target = 9;
		int target = 13;
		
		
 	}

	public ListNode1 reverseList(ListNode1 head) {
		ListNode1 prev = null;
		
        while (head != null) {
            ListNode1 temp = head.next; // store next node in temp var
            head.next = prev;			// reverse link
            prev = head;				// move prev forward
            head = temp;				// move head forward
        }
        
        return prev;					// new head of the reserved list
    }
	
}