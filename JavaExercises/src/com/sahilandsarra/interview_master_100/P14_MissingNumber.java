package com.sahilandsarra.interview_master_100;

 
public class P14_MissingNumber {

	public static void main(String[] args) {
		P14_MissingNumber ts = new P14_MissingNumber();

		int[] nums1 = {-1,0,3,5,9,12};
		int[] nums = {0, 1};
		//int target = 9;
		int target = 13;
		
		System.out.println(ts.missingNumber(nums));
 	}
	
	public int missingNumber2(int[] nums) {
		int max = Integer.MIN_VALUE, sum = 0;
        boolean zexists = false; 

        if (nums.length == 1) {
            if (nums[0] == 0) return 1;
            if (nums[0] == 1) return 0;
        }

        for (int num : nums) {
            if (num == 0) zexists = true;
            max = Math.max(max, num);
            sum += num;
        }

        if (zexists) {
            int maxsum = max * (max + 1) / 2;
            return ((maxsum - sum) != 0 ? (maxsum - sum) : (max + 1));
        } else return 0;
    }
	
	public int missingNumber(int[] nums) {
	    int n = nums.length;
	    int expectedSum = n * (n + 1) / 2;
	    int actualSum = 0;

	    for (int num : nums) {
	        actualSum += num;
	    }

	    return expectedSum - actualSum;
	}
	
}