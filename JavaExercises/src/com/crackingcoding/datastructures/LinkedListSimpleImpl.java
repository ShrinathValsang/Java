package com.crackingcoding.datastructures;

import java.util.Stack;

/**
 * This is a very simple linked list implementation with a single link between
 * elements.
 * 
 * Generic implementation of add remove operations are given.
 * Additionally, it has a custom method which provides the middle element
 * from the list.
 * 
 */
public class LinkedListSimpleImpl {

	Node head;
	
	class Node {
		private Node next;
		private int val;
		
		Node(int value) {
			this.val = value;
			//next = null;
		}
		
		public String toString() {
			return "Node [t=" + val + ", next=" + next + "]";
		}
		
	}
	
	/* By default, the element is created and added at the END of the list. */ 
	public void add(int val) {
		Node newNode = new Node(val);
		
		if (head == null) {
			head = newNode;
		} else {
			Node element = head;
			Node prev = null;
			while (element != null) {
				prev = element;
				element = element.next;
			}
			
			prev.next = newNode;
		}
		
	}
	
	/*
	 * //TODO -- how to implement equals in this case??
	 * 
	 */
	public void remove(Node node) {
		if (head.equals(node)) {
			head = head.next;
		} else {
			Node element = head;
			Node prev = null;
			while (element != null && !node.equals(element)) {
				prev = element;
				element = element.next;	
			}
			
			if (element != null /*prev != null*/) {
				prev.next = element.next; 
			}
		}
	}
	
	public static void main(String[] args) {
		Stack stack = new Stack();
		
		//java.util.LinkedList<Integer> list = new LinkedList<>();
		LinkedListSimpleImpl linkList = new LinkedListSimpleImpl();
		linkList.add(1);
		linkList.add(2);
		linkList.add(3);
		//linkList.remove(linkList.new Node(1)); -- no effect of this method on current imple of remove().

		linkList.add(4);
		Node midNode = getMiddleElement(linkList);
		System.out.println("linkList.add(4) -- " + midNode);
		
		linkList.add(5);
		midNode = getMiddleElement(linkList);
		System.out.println("linkList.add(5) -- " + midNode);
		
		linkList.add(6);
		midNode = getMiddleElement(linkList);
		System.out.println("linkList.add(6) -- " + midNode);
		
		linkList.add(7);
		midNode = getMiddleElement(linkList);
		System.out.println("linkList.add(7) -- " + midNode);
		
		linkList.add(8);
		midNode = getMiddleElement(linkList);
		System.out.println("linkList.add(8) -- " + midNode);
		
		linkList.add(9);
		midNode = getMiddleElement(linkList);
		System.out.println("linkList.add(9) -- " + midNode);
	}
	
	private static Node getMiddleElement(LinkedListSimpleImpl linkList) {
		Node slow = linkList.head;
		Node fast = linkList.head;
		
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			if (fast != null) 
				slow = slow.next;
		}
		
		return slow;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		
		result = prime * result + (head == null ? 0 : head.hashCode());
		
		return result;
	}

	@Override
	public String toString() {
		return "LinkedListSimpleImpl [head=" + head + "]";
	}
	
}


// 	OUTPUT 
//	*** without  -- if (fast != null) ***
//	linkList.add(4) -- Node [t=3, next=Node [t=4, next=null]] // Not completely correct
//	linkList.add(5) -- Node [t=3, next=Node [t=4, next=Node [t=5, next=null]]]
//	linkList.add(6) -- Node [t=4, next=Node [t=5, next=Node [t=6, next=null]]] // Not completely correct
//	linkList.add(7) -- Node [t=4, next=Node [t=5, next=Node [t=6, next=Node [t=7, next=null]]]]
//	linkList.add(8) -- Node [t=5, next=Node [t=6, next=Node [t=7, next=Node [t=8, next=null]]]] // Not completely correct
//	linkList.add(9) -- Node [t=5, next=Node [t=6, next=Node [t=7, next=Node [t=8, next=Node [t=9, next=null]]]]]
//	
//	
//	*** with -- if (fast != null) ***
//	linkList.add(4) -- Node [t=2, next=Node [t=3, next=Node [t=4, next=null]]]
//	linkList.add(5) -- Node [t=3, next=Node [t=4, next=Node [t=5, next=null]]]
//	linkList.add(6) -- Node [t=3, next=Node [t=4, next=Node [t=5, next=Node [t=6, next=null]]]]
//	linkList.add(7) -- Node [t=4, next=Node [t=5, next=Node [t=6, next=Node [t=7, next=null]]]]
//	linkList.add(8) -- Node [t=4, next=Node [t=5, next=Node [t=6, next=Node [t=7, next=Node [t=8, next=null]]]]]
//	linkList.add(9) -- Node [t=5, next=Node [t=6, next=Node [t=7, next=Node [t=8, next=Node [t=9, next=null]]]]]
		