package com.generic;

// Online Java Compiler
// Use this editor to write, compile and run your Java code online

import static java.util.Map.Entry.comparingByValue;
import jdk.jfr.Frequency;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

interface Animal {
    void makeNoise();
    //void eat();
}

class Dog implements Animal {

    @Override
    public void makeNoise() {
        System.out.println("Dog makes bhow bhow");
    }
}

class Cat implements Animal {

    @Override
    public void makeNoise() {
        System.out.println("Cat makes meow meow");
    }
}

class Main2 {
    public static void main(String[] args) {
        Dog d = new Dog();
        Cat c = new Cat();
        new Main2().makeNoise(d); // Dog makes bhow bhow
        new Main2().makeNoise(c); // Cat makes meow meow

        // top N most frequently occurring
        int N = 2;
        String[] fruitsArr = {"apple", "jackfruit", "mango", "grapes", "", "guava", "cashew", "melon", "grapes", "jackfruit", "mango"};
        List<String> topN = Arrays.stream(fruitsArr).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                //.sorted((Comparator<? super Map.Entry<String, Long>>) Map.Entry.comparingByValue().reversed()).
                .sorted(comparingByValue(Comparator.reverseOrder())).limit(N).map(Map.Entry::getKey).toList();
        System.out.println("topN fruits : " + topN);



        //26-Mar-2026
        // using only streams, implement -- Sum of square of Odd Numbers -- List testLst = {1,2,3,4,5,6,7,8,9,10}
        int[] arr = new int[]{1,2,3,4,5,6,7,8,9,10};
        List<Integer> testList = IntStream.of(arr).boxed().toList(); // Java 16+ -- unmodifiable
        List<Integer> testList1 = IntStream.of(arr).boxed().collect(Collectors.toList()); // modifiable list

        IntStream str = IntStream.of(arr);
        IntStream.of(arr).filter(x -> x % 2 != 0).map(x -> x * x).sum();
        testList.stream().filter(x -> x % 2 != 0).map(x -> x * x).collect(Collectors.toList());

        System.out.println("testList1.add(20): " + testList1.add(20));
        System.out.println("testList.add(201): " + testList.add(201)); // java.lang.UnsupportedOperationException


    }

    public void makeNoise(Animal a) {
        a.makeNoise();
    }
}