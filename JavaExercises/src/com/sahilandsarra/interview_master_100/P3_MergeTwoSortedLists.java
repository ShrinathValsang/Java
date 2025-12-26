package com.sahilandsarra.interview_master_100;

/*class ListNode {
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
}*/

public class P3_MergeTwoSortedLists {

	public static void main(String[] args) {
		P3_MergeTwoSortedLists ts = new P3_MergeTwoSortedLists();
		
		int a0 = 9999999, a2 = 9999, a1 = 91023;
		
		ListNode al0 = ts.createListNodeFromArray(new int[] {1,2,4});
//		System.out.println(al0.toString());
		ListNode al2 = ts.createListNodeFromArray(new int[] {1,3,5});
//		ListNode result = ts.mergeTwoSortedLists(al0, al2);
//		System.out.println(result);
		

		ListNode n1 = ts.createListNodeFromArray(new int[] {});
		ListNode n2 = ts.createListNodeFromArray(new int[] {0});
		
		ListNode n3 = ts.createListNodeFromArray(new int[] {5});
		ListNode n4 = ts.createListNodeFromArray(new int[] {1,2,4});
		
		ListNode result2 = ts.mergeTwoSortedLists5(n1, n2);
		System.out.println(result2);
		

		ListNode result3 = ts.mergeTwoSortedLists5(n3, n4);
		System.out.println(result3);
 	}
	
	public ListNode createListNodeFromArray(int[] arr) {
		if (arr.length == 0 || arr == null) return null;
		
		ListNode head = new ListNode(arr[0]);
		ListNode current = head;
		for (int i = 0; i < arr.length; i++) {
			current.next = new ListNode(arr[i]);
			current = current.next;
		}
		
		return head.next;
	}	
	
	// recursive version -- solid and fast — but not space-optimal, does heap allocation and not memory efficient
	public ListNode mergeTwoSortedLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;
    	
		if (list1.val < list2.val) {
			list1.next = mergeTwoSortedLists(list1.next, list2);
			return list1;
		} else  {
			list2.next = mergeTwoSortedLists(list1, list2.next);
			return list2;
		} 
    	
    }

	// partially iterative and still creates new nodes  (which more efficient)
	// optimized version avoids heap allocation and is more memory-efficient
	public ListNode mergeTwoSortedLists2(ListNode list1, ListNode list2) {
		ListNode result = new ListNode(0);
    	ListNode element = result;

        if (list1 == null) return list2;
        if (list2 == null) return list1;
    	
    	while (list1 != null && list2 != null) {
    		if (list1.val < list2.val) {
    			element.next = new ListNode(list1.val);
    			list1 = list1.next;
    		} else  {
    			element.next = new ListNode(list2.val);
    			list2 = list2.next;
    		}
    		
    		element = element.next;
    	}
    	
    	element.next = (list1 != null) ? list1 : list2;
    	
    	return result.next;
    }
	
	// Fully iterative and doesn't create new nodes  (which most efficient) -- VERIFIED
	// head is a dummy node — head.next is the actual start of the merged list.
	// element builds the list by reusing nodes from list1 and list2.
	public ListNode mergeTwoSortedLists5(ListNode list1, ListNode list2) {
		ListNode head = new ListNode(-1);
		ListNode element = head;
		
		while (list1 != null && list2 != null) {
			if (list1.val < list2.val) {
				element.next = list1;
				list1 = list1.next;
			} else {
				element.next = list2;
				list2 = list2.next;
			}
			element = element.next;
		}
		
		element.next = list1 != null ? list1 : list2;
		
		return head.next;
	}
	
	// immutability (new nodes)
	public ListNode mergeTwoSortedLists3(ListNode list1, ListNode list2) {
		ListNode result = new ListNode(0);
    	ListNode element = result;

        if (list1 == null) return list2;
        if (list2 == null) return list1;
    	
    	while (list1 != null || list2 != null) {
    		if (list1 != null && list2 != null && list1.val < list2.val) {
    			element.next = new ListNode(list1.val);
    			list1 = list1.next;
    			element = element.next;
    		} else if (list1 != null && list2 != null) {
    			element.next = new ListNode(list2.val);
    			list2 = list2.next;
    			element = element.next;
    		} else if (list1 != null) {
    			element.next = new ListNode(list1.val);
    			list1 = list1.next;
    			element = element.next;
    		} else if (list2 != null) {
    			element.next = new ListNode(list2.val);
    			list2 = list2.next;
    			element = element.next;
    		}
    	}
    	
    	return result.next;
    }
	
    public ListNode mergeTwoLists4(ListNode list1, ListNode list2) {
        ListNode result = new ListNode(0);
        ListNode element = result;

        int i = Integer.MIN_VALUE;
        int j = Integer.MIN_VALUE;

        if (list1 == null) return list2;
        if (list2 == null) return list1;
        
        while (list1 != null || list2 != null) {
            if (list1 != null) {
                i = list1.val;
                list1 = list1.next;
            }
            
            if (list2 != null) {
                j = list2.val;
                list2 = list2.next;
            }

            if (i < j) {
                element.next = new ListNode(i);
                element.next.next = new ListNode(j);
                element = element.next.next;
            } else {
                element.next = new ListNode(j);
                element.next.next = new ListNode(i);
                element = element.next.next;
            }
        }

        return result.next;
    }

}