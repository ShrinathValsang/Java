package com.sagar.streams;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GenericCodingExamples {

	public static void main(String[] args) {
		// 1. Concat two lists without duplicates
		List<Integer> list1 = List.of(1, 2, 3, 4, 4, 5);
		List<Integer> list2 = List.of(1, 2, 3, 4, 6, 5);
		
		//List<Integer> finalList = Stream.concat(list1.stream(), list2.stream()).distinct().toList();
		List<Integer> finalList = Stream.concat(List.of(1,2,3).stream(), list2.stream()).distinct().toList();
		System.out.println("Concat two lists without duplicates: " + finalList);
		
		
		// 2. Average marks of the students 
		// 3. Average marks of EACH the student
		String[] input = {"Akash 78", "Bharat 89", "Akash 90", "Akash 70", "Chetan 67", "Bharat 88", "Bharat 94", "Chetan 84"};
		
		Map<String, List<Integer>> map = new HashMap<>();
		for (String stmark : input) {
			String[] arr = stmark.split(" ");
			
			List<Integer> list = map.getOrDefault(arr[0], new ArrayList<Integer>());
			list.add(Integer.valueOf(arr[1]));
			map.put(arr[0], list);
			
			//map.computeIfAbsent(arr[0], k -> new ArrayList<Integer>()).add(Integer.valueOf(arr[1]))
			//map.put(arr[0], map.computeIfAbsent(arr[0], k -> new ArrayList<Integer>()).add(Integer.valueOf(arr[1])));
		}
		
		Map<String, Double> resultMap = map.entrySet().stream().collect(
				Collectors.toMap(
						Map.Entry::getKey, 
						entry -> entry.getValue().stream().mapToInt(Integer::intValue).average().orElse(0.0))
				);
		System.out.println("Average marks of the students: " + resultMap);
		
	}

}
