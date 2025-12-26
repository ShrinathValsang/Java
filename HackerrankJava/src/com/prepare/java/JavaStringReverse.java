package com.prepare.java;// Java Program 15

import java.util.Scanner;

public class JavaStringReverse {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String A = sc.next();
        /* Enter your code here. Print output to STDOUT. */
        int l = A.length();
        int n = l/2 + l%2;

        /*for (int i = 0; i < n; i++) {
            if (A.charAt(i) == A.charAt(n-i)) {
                continue;
            } else {
                System.out.println("No");
                break;
            }
            //System.out.println("Yes");
        }


        while (A.charAt(i) == A.charAt(n-i)) {
            i++;
        }*/

        int i = -1;
        boolean flag = true;
        while (n > 0) {
            n--; i++;

            if (A.charAt(i) == A.charAt(l-i-1)) {
                continue;
            } else {
                flag = false;
            }
        }

        if (flag) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}