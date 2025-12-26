package com.prepare.java;

// Java Program 19
public class JavaRegex {
    public static void main(String[] args) {
        /*Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String IP = in.next();
            System.out.println(IP.matches(new com.prepare.java.MyRegex().pattern));
        }*/

        String IP = "0.0.0.0"; //should be true but result is false
        //String IP = "255.0.255.0";
        System.out.println(IP.matches(new MyRegex().pattern));
    }
}

//Write your code here
class MyRegex {
//     String pattern = "^(([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])\\.){3}" +
//             "([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])";

//    String pattern = "^(([01]?[0-9][0-9]|2[0-4][0-9]|25[0-5])\\.){3}" +
//            "([01]?[0-9][0-9]|2[0-4][0-9]|25[0-5])";

    String pattern = "^(([01]?[0-9][0-9]?|2[0-4][0-9]|25[0-5])\\.){3}" +
            "([01]?[0-9][0-9]?|2[0-4][0-9]|25[0-5])";
}
//12.12.12.12
//        13.13.13.112
//        VUUT.12.12 false
//        111.111.11.111
//        1.1.1.1.1.1.1 false
//        .....  false
//        1...1..1..1 false
//        0.0.0.0
//        255.0.255.0
//        266.266.266.266 false
//        00000.000000.0000000.00001 false
//        0023.0012.0012.0034 false


//        Expected Output
//
//        Download
//        true
//        true
//        false
//        true
//        false
//        false
//        false
//        true
//        true
//        false
//        false
//        false