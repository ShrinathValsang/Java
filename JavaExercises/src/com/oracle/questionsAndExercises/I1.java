package com.oracle.questionsAndExercises;

import java.util.Comparator;

public interface I1 {

}


class MyClass {
	public static void main(String...args) {
		
		Comparator<String> comp = Comparator.naturalOrder();
		Comparator<String> comp1 = Comparator.<String>naturalOrder();
		Comparator<String> comp2 = Comparator.<String>naturalOrder().reversed();
		Comparator<String> comp3 = Comparator.<String>reverseOrder();
		
	}
}