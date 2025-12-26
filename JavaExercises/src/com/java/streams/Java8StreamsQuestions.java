package com.java.streams;



import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.function.Function;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

//
// https://medium.com/@shubhamkchoudhary07/50-java-streams-most-important-problems-solutions-ec1225c149c2
public class Java8StreamsQuestions {

    public static void main(String... args) throws IOException {

//        1. Imagine you have a list of names. Now you want to:
//
//        Filter out names starting with “A”
//        Convert the rest to uppercase
//        Sort them
//        Print them

        List<String> names = List.of("John", "Abraham", "Papaya", "Zenaya", "Mahadev", "Krishnaj", "Kej", "Yohannes", "Peach", "Ganesh", "Ra");
        names.stream()
                .filter(s -> s.startsWith("A"))
                .map(s -> s.toUpperCase())
                .sorted()
                .forEach(System.out::println);

        // 1. Convert Strings to Uppercase
        List<String> filtered = names.stream().map(String::toUpperCase).toList();
        System.out.println("Convert Strings to Uppercase : " + filtered);

        // 2. Filter Even Numbers from a List
        List<Integer> ints = List.of(-2, 1,2,3,4,5,6,7,8,9,10);
        List<Integer> ints1 = ints.stream().filter(i -> i % 2 == 0).toList(); //.collect(Collectors.toList());
        System.out.println("Filter Even Numbers from a List : " + ints1);

        // 3. Count Strings with Length Greater Than 3
        List<String> names1 = names.stream().filter(s -> s.length() > 3).toList();
        System.out.println("Count Strings with Length Greater Than 3 : " + names1);

        // 4. Sort a List of Integers
        List<Integer> ints3 = ints.stream().sorted(Comparator.reverseOrder()).toList();
        System.out.println("Sort a List of Integers : " + ints3);

        // 5. Remove Duplicates from a List
        String[] fruitsArr = {"apple", "jackfruit", "mango", "grapes", "", "guava", "cashew", "melon", "grapes", "jackfruit", "mango"};
        List<String> noDuplicateList = Arrays.stream(fruitsArr).distinct().toList();
        System.out.println("Remove Duplicates from a List : " + noDuplicateList);

        // 6. Convert List of Strings to Their Lengths
        List<Integer> strLens = Arrays.stream(fruitsArr).map(String::length).toList();
        System.out.println("Convert List of Strings to Their Lengths : " + strLens);

        // 7. Join Strings with a Comma
        String strJoined = Arrays.stream(fruitsArr).collect(Collectors.joining(","));
        System.out.println("Join Strings with a Comma : " + strJoined);

        // 8. Find the Maximum Value in a List
        int max = ints.stream().max(Comparator.naturalOrder()).get();
        int max1 = ints.stream().max(Integer::compare).get();
        System.out.println("Find the Maximum Value in a List : " + max);
        System.out.println("Find the Maximum Value in a List : " + max1);

        // 9. Find the Minimum Value in a List
        int min = ints.stream().min(Comparator.comparingInt(i -> i)).get();
        System.out.println("Find the Minimum Value in a List : " + min);
        int min1 = ints.stream().min(Comparator.naturalOrder()).get();
        System.out.println("Find the Minimum Value in a List : " + min1);
        int min2 = ints.stream().min(Integer::compare).get();
        System.out.println("Find the Minimum Value in a List : " + min2);
        int min3 = ints.stream().reduce(Integer.MAX_VALUE, (a, b) -> a < b ? a : b);
        System.out.println("Find the Minimum Value in a List : " + min3);

        // 10. Sum All Elements in a List
        int sum = ints.stream().reduce(0, (a, b) -> a + b);
        System.out.println("Sum All Elements in a List : " + sum);
        int sum1 = ints.stream().collect(Collectors.summingInt(i -> i));
        System.out.println("Sum All Elements in a List : " + sum1);
        int sum2 = ints.stream().mapToInt(Integer::intValue).sum();
        System.out.println("Sum All Elements in a List : " + sum2);


        // 11. Double Numbers Divisible by 4
        List<Integer> doubled = ints.stream().map(i -> (i % 4 == 0) ? i * 2 : i).toList();
        System.out.println("Double Numbers Divisible by 4 : " + doubled);
        List<Integer> doubled1 = ints.stream().filter(i -> (i % 4 == 0)).map(i -> i * 2).toList();
        System.out.println("Double Numbers Divisible by 4 : " + doubled1);

        // 12. Triple Even Numbers
        List<Integer> tripled = ints.stream().map(i -> (i % 2 == 0) ? i * 3 : i).toList();
        System.out.println("Triple Even Numbers : " + tripled);

        // 13. Quadruple Numbers Divisible by 3
        List<Integer> quadrupled = ints.stream().map(i -> i % 3 == 0 ? i * 4 : i).toList();
        System.out.println("Quadruple Numbers Divisible by 3 : " + quadrupled);

        // 14. Multiply by 5 If Divisible by 4
        List<Integer> multiplyBy5 = ints.stream().map(i -> i % 4 == 0 ? i * 5 : i).toList();
        System.out.println("Multiply by 5 If Divisible by 4 : " + multiplyBy5);

        // 15. Keep Even Numbers Unchanged
        List<Integer> keepEven = ints.stream().filter(i -> i % 2 == 0).toList();
        System.out.println("Keep Even Numbers Unchanged : " + keepEven);

        // 16. Double Numbers Divisible by 3
        List<Integer> doubleDivisibleBy3 = ints.stream().map(i -> i % 3 == 0 ? i * 2 : i).toList();
        System.out.println("Double Numbers Divisible by 3 : " + doubleDivisibleBy3);

        // 17. Triple Numbers Divisible by 4
        List<Integer> tripleDivisibleBy4 = ints.stream().map(i -> i % 4 == 0 ? i * 3 : i).toList();
        System.out.println("Triple Numbers Divisible by 4 : " + tripleDivisibleBy4);

        // 18. Quadruple Even Numbers
        List<Integer> quadrupleEven = ints.stream().map(i -> i % 2 == 0 ? i * 4 : i).toList();
        System.out.println("Quadruple Even Numbers : " + quadrupleEven);

        // 19. Multiply Numbers Divisible by 3 by 5
        List<Integer> multiplyBy5DivisibleBy3 = ints.stream().map(i -> i % 3 == 0 ? i * 5 : i).toList();
        System.out.println("Multiply Numbers Divisible by 3 by 5 : " + multiplyBy5DivisibleBy3);

        // 20. Keep Numbers Divisible by 4 Unchanged

        // 21. Find Distinct Even Numbers

        // 22. Count Numbers Greater Than 10

        // 23. Square of All Numbers

        // 24. Sum of Even Numbers

        // 25. Product of All Elements

        // 26. Find Maximum Number

        // 27. Find Minimum Number

        // 28. Find First Even Number

        // 29. Skip First 3 Numbers

        // 30. Limit to First 3 Numbers

        // 31. Find Numbers Ending with 5

        // 32. Convert List of Strings to Uppercase

        // 33. Join Strings with Comma


        // 34. Filter Strings Starting with ‘A’


        // 35. Sort Strings Alphabetically


        // 36. Sort Strings in Reverse Order


        // 37. Count Empty Strings


        // 38. Remove Empty Strings


        // 39. Group Strings by Length
        Map<Integer, List<String>> map = Arrays.stream(fruitsArr).distinct().collect(Collectors.groupingBy(String::length));
        System.out.println("Group Strings by Length : " + map);

        // 40. Find Duplicate Elements
        Set<String> seen = new HashSet<>();
        List<String> duplicates = Arrays.stream(fruitsArr).filter(s -> !seen.add(s)).toList();
        System.out.println("Find Duplicate Elements " + duplicates);

        List<String> fruitList = Arrays.asList(fruitsArr);
        List<String> duplicates1 = Arrays.stream(fruitsArr).filter(s -> Collections.frequency(fruitList, s) > 1).distinct().toList();
        System.out.println("Find Duplicate Elements " + duplicates1);

        List<String> duplicates2 = Arrays.stream(fruitsArr)
                .collect(Collectors.groupingBy(s -> s, Collectors.counting()))
                .entrySet().stream()
                .filter(e -> e.getValue() > 1)
                .map(Map.Entry::getKey)
                .toList();
        System.out.println("Find Duplicate Elements " + duplicates2);

        // 41. Partition Numbers into Even and Odd
        Map<Boolean, List<Integer>> map1 = ints.stream().collect(Collectors.partitioningBy(i -> i % 2 == 0));
        System.out.println("Partition Numbers into Even and Odd : " + map1);
        Map<String, List<Integer>> map2 = ints.stream().collect(Collectors.groupingBy(i -> i % 2 == 0 ? "even" : "odd"));
        System.out.println("Partition Numbers into Even and Odd : " + map2);

        // 42. Get Summary Statistics
        IntSummaryStatistics stats = ints.stream().mapToInt(Integer::intValue).summaryStatistics();
        System.out.println("Get Summary Statistics : " + stats.toString());

        // 43. Check If Any Number is Negative
        boolean anyNegative = ints.stream().anyMatch(i -> i < 0);
        System.out.println("Check If Any Number is Negative : " + anyNegative);

        // 44. Check If All Numbers Are Positive
        boolean allPositive = ints.stream().allMatch(i -> i % 2 == 0);
        System.out.println("Check If All Numbers Are Positive : " + allPositive);

        // 45. Check If No Number is Zero
        boolean noZeros = ints.stream().allMatch(i -> i != 0);
        System.out.println("Check If No Number is Zero : " + noZeros);

        // 46. Convert List to Set
        Set<String> toSet = fruitList.stream().collect(Collectors.toSet());
        System.out.println("Convert List to Set : " + toSet);


        // 47. Flatten List of Lists
        List<List<String>> list = Arrays.asList(Arrays.asList("a", "b"), Arrays.asList("c", "d"));

        List<String> flattnedList = list.stream().flatMap(Collection::stream).toList();
        System.out.println("Flatten List of Lists : " + flattnedList);


        // 48. Remove Null Values from List


        // 49. Sort List of Integers in Descending Order


        // 50. Convert Integer List to String List




    }
}
