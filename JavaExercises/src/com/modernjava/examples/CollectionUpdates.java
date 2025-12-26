package com.modernjava.examples;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class CollectionUpdates {

	public static void main(String[] args) {
		List<String> names = List.of("Mike", "Jenny", "Syed");
		System.out.println(names);
		//names.add("new"); // java.lang.UnsupportedOperationException
		
		//List<String> names1 = List.of("Mike", "Jenny", "Syed", null); //java.lang.NullPointerException
		List<String> names2 = Collections.unmodifiableList(names);
		System.out.println(names2);
		//names2.add("new");
		
		//Set<String> names3 = Set.of("Mike", "Jenny", "Jenny"); //java.lang.IllegalArgumentException: duplicate element: Jenny
		names.sort(Comparator.naturalOrder()); //java.lang.UnsupportedOperationException
		
		
 
	}

}
