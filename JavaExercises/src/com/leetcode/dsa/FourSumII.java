package com.leetcode.dsa;

import java.util.HashMap;
import java.util.Map;

public class FourSumII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums1 = {1,2}, nums2 = {-2,-1}, nums3 = {-1,2}, nums4 = {0,2};
		System.out.println(new FourSumII().fourSumCount(nums1, nums2, nums3, nums4));

	}
	
    public int fourSumCount1(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
    	int res = 0;
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                for (int k = 0; k < nums3.length; k++) {
                    for (int l = 0; l < nums4.length; l++) {
                    	if (nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0)
                    		res++;
                    }
                }
            }
        }
        
        return res;
    }
    
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
	    int res = 0;
	    Map<Integer, Integer> map = new HashMap<>();
	    for (int i : nums1) {
	        for (int j : nums2) {
	            int sum = i + j;
	            map.put(sum, map.getOrDefault(sum, 0) + 1);
	        }
	    }
	    for (int k : nums3) {
	        for (int l : nums4) {
	            int sum1 = k + l;
	            res += map.getOrDefault(-sum1, 0);
	        }
	    }
	    return res;
    }
}
