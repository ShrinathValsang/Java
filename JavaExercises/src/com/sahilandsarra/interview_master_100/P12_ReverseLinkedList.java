package com.sahilandsarra.interview_master_100;


// Definition for singly-linked list.
class Node1 {
    int val;
    Node1 next;

    public Node1() {}
    public Node1(int val) { this.val = val; }
    public Node1(int val, Node1 next) { this.val = val; this.next = next; }

    @Override
    public String toString() {
        return "Node{" +
                "val=" + val +
                ", next=" + (this.next != null? next.toString() : "[]") +
                '}';
    }
}
 
public class P12_ReverseLinkedList {

    public static void main(String[] args) {
        Node1 n1 = new Node1(27, new Node1(63, new Node1(11, new Node1(47, new Node1(85)))));
        System.out.println(n1);

        Node1 reversed = reverseList(n1);
        System.out.println(reversed);
    }

	public static Node1 reverseList(Node1 head) {
		Node1 prev = null; //TODO
		
        while (head != null) {
            Node1 temp = head.next; // store next node in temp var
            head.next = prev;			// reverse link
            prev = head;				// move prev forward
            head = temp;				// move head forward
        }
        
        return prev;					// new head of the reserved list
    }
	
}