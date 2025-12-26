package com.modernjava.examples;

import java.util.Optional;
import java.util.function.Supplier;

public class OptionalExamples {
	public static void main(String...args) throws Exception {
		Integer[] numbers = new Integer[10];

		Optional<Integer> num = Optional.ofNullable(numbers[0]);
		int result = num.orElse(-1);
		System.out.println("result = " + result);
		
		numbers[0] = 1;
		
		// orElse
		num = Optional.ofNullable(numbers[0]);
		result = num.orElse(-1);
		System.out.println("result after init = " + result);
		
		//orElseGet
		num = Optional.ofNullable(numbers[1]);
		result = num.orElseGet(() -> -100);
		System.out.println("result num.orElseGet = " + result);

		//orElseThrow -- for numbers[0] -- no exception
		num = Optional.ofNullable(numbers[0]);
		result = num.orElseThrow(Exception::new);
		System.out.println("result num.orElseThrow = " + result);
		
		//orElseThrow -- for numbers[2] -- throws exception
		/*
		num = Optional.ofNullable(numbers[2]);
		result = num.orElseThrow(Exception::new);
		System.out.println("result num.orElseThrow = " + result);
		*/
		
		//ifPresent isPresent
		Optional<String> so = Optional.ofNullable("Hello world");
		if (so.isPresent()) {
			System.out.println(so.get());
		}
		
		so.ifPresent(s -> System.out.println(s));

	}

}
