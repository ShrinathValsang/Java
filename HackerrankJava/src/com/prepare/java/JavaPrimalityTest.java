package com.prepare.java;// Java Program 24

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class JavaPrimalityTest {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String n = bufferedReader.readLine();
        bufferedReader.close();

        BigInteger bn = new BigInteger(n);
        System.out.println(bn.isProbablePrime(1) ? "prime" : "not prime");

        /*int i = new Integer(n);
        boolean prime = true;
//        int i = 13;

        if (i < 0 || (i != 2 && i % 2 == 0)) {
            prime = false;
        } else if (i == 2 || i == 1) {
            prime = true;
        } else {
            for (int j = 3; j < i; j = j+2) {
                if (i % j == 0) {
                    prime = false;
                }
            }
        }

        if (prime) {
            System.out.println("prime");
        } else {
            System.out.println("not prime");
        }*/

    }
}
