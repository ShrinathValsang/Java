package com.freecodecamp.new1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Test4 {
    public static void main(String[] args) {
        int[] arr = IntStream.range(0, 10).toArray();
        List list = Arrays.stream(arr).boxed().toList();

        List list2 = IntStream.range(0 ,10).boxed().toList();
        checkEvenOdd(list2);
    }

    public static void checkEvenOdd(List<Integer> numbers) {
        numbers.stream().filter(i -> i % 2 == 0).forEach(System.out::println);
    }
}
