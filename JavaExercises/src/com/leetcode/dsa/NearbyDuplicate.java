package com.leetcode.dsa;

import java.util.Set;
import java.util.TreeSet;

public class NearbyDuplicate {

	public static void main(String[] args) {
//		Input: nums = [1,2,3,1], k = 3
//		Output: true
//		Example 2:
//
//		Input: nums = [1,0,1,1], k = 1
//		Output: true
//		Example 3:
//
//		Input: nums = [1,2,3,1,2,3], k = 2
//		Output: false
		int[] nums = {89, 1, 2, 3, 1, 2, 3 };
		int k = 2;
//		int[] nums = {1,2,3, 1};
//		int k = 3;
		System.out.println(new NearbyDuplicate().containsNearbyDuplicate(nums, k));

	}

	/*
	 * public boolean containsNearbyDuplicate(int[] nums, int k) { int len =
	 * nums.length, iter = 0; for (int i = 0; i < len; i++) { int limit = len >
	 * (i+k+1) ? (i+k+1) : len;
	 * 
	 * //for (int j = i+1; j < len; j++) { for (int j = i+1; j < limit; j++) {
	 * iter++; if (nums[i] == nums[j] && Math.abs(i - j) <= k) {
	 * System.out.println("iterations: " + iter); return true; } } }
	 * 
	 * System.out.println("iterations: " + iter); return false; }
	 */

	// 15ms
	public boolean containsNearbyDuplicate(int[] nums1, int k) {
		int[] nums = {89, 1, 2, 3, 1, 2, 3 };
		// Set<Integer> set = new HashSet<Integer>();
		Set<Integer> set = new TreeSet<Integer>();
		int iter = 1;

		System.out.println("set size -- " + set.size());
		for (int i = 0; i < nums.length; i++) {
			System.out.println("set size second -- " + set.size() + " " + set);
			iter++;
			if (i > k) {
				set.remove(nums[i - k - 1]);
			}

			boolean op = set.add(nums[i]);
			if (!op) {
				System.out.println("iterations: " + iter);
				return true;
			}
		}

		System.out.println("iterations: " + iter);
		return false;
	}

	/*public boolean containsNearbyDuplicate(int[] nums, int k) {
		Set<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (i > k)
				set.remove(nums[i - k - 1]);
			if (!set.add(nums[i]))
				return true;
		}
		return false;
	}*/

}
