package com.leetcode.dsa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class IntersectionOfTwoArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		 int[] nums1 = {1,2,2,1};
//		 int[] nums2 = {2,2};
//		 int[] nums1 = {4,9,5};
//		 int[] nums2 = {9,4,9,8,4};
		 int[] nums1 = {3,1,2};
		 int[] nums2 = {1,1};
		 
		 int[] intersection = new IntersectionOfTwoArrays().intersect(nums1, nums2);
		 
		 IntStream.of(intersection).forEach(x -> System.out.print(x + ", "));
	}

    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }
        		
        /*List<Integer> list1 = IntStream.of(nums1).boxed().collect(Collectors.toList());
        List<Integer> list2 = IntStream.of(nums2).boxed().collect(Collectors.toList());
	  
        list1.retainAll(list2); 
        return list1.stream().(Integer::valueOf).toArray();*/
		 
        
        /*List<Integer> list1 = IntStream.of(nums1).boxed().collect(Collectors.toList());
        
        for (int i = 0; i < nums2.length; i++) {
        	list1.
        	nums2[i];
        }
        
        return null;*/
        
        /*List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums1.length; i++) {
        	for (int j = 0; j < nums2.length; j++) {
            	if (nums1[i] == nums2[j]) {
            		list.add(nums1[i]);
            		//continue outer;
            		break;
            	}
            }
        }*/
        

        /*List<Integer> list2 = IntStream.of(nums2).boxed().collect(Collectors.toList());
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums1.length; i++) {
        	for (int j = 0; j < list2.size(); j++) {
            	if (nums1[i] == list2.get(j)) {
            		list.add(nums1[i]);
            		list2.remove(j);
            		break;
            	}
            }
        }
        
        return list.stream().(Integer::valueOf).toArray();*/
        
		/*
		 * List<Integer> l1 = IntStream.of(nums2).boxed().collect(Collectors.toList());
		 * 
		 * Arrays.stream(nums1) .filter(x -> Arrays.stream(nums2).anyMatch(y -> y ==
		 * x));
		 */
        
        return null;
    }

}
