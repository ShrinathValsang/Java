package com.interviews;

// Questions -
// Q1. Given an integer array and a window size K, return the maximum element in every sliding window.
//
// Q2. Given an array of values, for each element find the next greater element on the right.
//
// Q3. Given an integer array, count the number of subarrays whose sum equals K.
//
// Q4. Given a binary tree, flatten it into a linked list in-place following the same order as a pre-order traversal.
//


import java.util.*;

class TreeNode {
    int val;
    TreeNode right, left;

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode right, TreeNode left) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                ", right=" + right +
                ", left=" + left +
                '}';
    }
}

public class MaximumElementInEverySlidingWindow {

    private static TreeNode prev = null;

    public static void main(String[] args) {
        int[] arr1 = new int[]{2, 53, 81, 40, 6, 73, 15, 62, 29, 34, 83, 51, 59, 7, 46, 3, 11};
        int[] arr = new int[]{2, 53, 81, 40, 6, 73, 15, 62};

        int windowSize = 4;

        int[] result = getMaximumElementInEachWindow(arr, windowSize);
        /*System.out.println("Result: " + Arrays.toString(result));

        result = getMaximumElementSlidingWindow(arr, windowSize);
        System.out.println("Using Priority queue, \nResult: " + Arrays.toString(result));

        result = getMaximumElementSlidingWindowUsingDeque(arr, windowSize);
        System.out.println("Using Deque, \nResult: " + Arrays.toString(result));

        result = slidingWindowMaximum(arr, windowSize);
        System.out.println("Using Deque1, \nResult: " + Arrays.toString(result));


        result = nextGreaterElement(arr);
        System.out.println("Next greater element: \nResult: " + Arrays.toString(result));

        result = nextGreaterElementDeque(arr);
        System.out.println("Next greater element using deque: \nResult: " + Arrays.toString(result));*/


        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(6);
        flatten(root);
        System.out.println(root);

        TreeNode curr = root;
        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.right;
        }

        TreeSet<Integer> treeSet = new TreeSet<>();

        int[] nums = new int[]{1, 2, 3, 4, 1, 0}; int k = 5;
        int count = countSubarrays(nums, k);
        System.out.println("\nNo of subrrays in " + Arrays.toString(nums) + ", k=" + k + " is: " + count);

        nums = new int[]{1, 2, 3}; k = 3; // Output : 2
        count = countSubarrays(nums, k);
        System.out.println("No of subrrays in " + Arrays.toString(nums) + ", k=" + k + " is: " + count);

        nums = new int[]{10, 2, -2, -20, 10}; k = -10; // Output : 3
        count = countSubarrays(nums, k);
        System.out.println("No of subrrays in " + Arrays.toString(nums) + ", k=" + k + " is: " + count);

        nums = new int[]{9, 4, 20, 3, 10, 5}; k = 33; // Output : 2
        count = countSubarrays(nums, k);
        System.out.println("No of subrrays in " + Arrays.toString(nums) + ", k=" + k + " is: " + count);


    }

    // Q3. Given an integer array, count the number of subarrays whose sum equals K.
    private static int countSubarrays(int[] nums, int k) {
        int count = 0, sum = 0;
        Map<Integer, Integer> prefixMap = new HashMap<>();
        prefixMap.put(0, 1); // base case;

        for (int num : nums) {
            sum += num;

            if (prefixMap.containsKey(sum - k)) {
                count += prefixMap.get(sum - k);
            }

            prefixMap.put(sum, prefixMap.getOrDefault(sum, 0)+1);
        }

        return count;
    }


    // Q4. Given a binary tree, flatten it into a linked list in-place following the same order as a pre-order traversal.
    public static void flatten(TreeNode root) {
        if (root == null) return;

        flatten(root.right);
        flatten(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }

    // Q2. Given an array of values, for each element find the next greater element on the right.
    private static int[] nextGreaterElement(int[] input) {
        int l = input.length;
        int[] result = new int[l];

        for (int i = 0; i < l - 1; i++) {
            for (int j = i + 1; j < l; j++) {
                if (input[i] < input[j]) {
                    result[i] = input[j];
                    break;
                }
            }
        }

        return result;
    }

    private static int[] nextGreaterElementDeque(int[] input) {
        int l = input.length;
        int[] result = new int[l];
        Arrays.fill(result, -1);

        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = l - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= input[i]) {
                stack.pop();
            }

            if (!stack.isEmpty()) {
                result[i] = stack.peek();
            } /*else {
                result[i] = -1;
            }*/

            stack.push(input[i]);
        }

        return result;
    }

    // Q1. Given an integer array and a window size K, return the maximum element in every sliding window.
    private static int[] getMaximumElementInEachWindow(int[] arr, int k) {
        int al = arr.length, rs = al - k + 1; // al = array length, rs = result size
        int[] result = new int[rs];

        /*TreeSet<Integer> tset = new TreeSet<>(Arrays.stream(arr, 0, k).boxed().toList());
        //for (int i = 0; i < rs; i++) {
        for (int i = 3; i < arr.length; i++) {

        }*/

        for (int i = 0; i < rs; i++) {
            int max = arr[i];
            for (int j = 1; j <= 3; j++) {
                max = Math.max(max, arr[i + j]);
            }

            result[i] = max;
        }

        return result;
    }

    // offer
    private static int[] getMaximumElementSlidingWindow(int[] arr, int k) {
        int al = arr.length, rs = al - k + 1; // al = array length, rs = result size
        int[] result = new int[rs];


        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);


        for (int i = 0; i < k; i++) {
            pq.offer(new int[]{arr[i], i}); // store as [value, index]
        }
        result[0] = pq.peek()[0]; // for the first window get the maximum value and add to the result array


        for (int j = k; j < al; j++) {
            pq.offer(new int[]{arr[j], j});

            // remove elements outside the window
            while (pq.peek()[1] <= j - k) {
                pq.poll();
            }
            result[j - k + 1] = pq.peek()[0];
        }

        return result;
    }

    private static int[] getMaximumElementSlidingWindowUsingDeque(int[] nums, int k) {
        int l = nums.length, rs = l - k + 1;
        int[] result = new int[rs];

        Deque<Integer> deque = new ArrayDeque<>(); // stores indices

        for (int i = 0; i < l; i++) {

            // 1. Remove elements out of the window
            while (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }

            // 2. Maintain decreasing order in the queue
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            // 3. Add current index
            deque.offerLast(i);

            // 4. Record max (front of the queue) once we have a full window
            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.peekFirst()];
            }

        }

        return result;
    }

    private static int[] slidingWindowMaximum(int[] nums, int k) {
        int l = nums.length;
        int result[] = new int[l - k + 1];

        Deque<Integer> dq = new ArrayDeque<Integer>(); // stores indices only

        for (int i = 0; i < l; i++) {
            // 1. Remove elements outside the current window
            if (!dq.isEmpty() && dq.peekFirst() <= i - k) {
                dq.pollFirst();
            }

            // 2. Remove smaller elements
            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {
                dq.pollLast();
            }

            // 3. Add current index
            dq.offer(i);

            // 4. Get the maximum from the current window
            if (i >= k - 1) {
                result[i - k + 1] = nums[dq.peekFirst()];
            }
        }

        return result;
    }

}
