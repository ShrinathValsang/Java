package com.interviews;

public class MyFunctionImpl {
    public static void main(String[] args) {
        MyFunction<Double, String> myFunction = marks -> {
            if (marks >= 75) {
                return "Distinction";
            } else if (marks >= 66) {
                return "First class";
            } else if (marks >= 60) {
                return "Second class";
            } else if (marks >= 40) {
                return "Passed";
            }
            return "Failed";
        };

        // This will work with Java 22 Guarded patterns
        /*MyFunction1<Double, String> myFunction = marks -> switch ((int) Math.floor(marks)) {
            case int m when m >= 75 -> "Distinction";
            case int m when m >= 66 -> "First class";
            case int m when m >= 60 -> "Second class";
            case int m when m >= 40 -> "Passed";
            default -> "Failed";
        };*/

        /*MyFunction1<Double, String> myFunction2 = marks -> switch (true) {
            case (marks >= 75) -> "Distinction";
            case (marks >= 66) -> "First class";
            case (marks >= 60) -> "Second class";
            case (marks >= 40) -> "Passed";
            default -> "Failed";
        };*/
    }
}

interface MyFunction1<T, R> {
    R transform(T t);
}