package com.interviews;

import java.util.Arrays;
import java.util.stream.Collectors;

// TestGorilla - ADCB 20-Sep-2026
public class ValidateAtmPin {
    public static void main(String[] args) {
        System.out.println("Start small. Ship something.");


        String[] pins = {
                "1234",
                "123456",
                "654321",
                "4321",
                "1357",
                "1235",
                "1123",
                "112345",
                "12a4",
                "123",
                "12345",
                "9876",
                "9087"
        };

        for (String pin : pins) {
            int[] arr = pin.chars().map(i -> i - '0').toArray();
            System.out.println(Arrays.toString(arr));

            // pin.chars().map(i -> i - '0').collect(Collectors.toList()); -- compilation error
            // Remember - IntStream is not the same as Stream<Integer>, IntStream is stream of primitive int values

            System.out.println(pin + " -> " + validateAtmPin(pin));
        }
    }



    /**
     * Validate ATM PIN and return
     0 - 4-digit valid PIN
     1 - 6-digit valid PIN
     2 - any other length
     3 - if contains any non-digit char
     4 - if any digit is repeated
     5 - if the integers are in ascending or descending order
     */
    public static int validateAtmPin(String atmPin) {
        int pinl = atmPin.length(), result = -1;
        if (pinl != 4 && pinl != 6) return 2;

        for (char c : atmPin.toCharArray()) {
            if (!Character.isDigit(c)) {
                return 3;
            }
        }

        boolean isDigitRepeated = hasRepeatedDigitis(atmPin);
        if (isDigitRepeated) return 4;

        boolean isSequential = isPinSequential(atmPin);
        if (isSequential) return 5;

        if (pinl == 4) result = 0;
        if (pinl == 6) result = 1;

        return result;
    }

    private static boolean hasRepeatedDigitis(String atmPin) {
        /*int[] arr = new int[10];

        for (char c : atmPin.toCharArray()) {
            if (arr[c - '0'] > 0) return true;
            arr[c - '0']++;
        }*/
        boolean[] seen = new boolean[10];
        for (char c : atmPin.toCharArray()) {
            if (seen[c - '0']) return true;
            seen[c - '0'] = true;
        }

        return false;
    }

    // Using
    // pin.charAt(i - 1) - '0'
    // is much simpler compared to
    // Integer.parseInt(String.valueOf(pin.charAt(i))
    // or
    // Character.digit(pin.charAt(i), 10)
    //
    //              boxed()
    // IntStream ──────────────→ Stream<Integer>
    // 
    private static boolean isPinSequential(String pin) {
        boolean ascending = true;
        boolean descending = true;
        int pinl = pin.length();

        /*for (int i = 1; i < pinl; i++) {
            int a = pin.charAt(i) - '0';
            int b = pin.charAt(i-1) - '0';

            if (a != b + 1) return false;
            if (a != b - 1) return false;
        }*/
        for (int i = 1; i < pin.length(); i++) {
            int previous = pin.charAt(i - 1) - '0';
            int current = pin.charAt(i) - '0';

            // As the pin is already validate to contain digits only, this also works!
            // if (pin.charAt(i) != pin.charAt(i - 1) + 1) -- '1' + 1 = '2', '3' - 1 = '2' etc.
            if (current != previous + 1) {
                ascending = false;
            }

            if (current != previous - 1) {
                descending = false;
            }
        }

        return (ascending || descending);
    }

}
