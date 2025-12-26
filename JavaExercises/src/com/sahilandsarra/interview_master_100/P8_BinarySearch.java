package com.sahilandsarra.interview_master_100;

public class P8_BinarySearch {

	public static void main(String[] args) {
		P8_BinarySearch ts = new P8_BinarySearch();

		int[] nums = {-1,0,3,5,9,12};
		//int target = 9;
		int target = 13;
		System.out.println(ts.search(nums, target));
 	}
	
	public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        
        while (left <= right) {
        	int pointer = left + (right - left)/2;
        	
            if (nums[pointer] == target) return pointer;
            else if (nums[pointer] > target) right = pointer - 1;
            else left = pointer + 1;
        }
        
        return -1;
    }
	
	
	
}