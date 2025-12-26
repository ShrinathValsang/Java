package com.freecodecamp.multithreading;

public class Test2 {
    public static void main(String[] args) {

        // Create a program to convert fixed
        // String "1,3,2,4,6,5,7*9,8,11,12,13,14,15,16,17,18,19.20.24,25,33,34,36,60,99"
        // to an ARRAY of numbers, replace * and . with commas.
        // Display output of array elements to console of all numbers evenly divisible by 3
        // except the numbers 3 and 9 and 99.  Do NOT use collections or streams. Example output 6,12,15....
        String s = "1,3,2,4,6,5,7*9,8,11,12,13,14,15,16,17,18,19.20.24,25,33,34,36,60,99";

        // first replace the * and . with comma
        s = s.replace('*', ',').replace('.', ',');
        // System.out.println(s);

        String[] sarr = s.split(",");
        int[] ia = new int[sarr.length];
        for (int i = 0; i < sarr.length; i++) {
            ia[i] = Integer.valueOf(sarr[i]);
        }

        for (int i = 0; i < sarr.length; i++) {
            // System.out.print(ia[i] + " ");
            // all numbers evenly divisible by 3 except the numbers 3 and 9 and 99
            if (ia[i] % 3 == 0 && ia[i] != 3 && ia[i] != 9 && ia[i] != 99) {
                System.out.print(ia[i] + " ");
            }
        }




        // convert the string to
    }
}
