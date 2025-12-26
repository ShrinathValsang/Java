package com.generic;

import java.io.*;
import java.util.*;

/*

3
12
5
7

2
31
33

*/
public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        while (n-- > 0) {
            checkPrime(sc.nextInt());
        }
    }

    // good but can be improved
    // if we can check for 2 separately and then 
    // increment loop by starting count from 3 -- 3, 5, 7 and so on
    static void checkPrime(int k) {
    	boolean flag = false;
        for (int i = 2; i <= k/2; i++) {
            if (k % i == 0) {
            	flag = true;
                //System.out.println("Not prime");
                //return;
            }
        }
        
        if (flag) {
        	System.out.println("Not prime");
        } else {
        	
        }
        
        System.out.println("Prime");
    }
}

/*
30
1
4
9
16
25
36
49
64
81
100
121
144
169
196
225
256
289
324
361
400
441
484
529
576
625
676
729
784
841
907

*/