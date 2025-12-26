package com.freecodecamp.multithreading;

import java.util.Collections;
import java.util.List;

public class Test6 {

    public static void main(String[] args) {
        String s = "Hyderabad";

        // identify duplicate characters
        List<Character> list = s.chars().mapToObj(c -> (char) c).toList();
        List<Character> duplicates = list.stream().filter(c -> Collections.frequency(list, c) > 1).toList();
        list.stream().filter(c -> Collections.frequency(list, c) > 1).distinct().forEach(c -> System.out.print(c + " "));

        // remove the duplicates and print -- keep the first occurrence
        System.out.println("\nString after removing duplicates");
        list.stream().filter(c -> Collections.frequency(list, c) == 1).forEach(c -> System.out.print(c + " "));
    }
}
