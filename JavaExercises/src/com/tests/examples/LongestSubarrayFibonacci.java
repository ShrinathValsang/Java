package com.tests.examples;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


public class LongestSubarrayFibonacci {

	public static void main(String[] args) {
		/*
	    // INPUT [uncomment & modify if required]
	    Scanner sc = new Scanner(System.in);
	    int N = sc.nextInt();
	    
	    int A [] = new int[N];
	    for(int i=0; i<N; i++) {
	        A[i] = sc.nextInt();
	    }
	    
	    // OUTPUT [uncomment & modify if required]
	    sc.close();
	    */
		
//	    int arr[] = {11, 8, 21, 5, 3, 28, 4};
//	    int N1 = 7;
	    
	    int arr[] = {25, 100, 36};
	    int N1 = 3;
	    
	    //System.out.print(longestSubarray(N1,arr));
	    
	    int[] arr1 = {1,2,3,4,5,6,7,8};
	    System.out.println(lenLongestFibSubseq(arr1));
	    
	}
	
	public static int lenLongestFibSubseq(int[] arr) {
        //int largest = Arrays.stream(arr).max().getAsInt()

        Set<Integer> set = new HashSet<>();
        int[] fibArr = new int[40];
        fibArr[0] = 0; fibArr[1] = 1;

        for (int i = 2; i < 40; i++) {
            fibArr[i] = fibArr[i-1] + fibArr[i-2];
            set.add(fibArr[i]);
        }

        int result = -1, ml = 0;
        for (int k = 0; k < arr.length; k++) {
            if (set.contains(arr[k])) {
                ml++;
            } else {
                ml = 0;
            }

            result = Math.max(result, ml);
        }

        return result;
    }

	public static int longestSubarray(int N, int A[]) {
	    //this is default OUTPUT. You can change it.
	    int result=-404;
	    
	    //write your Logic here:
	    /*Set<Integer> fibSet = new HashSet<>();
	
	    int[] fib = new int[200];
	    fib[0] = 0; fib[1] = 1;
	    for (int i = 2; i < 200; i++) {
	        fib[i] = fib[i-2] + fib[i-1];
	        fibSet.add(fib[i]);
	    }*/
	    
	    int largest = Arrays.stream(A).max().getAsInt();
	    System.out.println("largest: " + largest);
	    
	    int fib1 = 0, fib2 = 1;
	    Set<Integer> fibSet = new HashSet<>();
	    
	    do {
	    	int temp = fib1;
	    	fib1 = fib2;
	    	fib2 = temp + fib2;
	    	fibSet.add(fib2);
	    } while (fib1 <= largest);
	
	    //int result = 0;
	    int l = 0;
	    for (int i = 0; i < N; i++) {
	        if (fibSet.contains(A[i])) {
	            l++;
	        } else {
	            l = 0;
	        }

            result = Math.max(result, l);
	    }
	    
	    return result;
	}

}
