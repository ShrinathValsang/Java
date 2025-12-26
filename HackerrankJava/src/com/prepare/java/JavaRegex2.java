package com.prepare.java;// Java Program 20

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// https://stackoverflow.com/questions/9147270/regex-in-java-for-finding-duplicate-consecutive-words
// https://www.hackerrank.com/challenges/duplicate-word/forum

public class JavaRegex2 {
    public static void main(String[] args) {
        // The ?: is added to make it a "non-capturing group" (meaning you can't do group() to get the group), for slightly faster performance.
        String regex = "\\b(\\w+)(?:\\W+\\1\\b)+";
        Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);

        Scanner in = new Scanner(System.in);
        int numSentences = Integer.parseInt(in.nextLine());

        while (numSentences-- > 0) {
            String input = in.nextLine();
            Matcher m = p.matcher(input);

            // Check for subsequences of input that match the compiled pattern
            while (m.find()) {
                input = input.replaceAll(m.group(), m.group(1));
            }

            // Prints the modified sentence.
            System.out.println(input);
        }

        in.close();
    }
}