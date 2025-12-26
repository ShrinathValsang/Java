package com.prepare.java;// Java Program 23

import java.math.BigDecimal;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class JavaBigDecimal {
    public static void main(String []args){
        //Input
        /*Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] s = new String[n+2];
        for (int i=0;i<n;i++){
            s[i] = sc.next();
        }
        sc.close();*/

        int n = 10;
        String[] s = new String[] {"9", "-100", "50", "0", "56.6", "90", "0.12", ".12", "02.34", "000.000"};
        //Write your code here
        //String[] s1 = Arrays.copyOf(s, n);
        for (int i=0; i<n; i++) {
            int index = i;
            BigDecimal first = new BigDecimal(s[i]);

            for (int j=i+1  ; j<n; j++) {
                BigDecimal second = new BigDecimal(s[j]);

                if (second.compareTo(first) == 1) {
                    first = second;
                    index = j;
                }
            }

            String temp = s[i];
            s[i] = s[index];
            s[index] = temp;
        }

        //Output
        for (int i=0; i<n; i++) {
            System.out.println(s[i]);
        }
    }
}

//Arrays.sort(s,0,n,Collections.reverseOrder(new Comparator<String>()
//        {
//@Override
//public int compare(String s1,String s2)
//        {
//        BigDecimal b1=new BigDecimal(s1);
//        BigDecimal b2=new BigDecimal(s2);
//        return b1.compareTo(b2);
//        }
//        }));