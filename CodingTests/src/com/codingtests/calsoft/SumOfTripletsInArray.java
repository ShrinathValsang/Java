package com.codingtests.calsoft;

import java.util.Arrays;

/**
 * Given an array of distinct integers and a , find the number of triplets of 
 * the numbers in the array whose sum is less than the given sum value.
 * 
 * Mettl test - 30/06/2020
 */
// input: {5, 1, 3, 4, 7}, sum value = 12;
// output: 4 ({1, 3, 4}, {1, 3, 5}, {1, 3, 7}, {1, 4, 5})
public class SumOfTripletsInArray {
	public static void main(String...args) {
		int[] arr = {5, 1, 3, 4, 7};
		int sumValue = 12;
//		System.out.println(getNumberOfTriplets(arr, sumValue));
		

		//int [] arr1 = {5, 1, 3, 4, 7, 8, 2, 6, 9};
		int [] arr1 = {5, 1, 3, 4, 7, 8, 2};
		sumValue = 12;
		System.out.println(getNumberOfTriplets(arr1, sumValue));
	}

	private static int getNumberOfTriplets(int[] arr, int sumValue) {
		int triplets = 0, iter = 0;
		int al = arr.length;
		Arrays.sort(arr);
		
		if (al < 3) return triplets;
		
		for (int i=0; i < al-2; i++) {iter++;
			for (int j=i+1; j < al-1; j++) {iter++;
				for (int k=j+1; k < al; k++) {iter++;
					if ((arr[i] + arr[j] + arr[k]) < sumValue) {
						triplets++;
					} else break;
				}
			}
		}
		System.out.println(iter);
		return triplets; //System.out.println(iter);
	}
}
