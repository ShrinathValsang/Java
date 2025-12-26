package com.prepare.java;// Java Program 24

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class JavaPrimalityTest2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String n = bufferedReader.readLine();
        bufferedReader.close();

        Integer bn = Integer.valueOf(n);
        // System.out.println(bn.isProbablePrime(1) ? "prime" : "not prime");

        // n <= 0 -- number is not prime
        // n == 1 -- number is not prime

        boolean prime = checkPrime(bn);
        if (prime) {
            System.out.println("prime");
        } else {
            System.out.println("not prime");
        }

//        for (int i = 3; i < ((bn+1)/2); i=i+2) {
//
//        }

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


//        public static boolean checkPrime(int n)
//        {
//            if (n <= 1)
//                return false;
//
//            int i = 2;
//            while (i <= n / 2)
//            {
//                if ((n % i) == 0)
//                    return false;
//                i++;
//            }
//
//            return true;
//        }


    }

    private static boolean checkPrime(Integer bn) {
        boolean flag = true;

        if (bn == 2) {
            //System.out.println("prime");
            flag = true;
        } else if (bn <= 0 || bn == 1 || bn % 2 == 0) {
            //System.out.println("not prime");
            flag = false;
        }

        int i = 3;
        while (i <= (bn + 1)/2) {
            if (bn % i == 0) {
                flag = false;
                break;
            }

            i += 2;
        }

        return flag;
    }
}
