package com.interviews;

import java.util.Arrays;

// Online Java Compiler
// Use this editor to write, compile and run your Java code online
class SortAndPartitionArray {
    public static void main(String[] args) {
        System.out.println("Start small. Ship something.");

        int[] arr1 = {1,0,1,1,0,0,1,1,0};
        int[] arr2 = {1,1,1, 1,1};
        int[] arr3 = {0,0,0,0,0};
        int[] arr4 = {1,1,1,1,0};

        int[] arr = {5, 0, 2, 0, 4, 0, 1, 0, 3, 0};
        int[] result = new SortAndPartitionArray().sortAndPartitionArray2(arr);

        System.out.println("result: " + Arrays.toString(result));



        // Given I/P ->
        int [] input = { 23, 0, 12, 0, 67, 0, 9 , 0 };
        // Expected o/p -> { 0, 0, 0, 0, 23, 12, 67, 9 }

        System.out.println("Input: " + Arrays.toString(input));
        System.out.println("Partition without sorting: " + Arrays.toString(partitionArrayWithLeadingZeros(input)));
        System.out.println("Partition with sorting:    " + Arrays.toString(sortAndPartitionArray(input)));
    }

    // Place the zeros first and then the non-zero elements unsorted
    public static int[] partitionArrayWithLeadingZeros(int[] input) {
        return Arrays.stream(input)
                .boxed()
                .sorted((a, b) -> {
                    if (a == 0 && b != 0) return -1; // a before b
                    if (b == 0 && a != 0) return 1; // a before b
                    return 0; // default
                })
                .mapToInt(Integer::intValue)
                .toArray();
    }

    public static int[] sortAndPartitionArray(int[] input) {
        return Arrays.stream(input)
                .boxed()
                .sorted((a, b) -> {
                    if (a == 0 && b != 0) return -1;
                    if (a != 0 && b == 0) return 1;
                    return Integer.compare(a, b);
                })
                .mapToInt(Integer::intValue)
                .toArray();
        //return new int[0];
    }

    // Two-pointer approach to solve the sort and partition array problem
    public static int[] sortAndPartitionArrayTwoPointer(int[] input) {
        int left = 0, right = input.length - 1;

        while (left < right) {
            while (left < right && input[left] == 0) left++;
            while (left < right && input[right] != 0) right--;

            // This will work but order of non-zero elements won't be maintained!
            // if we want to preserve order swap technique cannot be used.
            // Output -- [0, 0, 0, 0, 67, 12, 9, 23]
            if (left < right) {
                int temp = input[right];
                input[right] = input[left];
                input[left] = temp;
                left++; right--;
            }
        }

        return input;
    }

    // 2. Given an array containing 0s and numbers, arrange the non-zero numbers in ascending order and move all 0s to the right.
    // Input: [5,0,2, 0,1,3,0,4,1,2]
    // Output: [1,1,2,2,3,4,5,0,0,0]
    // Explain the approach and logic used in the solution.
    public int[] sortAndPartitionArray1(int[] arr) {
        return Arrays.stream(arr)
                .boxed()
                .sorted((a, b) -> {
                /*if (a > b) return -1;
                else if (a < b) return 1;
                else if (a == b) return 0;
                else return 0;*/ // returns result: [5, 4, 3, 2, 1, 0, 0, 0, 0, 0]
                    if (a == 0 && b == 0) return 0;
                    else if (a == 0 && b != 0) return 1;
                    else if (a != 0 && b == 0) return -1;
                    else return Integer.compare(a, b);
                })
                .mapToInt(Integer::intValue)
                .toArray();
    }

    // 1. Given an array containing only 0s and 1s, move all 1s to the left and all 0s to the right.
    // Input: [1,0,1,1,0,0,1,1,0]
    // Output: [1,1,1,1,1,0,0,0,0]
    // Solve the problem specifically using the Two Pointer approach.
    // Explain the approach and logic used in the solution.
    public int[] partitionArray(int[] arr) {
        int left = 0, right = arr.length - 1;

        while (left < right) {
            //while (arr[left] == 1) left++;
            while (left < right && arr[left] == 1) left++;

            //while (arr[right] == 0) right--;
            while (left < right && arr[right] == 0) right--;

            if (left < right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
        }

        //return new int[0];
        return arr;
    }

    // One more simpler approach
    public int[] sortAndPartitionArray2(int[] arr) {
        int index = 0;
        for (int i : arr) {
            if (i != 0) {
                arr[index++] = i;
            }
        }

        int nonZeroCount = index;
        while (index < arr.length) {
            arr[index++] = 0;
        }

        Arrays.sort(arr, 0, nonZeroCount);
        return arr;
    }

}
