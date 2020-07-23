package com.crackingcoding.datastructures;

import java.util.Stack;
import java.util.LinkedList;

/**
 * This is a Java generic linked list implementation with a single link between
 * elements ("singly linked-list").
 * 
 * Generic implementation of add remove operations are given.
 * Additionally, it has a custom method which provides the middle element
 * from the list.
 * 
 */
public class LinkedListGenericImpl<T> {

	private Node<T> head;
	
	private static class Node<T> {
		T t;
		Node<T> next;
		
		Node(T value, Node<T> next) {
			this.t = value;
			this.next = next;
		}
		
		public String toString() {
			return "Node [t=" + t + ", next=" + next + "]";
		}
		
	}
	
	/* By default, the element is created and added at the END of the list. */ 
	public void add(T t) {//TODO to be tested
		Node<T> newNode = new Node<T>(t, null);
		
		if (head == null) {
			head = newNode;
		} else {
			Node<T> element = head;
			while (element.next != null) {
				element = element.next;
			}
			
			element.next = newNode;
		}
	}
	
	/*
	 * //TODO -- how to implement equals in this case??
	 * 
	 */
	//public void remove(Node<T> node) {
	public boolean remove(Node<T> node) {
		Node<T> prev = null;
		
		for (Node<T> item = head; item != null; item = item.next) {
			if ((node.t == null && item.t == null) || (node.t != null && node.t.equals(item.t))) {
				if (prev != null) {
					prev.next = item.next;
				} else {
					head = head.next;
				}
				return true;
			}
			prev = item;
		}
		
		return false;
	}
	
	/* Given a key, deletes the first occurrence of key in linked list */
	public boolean remove(Object o) {
		Node<T> prev = null;
		
		for (Node<T> item = head; item != null; item = item.next) {
			if ((item.t != null && o.equals(item.t)) || (o == null && item.t == null)) {
				if (prev != null) {
					prev.next = item.next;
				} else {
					head = head.next; // if 'prev' is null, 'node' must be head .
				}
				return true;
			}
			prev = item;
		}
		
		/* Node<T> prev = null;
		for (Node<T> node = head; node != null; node = node.next) {
			if (o.equals(node.t)) {
				final T t = node.t; // If method demands to return t
				prev.next = node.next;
				return true;
			}
		}*/
		
		return false;
	}
	
	
	
	public static void main(String[] args) {
		//Stack stack = new Stack();
		//java.util.LinkedList<Integer> list = new LinkedList<>();
		
		LinkedListGenericImpl<Integer> linkList = new LinkedListGenericImpl<>();
		linkList.add(1);
		linkList.remove(new Node(1, null));
		linkList.add(2);
		linkList.add(3);
		//linkList.remove(linkList.new Node(1)); -- no effect of this method on current imple of remove().
		//linkList.remove(2);
		//linkList.remove(new Node(1, null));
		linkList.remove(3);
		
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
	
	private static Node getMiddleElement(LinkedListGenericImpl linkList) {
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
		return "LinkedListGenericImpl [head=" + head + "]";
	}
	
}
