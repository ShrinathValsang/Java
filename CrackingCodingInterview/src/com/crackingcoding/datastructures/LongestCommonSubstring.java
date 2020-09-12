package com.crackingcoding.datastructures;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class LongestCommonSubstring {

    // Complete the twoStrings function below.
    static String getLongestCommonSubstring(String s1, String s2) {
    	int m = s1.length();
    	int n = s2.length();
    	//s1 = s1.toLowerCase();
    	//s2 = s2.toLowerCase();
    	
    	int max = 0, endIndex = -1;
    	int[][] dp = new int[m][n];
    	
    	for (int i = 0; i < m; i++) {
    		for (int j = 0; j < n; j++) {
        		if (s1.charAt(i) == s2.charAt(j)) {
        			// a letter is common 
        			if (i == 0 || j == 0) {
        				dp[i][j] = 1;
        			} else {
        				// Add 1 to the diagonal value ??
        				dp[i][j] = dp[i-1][j-1] + 1;
        			}
        			
        			if (max < dp[i][j]) {
        				max = dp[i][j];
        				endIndex  = i;
        			}
        		}
        	} //inner for loop ends here.
    	}

        return s1.substring(endIndex+1-max, endIndex+1);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s1 = scanner.nextLine();

            String s2 = scanner.nextLine();

            String result = getLongestCommonSubstring(s1, s2);
            System.out.println(result);
            //bufferedWriter.write(result);
            //bufferedWriter.newLine();
        }

        //bufferedWriter.close();

        scanner.close();
    }
}

