package com.medium.javarevisited.dsa.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * How do you find the largest and smallest number in an unsorted integer array?
 * 
 */
public class Q3_LargestSmallestNumberInUnsortedArray {

	public static void main(String[] args) {
		// this produces unmodifiable collection
		List<Integer> list = IntStream.range(1, 101).boxed().toList(); 
		
		int[] arr = IntStream.range(1, 101).toArray();
		// this give a modifiable collection
		List<Integer> list2 = Arrays.stream(arr).boxed().collect(Collectors.toCollection(ArrayList::new));
		Collections.shuffle(list2);
		
		int largest = list.stream().max(Comparator.naturalOrder()).get();
		int smallest = list.stream().min(Comparator.naturalOrder()).get();
		
		System.out.println("Smallest number: " + smallest);
		System.out.println("Largest number: " + largest);
	}

}
