package com.leetcode.dsa;


class Node {
    int val;
    Node next;

    public Node() {}
    public Node(int val) { this.val = val; }
    public Node(int val, Node next) { this.val = val; this.next = next; }

    @Override
    public String toString() {
        return "Node{" +
                "val=" + val +
                ", next=" + (this.next != null? next.toString() : "[]") +
                '}';
    }
}

public class ReverseLinkedList {
    public static void main(String[] args) {
        Node n1 = new Node(27, new Node(63, new Node(11, new Node(47, new Node(85)))));
        System.out.println(n1);

        Node reversed = getReversedLinkedList(n1);
        System.out.println(reversed);
    }

    private static Node getReversedLinkedList(Node head) {
        Node prev = null;

        while (head != null) {
            Node temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }

        return prev;
    }

}
