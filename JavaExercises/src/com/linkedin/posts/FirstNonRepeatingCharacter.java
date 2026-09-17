package com.linkedin.posts;

// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.LinkedHashMap;
import java.util.Arrays;

class FirstNonRepeatingCharacter {
    public static void main(String[] args) {
        System.out.println("Start small. Ship something.");
        String str = "abbcda";


        String c = Arrays.asList(str.split(""))
                .stream()
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        LinkedHashMap::new,
                        Collectors.counting()
                ))
                .entrySet().stream()
                .filter(e -> e.getValue() == 1)
                .findFirst()
                .get().getKey();

        System.out.println("First non-repeating character in String " + str + " is : " + c);
    }
}

// charCount.entrySet().stream()
//         .filter(entry -> entry.getValue() == 1)
//         .findFirst()
//         .ifPresent(entry -> System.out.println(entry.getKey()));
