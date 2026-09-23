package com.leetcode.dsa;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

//
// https://leetcode.com/problems/sliding-window-maximum/
// https://neetcode.io/solutions/sliding-window-maximum
//

public class SlidingWindoMaximum {
    public static void main(String[] args) {
        int[] nums2 = {1,3,-1,-3,5,3,6,7};
        System.out.println(Arrays.toString(nums2) + ": " + Arrays.toString(maxSlidingWindow(nums2, 3)));

        int[] nums1 = {1};
        System.out.println(Arrays.toString(nums1) + ": " + Arrays.toString(maxSlidingWindow(nums1, 3)));

        int[] nums= {1, 3, -1, -3, 5, 3, 6, 7 }; int k = 3;
        System.out.println("Brute force: " + Arrays.toString(slidingWindowMaximumBF(nums, k)));
        System.out.println("Monotonic queue: " + Arrays.toString(slidingWindowMaximumBF(nums, k)));


        int[] nums3= {1, 3}; int k3 = 3;
        System.out.println("Brute force: " + Arrays.toString(slidingWindowMaximumBF(nums3, k3)));
        System.out.println("Monotonic queue: " + Arrays.toString(slidingWindowMaximumBF(nums3, k3)));
    }

    public static int[] slidingWindowMaximum(int[] nums, int k) {
        // handle edge case
        if (nums.length - k + 1 <= 0) return new int[0];

        int[] result = new int[nums.length - k + 1];

        // we store only indices of the ints
        Deque<Integer> dq = new ArrayDeque<>();

        for (int i = 0; i < nums.length; i++) {
            // 1. remove indices outside the CURRENT window
            while (!dq.isEmpty() && dq.peekFirst() <= i - k ) {
                dq.pollFirst();
            }

            // 2. remove smaller elements from the back
            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {
                dq.pollLast();
            }

            // 3. add the element
            dq.offer(nums[i]);

            // 4. find the max and return
            if (i >= k - 1) {
                result[i - k + 1] = nums[dq.peekFirst()];
            }
        }

        return result;
    }

    public static int[] slidingWindowMaximumBF(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];

        for (int i = 0; i < res.length; i++) {
            int windowMax = Integer.MIN_VALUE;
            for (int j = i; j < i + k; j++) {
                windowMax = Math.max(windowMax, nums[j]);
            }
            res[i] = windowMax;
        }

        return res;
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int l = nums.length;
        if (l-k+1 <= 0) return new int[0];

        int[] result = new int[l-k+1];
        // stores indices only
        Deque<Integer> dq = new ArrayDeque<>();

        for (int i = 0; i < l; i++) {
            // 1. Remove indices out of the CURRENT window
            if (!dq.isEmpty() && dq.peekFirst() <= i - k) {
                dq.pollFirst();
            }

            // 2. Remove smaller elements from the back
            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {
                dq.pollLast();
            }

            // 3. Add the current element
            dq.offer(i);

            // 4. Get the maximum and store in the result array
            if (i >= k - 1) {
                result[i-k+1] = nums[dq.peekFirst()];
            }

        }

        return result;

    }
}