package com.sahilandsarra.interview_master_100;

 
public class P13_MajorityElement {

	public static void main(String[] args) {
		P13_MajorityElement ts = new P13_MajorityElement();

		int[] nums = {-1,0,3,5,9,12};
		//int target = 9;
		int target = 13;
		
 	}
	
	public int majorityElement(int[] nums) {
		int count = 0, candidate = 0;
		
		for (int num : nums) {
			if (count == 0) candidate = num;
			
			count += (num == candidate) ? 1 : -1;
		}
		
		return candidate;
    }
	
}