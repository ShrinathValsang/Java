package com.linkedin.posts;

// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.Arrays;

class PartitionArray {
    public static void main(String[] args) {
        System.out.println("Start small. Ship something.");

        int[] arr1 = {1,0,1,1,0,0,1,1,0};
        int[] arr2 = {1,1,1, 1,1};
        int[] arr3 = {0,0,0,0,0};
        int[] arr = {1,1,1,1,0};
        int[] result = new PartitionArray().partitionArray(arr);

        System.out.println("result: " + Arrays.toString(result));
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

}

