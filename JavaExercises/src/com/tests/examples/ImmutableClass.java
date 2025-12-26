package com.tests.examples;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;

public final class ImmutableClass {

	private final int id;
	private final String name;
	private final HashMap<Integer, String> testMap;
	private TreeSet map;
	Hashtable table;
	ConcurrentHashMap<Integer, String> table1;

	/**
	 * Constructor performing Deep Copy.
	 */
	public ImmutableClass(int i, String n, HashMap<Integer, String> hm) {
		// Performing Deep Copy for Object initialization
		this.id = i;
		this.name = n;
		
		HashMap<Integer, String> tempMap = new HashMap<Integer, String>();
		for (Map.Entry<Integer, String> entry : hm.entrySet()) {
			tempMap.put(entry.getKey(), entry.getValue());
		}
		
		this.testMap = tempMap;
	}
	
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	// Getter for mutable objects
	public HashMap<Integer, String> getTestMap() {
		return (HashMap<Integer, String>) testMap.clone();
	}

	/**
	 * To test the consequences of Shallow Copy and how to avoid it with Deep
	 * Copy for creating immutable classes
	 * 
	 */
	public static void main(String[] args) {
		HashMap<Integer, String> h1 = new HashMap<Integer, String>();
		h1.put(1, "first");
		h1.put(2, "second");

		String s = "original";

		int i = 10;

		ImmutableClass ce = new ImmutableClass(i, s, h1);

		// Lets see whether its copy by field or reference
		System.out.println(s == ce.getName());
		System.out.println(h1 == ce.getTestMap());
		
		// print the ce values
		System.out.println("\nBefore local variable change");
		System.out.println("ce id:" + ce.getId());
		System.out.println("ce name:" + ce.getName());
		System.out.println("ce testMap:" + ce.getTestMap());
		
		// change the local variable values
		i = 20;
		s = "modified";
		h1.put(3, "third");
		
		// print the values again
		System.out.println("\nAfter local variable change");
		System.out.println("ce id:" + ce.getId());
		System.out.println("ce name:" + ce.getName());
		System.out.println("ce testMap:" + ce.getTestMap());

		HashMap<Integer, String> hmTest = ce.getTestMap();
		hmTest.put(4, "new");

		System.out.println("\nce testMap after changing variable from accessor methods:" + ce.getTestMap());
	}
}
