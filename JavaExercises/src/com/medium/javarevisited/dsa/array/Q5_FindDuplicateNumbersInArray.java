package com.medium.javarevisited.dsa.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * How do you find all pairs of an integer array whose sum is equal to a given
 * number?
 * 
 */
public class Q5_FindDuplicateNumbersInArray {

	public static void main(String[] args) {
		// this produces unmodifiable collection
		List<Integer> list = IntStream.range(1, 101).boxed().toList();
		// modifiable
		IntStream.range(0, 101).boxed().collect(Collectors.toCollection(ArrayList::new));

		int sum = 21;
		int[] arr = { 11, 3, 19, 8, 13, 11, 20, 06, 12, 17, 24, 7, 14, 18, 11, 6, 13 };

		List<Integer> list2 = Arrays.stream(arr).boxed().toList();
		List<Integer> duplicates = list2.stream()
				.filter(i -> Collections.frequency(list2, i) > 1)
				.distinct()
				.toList();

		System.out.println(duplicates);
		
		// Q5.1_FindDuplicateCharacters, Remove and keep first occurrences
		String s1 = "Hyderabad";
		
		String s2 = s1.chars()
			.mapToObj(c -> (char) c)
			.collect(Collectors.toCollection(LinkedHashSet::new))
			.stream().map(String::valueOf).collect(Collectors.joining());
		System.out.println(s2);
		
	}

}
