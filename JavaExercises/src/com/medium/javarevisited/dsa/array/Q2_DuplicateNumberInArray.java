package com.medium.javarevisited.dsa.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * How do you find the duplicate number on a given integer array?
 * 
 */
public class Q2_DuplicateNumberInArray {

	public static void main(String[] args) {
		int[] arr = IntStream.range(1, 101).toArray();

		Random random = new Random();

		int ri = random.nextInt(arr.length);
		int rn = random.nextInt(arr.length);
		arr[ri] = rn;

		System.out.println("rn = " + rn);

		// shuffle
		List<Integer> list = Arrays.stream(arr).boxed().toList();
		// OR
		// IntStream.of(arr).boxed().collect(Collectors.toList());

		// But above methods return immutable collection
		// Here is a way to get a mutable collection
		List<Integer> list2 = Arrays.stream(arr).boxed().collect(Collectors.toCollection(ArrayList::new));

		Collections.shuffle(list2);

		// Integer collection to int array
		arr = list.stream().mapToInt(Integer::intValue).toArray();

		Set<Integer> set = new HashSet<>();

		boolean flag = true;
		int i = 0;
		while (flag) {
			flag = set.add(arr[i++]);
		}

		int duplicate = arr[--i];
		// IntStream.range(0, arr.length).collect(Collectors.toM)
		System.out.println("Duplicate number: " + duplicate);
		
		// approach 1 -- above approach uses extra collection space O(n), O(n)
		
		// approach 2 -- use sort and compare two consecutive elements
		// for multiple duplicates we can map. put => key present, returns previous value, key absent returns null
		
		int[] intArr = new int[]{8, 4, 2, 6, 1, 7, 4, 16, 9, 2, 5};
		Arrays.sort(intArr);
		
		for (int ii = 0; ii < intArr.length; ii++) {
			if (intArr[ii] == intArr[ii+1]) {
				
			}
		}
		
		
		/*
		 * List<String> list6 = List.of("Shrinath", "Abhiram", "Java");
		 * 
		 * // Collector<String, StringBui>
		 * 
		 * 
		 * 
		 * Collector<Integer, ?, TreeSet<Integer>> intoSet = Collector.of(TreeSet::new,
		 * TreeSet::add, (left, right) -> { //left.addAll(right); return left;
		 * right.addAll(left); return right; });
		 * 
		 * List<Integer> intList = List.of(1,2,3,4,5);
		 * 
		 * TreeSet<Integer> myt = intList.stream().collect(intoSet);
		 * System.out.print(myt);
		 * 
		 * Base b = new Child(); //Child b = new Child(); //b.display();
		 */		
		
	}

}

class Base {
    public void display() throws Exception {
        System.out.println("Inside Base");
    }
}

class Child extends Base {
    
    public void display() {
        System.out.println("Inside Child");
    }
}
