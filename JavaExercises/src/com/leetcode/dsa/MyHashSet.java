package com.leetcode.dsa;

import java.util.ArrayList;
import java.util.List;

class MyHashSet {
    private final int capacity = 1000;
    private List<Integer>[] buckets;
    public MyHashSet() {
        buckets = new ArrayList[capacity];
    }
    private int hash(int key) {
        return key % capacity;
    }
    public void add(int key) {
        int index = hash(key);
        if (buckets[index] == null) {
            buckets[index] = new ArrayList<>();
        }
        if (!buckets[index].contains(key)) {
            buckets[index].add(key);
        }
    }
    public void remove(int key) {
        int index = hash(key);
        if (buckets[index] != null) {
            buckets[index].remove((Integer) key);
        }
    }
    public boolean contains(int key) {
        int index = hash(key);
        return buckets[index] != null && buckets[index].contains(key);
    }

	/**
	 * Your MyHashSet object will be instantiated and called as such:
	 * MyHashSet obj = new MyHashSet();
	 * obj.add(key);
	 * obj.remove(key);
	 * boolean param_3 = obj.contains(key);
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}
