package com.bnymellon;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.function.Predicate;

// Given an integer array and a window size K, return the maximum element in every sliding window
public class MaximumElementInSubarray {

    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] result = getMaxElementInSubarrayUsingDeque(nums, k);
        System.out.println("getMaxElementInSubarrayUsingDeque: " + Arrays.toString(result));
        result = getMaximumElementInSubarrayOfWindowK(nums, k);
        System.out.println("getMaximumElementInSubarrayOfWindowK: " + Arrays.toString(result));


        List<String> names = new ArrayList<>(List.of("qxz", "asdfa", "jnbxhw", "ab", "efi", "bca", "afff"));
        List<String> kept = new ArrayList<>();

        for (String s : names) {
            if (s.length() > 3) {
                kept.add(s);
            }
        }

        Predicate<String> lengthGreaterThan3 = s -> s.length() > 3;
        names.stream().filter(lengthGreaterThan3).toList();

        Predicate<String> lengthGreaterThan2 = s -> s.length() > 2;
        Predicate<String> startsWithA = s -> s.startsWith("a");

        List<String> result1 = filterNames(names, lengthGreaterThan2);
        System.out.println("lengthGreaterThan2 : " + result1);
        List<String> result2 = filterNames(names, startsWithA);
        System.out.println("startsWithA : " + result2);



    }

    public static List<String> filterNames(List<String> list, Predicate<String> condition) {
        return list.stream().filter(condition).toList();
    }

    public int[] getMaxElementInSubarray(int[] arr, int k) {
        int result[] = new int[arr.length - k + 1];

        for (int i = 0; i <= arr.length - k; i++) {
            int max = arr[i];
            for (int j = 1; j < k; j++) {
                max = Math.max(max, arr[i+j]);
            }
            result[i] = max;
        }

        return result;
    }

    /*public int[] getMaxElementInSubarray2(int[] arr, int k) {
        int result[] = new int[arr.length - k + 1];
        int max = 0;

        for (int i = 0; i <= arr.length - k; i++) {
            max = Math.max(max, arr[i]);

            if (i > k-1) {
                max = Math.max(max, arr[i]);
                result[i-k+1] = max;

            }
        }

        return result;
    }*/ // wrong - previous element is not excluded while calculating the the window max

    // Deque methods -
    // INSERT       offer()     add()
    // REMOVE       poll()      remove()
    // EXAMINE      peek()      get()
    //
    public static int[] getMaxElementInSubarrayUsingDeque(int[] arr, int k) {
        int result[] = new int[arr.length - k + 1];
        int len = arr.length;

        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < len; i++) {
            // remove elements outside window - remove from front/top
            while (!deque.isEmpty() && deque.peek() < i - k + 1) {
                deque.poll();
            }

            // remove smaller elements from the back / bottom
            while (!deque.isEmpty() && arr[deque.peekLast()] < arr[i]) {
                deque.pollLast();
            }

            // add current element
            deque.offer(i);

            // get max for current window - is always the index of the maximum in the current window
            if (i >= k - 1) {
                result[i - k + 1] = arr[deque.peek()];
            }
        }

        return result;
    }

    public static int[] getMaximumElementInSubarrayOfWindowK(int[] arr, int k) {
        int len = arr.length;
        int[] result = new int[len - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < len; i++) {
            while (!deque.isEmpty() && deque.peek() < (i - k + 1)) {
                deque.poll();
            }

            // remove elements smaller from current element from back/bottom
            while (!deque.isEmpty() && arr[deque.peekLast()] < arr[i]) {
                deque.pollLast();
            }

            // add index to deque to the front
            deque.offer(i);

            if (i - k + 1 > 0) {
                result[i - k + 1] = deque.peek();
            }
        }

        return result;
    }

}
