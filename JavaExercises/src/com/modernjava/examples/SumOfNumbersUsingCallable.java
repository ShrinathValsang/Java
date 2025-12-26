package com.modernjava.examples;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

// Date 12th Sept 2024
public class SumOfNumbersUsingCallable {
	static int[] arr = IntStream.rangeClosed(0, 5000).toArray();
	static int total = IntStream.rangeClosed(0, 5000).sum();
	
	public static void main(String...args) throws InterruptedException, ExecutionException {
		int arrl = arr.length;
		Callable c1 = () -> {
			int sum1 = 0;
			for (int i = 0; i < arrl/2; i++) {
				sum1 += arr[i];
			}
			
			return sum1;
		};
		
		Callable c2 = () -> {
			int sum2 = 0;
			for (int j = arr.length/2; j < arrl; j++) {
				sum2 += arr[j];
			}
			
			return sum2;
		};
		
		ExecutorService es1 = Executors.newFixedThreadPool(2);
		List<Callable<Integer>> taskList = Arrays.asList(c1, c2);
		List<Future<Integer>> results = es1.invokeAll(taskList);
		
		int sum = 0;
		for (Future<Integer> result : results) {
			//System.out.println(result.get());
			sum += result.get();
		}
		
		System.out.println("Sum from the Callable is: " + sum);
		System.out.println("Sum from the IntStream is: " + total);
		es1.shutdown();
		
		IntPredicate pre;
	}

}
