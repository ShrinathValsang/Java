package com.modernjava.examples;

import java.util.function.Supplier;
import java.util.function.Supplier;
import java.util.stream.IntStream;

public class ParallelStreamsExamples {

	public static void main(String[] args) {
		long l = IntStream.rangeClosed(1, 500).parallel().sum();
		System.out.println(l);
		
		System.out.println("Seq stream sum of 50000 -- " + sumSeqStream());
		System.out.println("Parallel stream sum of 50000 -- " + sumParallelStream());
		
		long seq = measurePerformance(ParallelStreamsExamples::sumSeqStream, 20);
		System.out.println("Sequential stream time taken in millisecs " + seq);
		long para = measurePerformance(ParallelStreamsExamples::sumParallelStream, 20);
		System.out.println("Parallel stream time taken in millisecs " + para);
	}
	
	public static long measurePerformance(Supplier<Integer> supplier, int noOfTimes) {
		long startTime = System.currentTimeMillis();
		for (int i = 0; i < noOfTimes; i++) {
			supplier.get();
		}
		return System.currentTimeMillis() - startTime;
	}
	
	public static int sumSeqStream() {
		return IntStream.rangeClosed(1, 50000).sum();
	}
	
	public static int sumParallelStream() {
		return IntStream.rangeClosed(1, 50000).parallel().sum();
	}

}
