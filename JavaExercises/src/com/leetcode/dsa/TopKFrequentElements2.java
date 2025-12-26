package com.leetcode.dsa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.stream.Collectors;


public class TopKFrequentElements2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {7,3,6,6,6,2,2,3,13};
		int[] nums2 = {18,6,3,2,2,3,4,2,8,7,8,8,8,8,3,4,5,2};
		int k = 2;
		
		int[] result = new TopKFrequentElements2().topKFrequent(nums2, 3);
		System.out.println(Arrays.stream(result).boxed().collect(Collectors.toList()));
		
	}
	
	// 
    public int[] topKFrequent(int[] nums, int k) {
    	int len = nums.length, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
    	
        for (int n : nums) {
        	if (n > max) max = n;
        	if (n < min) min = n;
        }
        
        int[] freq = new int[max-min+1];
        /*for (int i = 0; i < len; i++) {
        	freq[nums[i] - min]++;
        }*/
        for (int n : nums) {
        	freq[n - min]++;
        }
        
        //List<Integer>[] bucket = new ArrayList[freq.length];
        List<Integer>[] bucket = new ArrayList[len + 1];
        
        int maxocc = 0;
        for (int j = 0; j < freq.length; j++) {
        	if (bucket[freq[j]] == null) 
        		bucket[freq[j]] = new ArrayList<>();
        	
        	bucket[freq[j]].add(j + min);
        	if (freq[j] > maxocc) maxocc = freq[j];
        }
        
        int[] res = new int[k];
        int m = 0;
        for (int i = maxocc; i > 0; i--) {
        	if (bucket[i] != null) {
        		for (int d : bucket[i]) {
        			res[m++] = d;
        			if (m == k) break;
        		}
        	}
			if (m == k) break;
        }
        
    	return res;
    }

}
