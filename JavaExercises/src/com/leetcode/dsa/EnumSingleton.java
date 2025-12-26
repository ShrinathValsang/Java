package com.leetcode.dsa;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

// 1. enums are inherently Serializable
// 2. no reflection problem
public enum EnumSingleton {
	INSTANCE;
	
	int value;

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
	public static void main(String...a) {
		String[] fruits = {"Banana", "Apple", "Jackfruit", "Pomegranate", 
				"Apple", "Jackfruit", "Banana", "Apple", "Grapes", "Jackfruit"};
		List<String> fruitList = List.of(fruits);  
		
		Map<String, Integer> map = fruitList.stream()
			.distinct()
			.collect(Collectors.toMap(
							Function.identity(), 
							v -> Collections.frequency(fruitList, v)
					)
			);
		
		System.out.println(map);
	}
	
}
