package com.freecodecamp.new1;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Test {
    static List<int[]> pairs = new ArrayList<>();

    public static void main(String[] args) {
        // Converting int array to stream
        int[] array = {5, 9, 7, 2, 5, 8, 3};
        // Arrays.stream(array).forEach(System.out::println); //-- this doesn't work
        // Converting int array to Integer collection
        // Method 1
        List<Integer> intArr = Arrays.stream(array).boxed().collect(Collectors.toList());
        System.out.println("int[] converted to Integer collection : " + intArr);

        // Method 2
        List<Integer> intArr2 = IntStream.of(array).boxed().collect(Collectors.toList());
        System.out.println("int[] converted to Integer collection : " + intArr2);


        // Q1 - Find out all consecutive characters in a String using Java 8.
        String str = "ABBBCDDEFEFGGH";
        //    Output is B , D and G

        Set<Character> set = IntStream.range(1, str.length())
                .filter(ind -> str.charAt(ind) == str.charAt(ind - 1))
                .mapToObj(i -> str.charAt(i))
                .collect(Collectors.toSet());
        System.out.println("all consecutive characters in the string  " + str + " : " + set);

        // Q2 - Find all pair of elements whose sum=10 using Java 8
        int[] input = {1, 9, 7, 2, 5, 8, 3, 4, 6, 5};
        int[] input1 = {1, 9, 7, 2, 5, 8, 3, 4, 6};
        int sum = 10;
        int len = input1.length;

        System.out.println("The elements whose sum is 10 are: ");
        IntStream.range(0, len)
                .forEach(i -> IntStream.range(i, len)
                        .filter(j -> j != i && sum - input1[j] == input1[i])
                        .forEach(k -> System.out.println("{" + input1[i] + ", " + input1[k] + "}"))
                );

        String str1 = "Hello world!";
        //Arrays.stream(str1.toCharArray()).
        final List<Character> charList = str1.chars().mapToObj(ch -> (char) ch).toList();

        List<Character> set1 = str1.chars().mapToObj(ch -> (char) ch).filter(c -> Collections.frequency(charList, c) > 1).toList();

        //Q3 Find no of occurrences of a character in a String
        String st = "AXYT:DOOGEBBBCDDEFEFGGH";
        List<char[]> list = List.of(st.toCharArray());
        List<char[]> list1 = Arrays.asList(st.toCharArray());

        // convert string to a collection of characters
        charList = Arrays.stream(st.split(""))
                .map(s -> s.charAt(0))
                .collect(Collectors.toList());

        List<Character> chars = st.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
        System.out.println(chars);

        Map<Character, Integer> charOcc = chars.stream().distinct().collect(Collectors.toMap(
                Function.identity(),
                c -> Collections.frequency(chars, c))
        );
        System.out.println("\nNumber of occurrences of each character in string " + st + ": \n" + charOcc);

        // Number of occurrences of ONLY alphabets
        // A-Z -- 65-90, a-z -- 97-122, 0-9 -- 48 - 57

        List<Character> onlyAlphas = st.chars().distinct()
                .filter(c -> Character.isLetter(c))
                .mapToObj(c -> (char) c)
                .collect(Collectors.toList());
        System.out.println("Only alphabets: " + onlyAlphas);

        // Coforge -- nilesh gadhave 25-Oct-24
        // Q1 - most repeated element in an array
        int[] input2 = {1, 2, 3, 4, 2, 2, 3, 4, 4, 4, 5, 5, 4};
        List<Integer> list3 = IntStream.of(input2).boxed().collect(Collectors.toList());

        Optional<Map.Entry<Integer, Long>> result = list3.stream().collect(
                Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()
                )).entrySet().stream().max(Map.Entry.comparingByValue());
        result.ifPresent(entry -> System.out.println("Most repeated element : " + entry.getKey()));

        List<Integer> result2 = list3.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .map(entry -> entry.getKey())
                .collect(Collectors.toList());
        System.out.println("Duplicate elements in the array : " + result2);

        // more efficient
        set1 = list3.stream()
                .filter(i -> Collections.frequency(list3, i) > 1)
                .collect(Collectors.toSet());
        System.out.println("Duplicate elements in the array (simpler) : " + set1);

        int[] arr1 = {1, 2, 3, 4, 2, 2, 3, 4, 4, 4, 5, 5, 4};
        int[] reversed = IntStream.range(1, arr1.length).map(i -> arr1[arr1.length - i]).toArray();
        int ln = arr1.length;
        int[] reversed1 = IntStream.range(0, ln).map(i -> arr1[ln - i - 1]).toArray();

        // Kth largest element
        int[] arr2 = {13, 52, 23, 4, 29, 62, 43, 4, 44, 4, 15, 25, 74};
        System.out.println("findKthLargestElement - " + findKthLargestElement(arr2, 4));


        List<Integer> li = IntStream.range(0, 10).boxed().collect(Collectors.toCollection(ArrayList::new));

        // CreoSpan -- Shashank Shekhar 11th November 2024
        // second largest number without using
        int max = li.get(0), max2 = li.get(0);
        for (int i = 1; i < li.size(); i++) {
            if (li.get(i) > max) {
                max2 = max;
                max = li.get(i);
            } else if (li.get(i) < max && li.get(i) > max2) {
                max2 = li.get(i);
            }
        }


    }

    public static int findKthLargestElement(int[] arr, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);
        for (int n : arr) {
            minHeap.add(n);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        return minHeap.peek();
    }


    private static void addPair(int x, int y) {
        pairs.add(new int[]{x ,y});
    }
}
