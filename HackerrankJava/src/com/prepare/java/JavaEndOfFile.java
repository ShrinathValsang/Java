package com.prepare.java;

import java.util.Scanner;

// Java Program 7
public class JavaEndOfFile {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT.
         Your class should be named com.prepare.java.Solution. */
        Scanner scanner = new Scanner(System.in);

        int i = 1;
        while (scanner.hasNext()) {
            String s = scanner.nextLine();
            System.out.println(i++ + " " + s);
        }
    }
}
