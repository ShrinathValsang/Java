package com.freecodecamp.multithreading;

import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Test3 {
    public static void main(String[] args) {
//        Program for permutations
//        Input: str = “cd”
//        Output: cd, dc
//        Input: str = “ABC”
//        Output: ABC,ACB,BAC,BCA,CBA,CAB
        //permutations("ABCD", "");

        int[] arr = {12, 16, 22, 30, 35, 39, 42, 45, 48, 50, 53, 55, 56};
        List<Integer> findClosestKElements = findClosestKElements(arr, 35, 4);
        System.out.println(findClosestKElements);
    }

    public static void permutations(String st, String prefix) {
        if (st.isEmpty()) {
            System.out.println(prefix);
        } else {
            for (int i = 0; i < st.toCharArray().length; i++) {
                char ch = st.charAt(i);
                String rem = st.substring(0, i) + st.substring(i + 1);
                permutations(rem, prefix + ch);
            }

        }
    }

    public static List<Integer> findClosestKElements(int[] arr, int x, int k) {
        PriorityQueue<Integer> pqueue = new PriorityQueue<>(Comparator.comparingInt(i -> -Math.abs(i - x)));
        for (int i : arr) {
            pqueue.add(i);
            if (pqueue.size() > k) pqueue.poll();
        }

        return pqueue.stream().toList();
    }

}
