package com.rough;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class TestClass2 {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("first");
        list.add("second");
        list.add("third");
        list.add("fourth");
        list.add("fifth");
        list.add("sixth");

        String middle = list.get(list.size()/2);
        System.out.println("Middle element: " + middle);

        String first = list.getFirst();

        Map<Integer, String> map = new HashMap<>();

    }

    public <T> void printArray(T[] array) {
        for (T t : array) {
            System.out.println(t);
        }

        //Arrays.stream(array).forEach(e -> System.out.println(e));
    }
}
