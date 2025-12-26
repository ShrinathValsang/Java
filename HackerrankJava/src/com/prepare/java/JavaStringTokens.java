package com.prepare.java;// Java Program 17

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class JavaStringTokens {
    public static void main(String[] args) {
//        Scanner scan = new Scanner(System.in);
//        String s = scan.nextLine();
//        // Write your code here.
//        scan.close();

        String s = "He is a very very good boy, isn't he?";
        String[] tokens = s.split("[!?,._'@ ]");

        String[] new1 = Arrays.asList(tokens)
                .stream()
                .filter(str -> !str.isEmpty())
                .collect(Collectors.toList())
                .toArray(new String[0]);

        System.out.println(new1.length);
        for (int i=0; i < new1.length; i++) {
            System.out.println(new1[i]);
        }
    }
}