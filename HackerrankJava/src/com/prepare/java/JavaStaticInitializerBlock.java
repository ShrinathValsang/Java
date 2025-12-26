package com.prepare.java;

import java.util.Scanner;

// Java Program 8
public class JavaStaticInitializerBlock {
    static boolean flag = true;
    static int B, H;

    static {
        Scanner scanner = new Scanner(System.in);
        B = scanner.nextInt();
        scanner.nextLine();
        H = scanner.nextInt();
        scanner.close();

        if (B > 0 && H > 0) {
            flag = true;
        } else {
            flag = false;
            System.out.println("java.lang.Exception: Breadth and height must be positive");
        }
    }

    public static void main(String[] args){
        if (flag) {
            int area = B * H;
            System.out.print(area);
        }
    } //end of main

} // end of class
