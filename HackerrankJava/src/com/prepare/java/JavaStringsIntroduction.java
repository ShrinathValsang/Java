package com.prepare.java;// Java Program 12

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class JavaStringsIntroduction {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String A = sc.next();
        String B = sc.next();
        /* Enter your code here. Print output to STDOUT. */

        System.out.println(A.length() + B.length());
        String result = "No";

        if (A.compareTo(B) > 0) {
            result = "Yes";
        } /*else {
            result = "Yes";
        }*/

        System.out.println(result);

        String A1 = A.substring(0, 1).toUpperCase() + A.substring(1);
        String B1 = B.substring(0, 1).toUpperCase() + B.substring(1);

        String capitalised = A1 + " " + B1;
        System.out.println(capitalised);
    }
}