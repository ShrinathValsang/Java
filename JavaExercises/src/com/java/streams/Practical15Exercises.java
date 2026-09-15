package com.java.streams;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// https://readmedium.com/15-practical-exercises-help-you-master-java-stream-api-3f9c86b1cf82
//
public class Practical15Exercises {
    public static void main(String...args) {
        // Exercise 1 — Obtain a list of products belongs to category “Books” with price > 100

        List<Product> products = new ArrayList(Arrays.asList(
                new Product("Washing Machine Bosch Front-load 6.5Kg", "Home appliances", 459.00d),
                new Product("The Secret", "Books", 29.00d),
                new Product("Mi TV 43inches", "Home appliances", 299.00d),
                new Product("Patanjali Yoga Sutras", "Books", 49.00d),
                new Product("Harry Potter series", "Books", 149.00d),
                new Product("Google Pixel 9A", "Smartphones", 399.00d)
        ));

        List<Product> booksWithPriceGreaterThan100 = products.stream().filter(p -> p.getCategory() == "Books" && p.getPrice() > 100d).toList();
        System.out.println("list of products belongs to category “Books” with price > 100 : " + booksWithPriceGreaterThan100);




        //3.	Coding question – Find the most repeated element in an array.
        int[] arr = { 1, 2, 4, 8, 5, 8, 2, 1, 1, 1, 6 };

        int mostRepeatedElement = Arrays.stream(arr) // this returns stream of int and NOT integer
                //.mapToObj(i -> Integer.valueOf(i))
                .boxed() // instead mapping use boxed() to convert IntStream to Stream of Integer
                .collect(
                        Collectors.groupingBy(
                                Function.identity(),
                                Collectors.counting()
                        )
                )
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(entry -> entry.getKey())
                .orElse(-1);
        System.out.println("Find the most repeated element in an array : " + mostRepeatedElement);

        // Solution without using Streams
        Map<Integer, Integer> map = new HashMap<>();
        int mostRepeatedElement1 = -1, maxCount = 0;

        for (int i : arr) {
            int count = map.merge(i, 1, Integer::sum);
            if (count > maxCount) {
                maxCount = count;
                mostRepeatedElement1 = i;
            }
        }
        System.out.println("Find the most repeated element in an array : " + mostRepeatedElement1);


        // 3rd highest
        List<Integer> list = List.of(1, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5, 5);

        list.stream().collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()
                        //Collections.frequency(list, e)
                )) // returns Map<Integer, Integer>
                .entrySet().stream()
                //.sorted(Map.Entry.comparingByValue().reverseOrder())
                .sorted(Comparator.comparingLong(Map.Entry::getValue))
                .skip(2).findFirst()
                .map(Map.Entry::getKey).orElse(-1);



    }


}

class Payment {

    private final List<String> transactions;

    public Payment(List<String> transactions) {
        this.transactions = transactions;
    }

    public List<String> getTransactions() {
        return transactions;
    }
}


class Product {

    private String name;
    private String category;
    private double price;

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public Product(String name, String category, double price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                '}';
    }
}



