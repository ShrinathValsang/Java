package com.tests.examples;

public class MergedSortedArrays {

	public static void main(String[] args) {
		int[] nums1 = {1, 2, 3, 0, 0, 0};
		int[] nums2 = {2, 5, 6};
		int[] arr = new MergedSortedArrays().merge(nums1, 3, nums2, 3);
		System.out.println(arr);
	}
	
	//public void merge(int[] nums1, int m, int[] nums2, int n) {
    public int[] merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m-1, j = n-1, k = m+n-1;

        while (j >= 0) {
            if (i >= 0 && (nums1[i] > nums2[j])) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }
        
        return nums1;
    }

}
