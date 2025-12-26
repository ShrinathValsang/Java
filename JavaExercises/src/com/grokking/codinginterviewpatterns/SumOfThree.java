package com.grokking.codinginterviewpatterns;

import java.util.Arrays;

public class SumOfThree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// 3Sum using two pointer method -- 
	// Any three elements from the array and not the contiguous triplets
	public static boolean findSumOfThree(int[] nums, int target) {
		Arrays.sort(nums);
		int len = nums.length;
		for (int i = 0; i < len - 2; i++) {
			int left = i + 1, right = len - 1;

			while (left < right) {
				int sum = nums[i] + nums[left] + nums[right];
				if (sum == target) {
					return true;
				} else if (sum < target) {
					left++;
				} else if (sum > target) {
					right--;
				}
			}
		}
		// Replace this placeholder return statement with your code
		return false;
	}
	
	// contiguous triplets
	public static boolean findSumOfThreeWindowMethod(int[] nums, int target) {
		int left = 0, right = nums.length - 1;
		
		for (int i = 1; i < nums.length - 2; i++) {
			if (nums[i-1] + nums[i] + nums[i+1] == target) {
				return true;
			}
		}
		
		return false;
	}
	
	
}