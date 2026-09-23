package com.coding.interviews;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CustomArraySplitter {
    public static void main(String[] args) {
        System.out.println("Hello, World!");

        int[] original = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        int splitSize = 3;

        int[] original1 = { 0, 1};
        List<int[]> result = new CustomArraySplitter().splitArray(original, splitSize);
        result.forEach(splitArray -> System.out.println(Arrays.toString(splitArray)));
    }

    public List<int[]> splitArray(int[] arr, int splitSize) {
        List<int[]> result = new ArrayList<>();

        /*if (arr.length <= splitSize) {
            return List.of(arr);
        }*/

        for (int i = 0; i < arr.length;  i += splitSize) {
            int end = Math.min(arr.length, i+splitSize);
            int[] a = Arrays.copyOfRange(arr, i, end);
            result.add(a);
        }

        // result.forEach(splitArray -> System.out.println(Arrays.toString(splitArray)));
        return result;
    }
}