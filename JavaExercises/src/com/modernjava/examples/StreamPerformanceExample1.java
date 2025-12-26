package com.modernjava.examples;

import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class StreamPerformanceExample1 {
	static long tokenCount = 50000;

	public static void main(String[] args) {
		int loop = 2000;
		long result = measurePerformnce(StreamPerformanceExample1::sortSeqStream, loop);
		System.out.println("Sequential stream time taken in millis -- " + result);
		
		long result2 = measurePerformnce(StreamPerformanceExample1::sortParallelStream, loop);
		System.out.println("Parallel stream time taken in millis -- " + result2);
		
//		Sequential stream time taken in millis -- 3609
//		Parallel stream time taken in millis -- 2202
	}
	
	public static long measurePerformnce(Supplier<Long> supplier, int numberOfTimes) {
		long startTime = System.currentTimeMillis();
		for (int i = 0; i < numberOfTimes; i++) {
			supplier.get();
		}		
		
		return System.currentTimeMillis() - startTime;
	}
	
	
	public static long sortSeqStream() {
		List<RandomTokens> tokens1 = LongStream.rangeClosed(0, tokenCount)
				.mapToObj(i -> {
					return new RandomTokens(i, ThreadLocalRandom.current().nextLong(tokenCount));
				}).collect(Collectors.toList());
		
		tokens1.stream().sorted(Comparator.comparing(RandomTokens::getTokens));
		return -1;
	}
	
	public static long sortParallelStream() {
		List<RandomTokens> tokens2 = LongStream.rangeClosed(0, tokenCount)
				.parallel()
				.mapToObj(i -> {
					return new RandomTokens(i, ThreadLocalRandom.current().nextLong(tokenCount));
				}).collect(Collectors.toList());
		
		tokens2.stream().sorted(Comparator.comparing(RandomTokens::getTokens));
		return -1;
	}

}

class RandomTokens {
	long id;
	long tokens;
	
	public RandomTokens(long id, long tokens) {
		super();
		this.id = id;
		this.tokens = tokens;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getTokens() {
		return tokens;
	}

	public void setTokens(long tokens) {
		this.tokens = tokens;
	}
}
