package com.generic;

public class MaximumSumSubarray {

    public static void main(String[] args) {

    }

    public static int getMaxSumOfSubarray(int[] arr) {
        int right = 0, left = 0, maxSum = 0, windowSum = 0;

        // while (right++ < arr.length) {
        while (right < arr.length) {
            windowSum += arr[right++];

            maxSum = Math.max(maxSum, windowSum);

            windowSum -= arr[left++];
        }

        return maxSum;
    }

    public static int[] getSubarrayWithMaxSum(int[] arr) {

        return new int[0];
    }
}
