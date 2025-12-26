package com.prepare.java;

// Java Program 16
import java.util.Scanner;

public class JavaAnagrams {

    static boolean isAnagram(String a, String b) {
        // Complete the function
        boolean flag = true;
        // Map<String, Long> result = Arrays.stream(str.split("")).map(String::toLowerCase).collect(Collectors.groupingBy(s -> s, LinkedHashMap::new, Collectors.counting()));

        char[] a1 = a.toLowerCase().toCharArray();
        char[] b1 = b.toLowerCase().toCharArray();
        // Arrays.sort(a1);
        // Arrays.sort(b1);
        // Arrays.equals(a1, b1);

        if (a1.length != b1.length) {
            return false;
        }

        int[] a2 = new int[256];
        int[] b2 = new int[256];

        for (int i=0; i < a1.length; i++) {
            //a2[(int) a1[i]]++;
            a2[(int) a1[i]] = a2[(int) a1[i]] + 1;
            b2[(int) b1[i]] += 1 ;
        }

        for (int i=0; i < 256; i++) {
            if (a2[i] != b2[i]) {
                return false;
            }
        }

        return flag;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );
    }
}