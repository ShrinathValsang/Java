package com.generic;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Longest1sInBinaryNumber {
	
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        String s = Integer.toBinaryString(n);

        char[] ns = s.toCharArray();
        int max = 0, cont = 0;
        for (int j = 0; j < ns.length; j++) {
            if (ns[j] == '1') {
                cont++;
                max = cont > max ? cont : max;
            } else {
                cont = 0;
            }
        }

        System.out.println(max);
        scanner.close();

    }
}
