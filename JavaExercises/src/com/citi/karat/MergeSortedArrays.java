package com.citi.karat;

// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.lang.String;

class MergeSortedArrays {
    public static void main(String[] args) {
        System.out.println("Start small. Ship something.");

        List<String> list = List.of("One", "Two", "Three");
        List<String> list2 = List.of("Four", "Five", "Zero");
        List<List<String>> lists = List.of(list, list2);

        System.out.println(lists);

        var var1 = lists.stream()
                .flatMap(l -> l.stream())
                .collect(Collectors.toList());
        System.out.println(var1);

        var var2 = list.stream()
                //.map(String::length)
                .map(s -> s)
                .collect(Collectors.toList());
        System.out.println(var2);

        var s = MergeSortedArrays.returnsSomething();
        System.out.println(s);
        int[] arr1 = {1, 3, 5, 7};
        int[] arr2 = {2, 4, 6, 8};

        int[] res = MergeSortedArrays.mergeSortedArrays(arr1, arr2);
        System.out.println(Arrays.toString(res));
    }

    // Time O(n+m)
    // Space O(n+m)
    public static int[] mergeSortedArrays(int[] a1, int[] a2) {
        int[] result = new int[a1.length + a2.length];
        int index1 = 0, index2 = 0, index  = 0;

        while (index1 < a1.length && index2 < a2.length) {
            if (a1[index1] <= a2[index2]) {
                result[index++] = a1[index1++];
            } else{
                result[index++] = a2[index2++];
            }
        }

        while (a1.length > index1) result[index++] = a1[index1++];
        while (a2.length > index2) result[index++] = a2[index2++];

        return result;
    }

    public static String returnsSomething() {
        try {
            return "A";
        } finally {
            System.out.println("cleanup");
            //return "B";
        }
    }

}

