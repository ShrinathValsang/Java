package com.generic;

import java.util.Arrays;

// "Merge a2 into a1 in-place, assuming a1 has enough empty space at the end"
public class MergeArrayInPlace {
    public static void main(String... args) {
        int[] arr1 = {1, 3, 5, 7, 0, 0, 0, 0};
        int[] arr2 = {2, 4, 6, 8};

        int[] result = mergeArraysInPlace(arr1, arr2);
        System.out.println(Arrays.toString(result));
    }

    private static int[] mergeArraysInPlace(int[] arr1, int[] arr2) {
        // assuming arr1 is larger and can accommodate arr2
        int l1 = arr1.length - 1, l2 = arr2.length - 1, fl = l1;

        while (l1 > 0 && l2 > 0) {
            if (arr1[l1] < arr2[l2]) {
                int temp = arr1[l1];
                arr1[l1] = arr2[l2];
                arr2[l2] = temp;
            }
        }



        return arr1;
    }
}
