package com.sahilandsarra.interview_master_100;

import java.util.HashMap;
import java.util.Map;

public class P1_TwoSum {

	public static void main(String[] args) {
		int[] nums = {2,7,11,15};
		int target = 9;
		
		int[] nums1 = {3,2,4};
		int target1 = 6;
		
		P1_TwoSum ts = new P1_TwoSum();
		int[] result = ts.twoSum(nums1, target1);
		
		System.out.println("[" + result[0] + ", " + result[1] + "]");
	}
	
	public int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            } else {
                map.put(nums[i], i);
            }
            /*for (int j = i+1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] {i, j};
                }
            }*/
        }

        return new int[]{-1, -1};      
    }
}
