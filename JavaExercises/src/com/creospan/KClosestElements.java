package com.creospan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class KClosestElements {

	public static void main(String[] args) {
		//Input: K = 4, X = 35
		int K = 4, X = 35;
		int[] arr = { 12, 16, 22, 30, 35, 39, 42, 45, 48, 50, 53, 55, 56 };
		
		List<Integer> result = findKClosestElementsOfX(arr, X, K);
		System.out.println(result);
		
		// second example
		int[] arr1 = { 1, 3, 4, 7, 8, 9 };
		int k = 3, x = 6;
		List<Integer> result1 = findKClosestElementsOfX(arr1, x, k);
		System.out.println(result1);
		
		List<Integer> res1 = findKClosestElementsUsingStack(arr1, x, k);
		System.out.println("\nK closest elements using PriorityQueue -- " + res1);
	}
	
	// https://algo.monster/liteproblems/658
	public static List<Integer> findKClosestElementsOfX(int[] arr, int x, int k) {
		int l = arr.length;
		int left = 0;
		int right = l - k;
		
		while (left < right) {
			int mid = left + (right - left) / 2;
			
			if ((x - arr[mid]) <= (arr[mid+k] - x)) {
				right = mid;
			} else {
				left = mid + 1;
			}
		}
		
		/*List<Integer> result = new ArrayList<>();
		
		for (int i = left; i < left+k; i++) {
			result.add(arr[i]);
		}
		
		return result;*/
		return Arrays.stream(arr, left, left + k).boxed().collect(Collectors.toList());
	}
	
	public static List<Integer> findKClosestElementsUsingStack(int[] arr, int x, int k) {
		List<Integer> result = new ArrayList<>();
		
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.comparingInt(i -> -Math.abs(i - x)));
		
		for (int i : arr) {
			maxHeap.add(i);
			
			if (maxHeap.size() > k) {
				maxHeap.poll();
			}
		}
		
		return maxHeap.stream().toList();
	}

}

// Rumango - Shaibal Biswas 14th November 2024 1600-1700Hrs
// Write a program to Find k closest elements to a given value
// Input: K = 4, X = 35
// int arr[i] = {12, 16, 22, 30, 35, 39, 42, 45, 48, 50, 53, 55, 56}
// Output: 30 39 42 45 
