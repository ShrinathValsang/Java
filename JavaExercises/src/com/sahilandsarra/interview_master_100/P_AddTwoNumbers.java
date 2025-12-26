package com.sahilandsarra.interview_master_100;

import java.util.HashMap;
import java.util.Map;

class ListNode {
	int val;
	ListNode next;
	ListNode() {}
	ListNode(int val) { this.val = val; }
	ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		ListNode element = this;
		while (element != null) {
			sb.append(element.val);
			element = element.next;
		}
		return sb.toString();
	}
}

public class P_AddTwoNumbers {

	public static void main(String[] args) {
		P_AddTwoNumbers ts = new P_AddTwoNumbers();
		
		int a0 = 9999999, a2 = 9999, a1 = 91023;
		
		ListNode al0 = ts.createListNode(a0);
		ListNode al2 = ts.createListNode(a2);
  		ListNode result = ts.addTwoNumbers(al0, al2);
		System.out.println(result);
	}
	
	public ListNode createListNode(int num) {
		ListNode head = new ListNode(0);
		if (num == 0) return head;
		
		ListNode element = head;
		while (num > 0) {
			int digit = num % 10;
			num = num / 10;
			
			element.next = new ListNode(digit);
			element = element.next;
		}
		
		return head.next;
	}

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    	ListNode result = new ListNode(0);
    	ListNode element = result;
    	int carry = 0;
    	
    	while (l1 != null || l2 != null || carry != 0) {
        	int val1 = (l1 != null) ? l1.val : 0;
        	int val2 = (l2 != null) ? l2.val : 0;
        	int sum = val1 + val2 + carry;
            carry = sum / 10;
            
            // element.val = sum % 10;
            element.next = new ListNode(sum % 10);
            element = element.next;
            
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        
        /*while (l1.next != null) {
        	int sum = l1.val + carry;
            carry = sum / 10;
            
            element.val = sum % 10;
            element = element.next = new ListNode();
            l1 = l1.next;
        }
        
        while (l2.next != null) {
        	int sum = l2.val + carry;
            carry = sum / 10;
            
            element.val = sum % 10;
            element = element.next = new ListNode();
            l2 = l2.next;
        }
        
        if (carry != -1) {
			element.val = carry;
		}*/
        
    	// return result;
        return result.next;
    }

}