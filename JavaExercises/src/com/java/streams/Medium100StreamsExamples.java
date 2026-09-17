  package com.java.streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
//import com.fasterxml.jackson.databind.ObjectMapper  ;

  //https://medium.com/@bhangalekunal2631996/100-java-streams-interview-questions-with-solutions-and-outputs-2afb0713ceec
  // Dec 2025 - Jan 2026
  public class Medium100StreamsExamples {

      // https://medium.com/@bhangalekunal2631996/100-java-streams-interview-questions-with-solutions-and-outputs-2afb0713ceec
      public static void main(String... args) throws IOException {

          List<Integer> numbers = IntStream.range(1,6).boxed().toList();

          ConcurrentHashMap map;

          // 1. Find the Sum of All Elements in a List
          int sum = numbers.stream().mapToInt(Integer::intValue).sum();
          System.out.println("Find the Sum of All Elements in a List : " + sum);

          // 2. Find the Product of All Elements in a List
          int product = numbers.stream().reduce(1, (a, b) -> a * b);
          System.out.println("Find the Product of All Elements in a List : " + product);

          // 3. Find the Average of All Elements in a List
          double average = numbers.stream().mapToInt(Integer::intValue).average().getAsDouble();
          System.out.println("Find the Average of All Elements in a List : " + average);

          // 4.  . Find the Maximum Element in a List
          int max = numbers.stream().mapToInt(Integer::intValue).max().getAsInt();
          System.out.println("Find the Maximum Element in a List : " + max);

          // 5. Find the Minimum Element in a List
          int min = numbers.stream().mapToInt(Integer::intValue).min().getAsInt(); // To use the built‑in numeric min() without writing a comparator, you convert to a primitive stream (IntStream) using .mapToInt(Integer::intValue).
          System.out.println("Find the Minimum Element in a List : " + min);

          int min2 = numbers.stream().min(Comparator.naturalOrder()).get();
          System.out.println("Find the Minimum Element in a List : " + min2);

          // 6. Count the Number of Elements in a List
          int count = (int) numbers.stream().count();
          System.out.println("Count the Number of Elements in a List : " + count);

          // 7. Check if a List Contains a Specific Element
          boolean contains = numbers.stream().anyMatch(i -> i == 3);
          System.out.println("Check if a List Contains a Specific Element : " + contains);

          // 8. Filter Out Even Numbers from a List
          List<Integer> evens = numbers.stream().filter(i -> i % 2 == 0).collect(Collectors.toList());
          System.out.println("Filter Out Even Numbers from a List : " + evens);

          // 9. Filter Out Odd Numbers from a List
          List<Integer> odds = numbers.stream().filter(i -> i % 2 != 0).collect(Collectors.toList());
          System.out.println("Filter Out Odd Numbers from a List : " + odds);


          // 10. Convert a List of Strings to Uppercase
          List<String> words = List.of("hello", "world");
          List<String> toUppercase = words.stream().map(String::toUpperCase).toList();
          System.out.println("Convert a List of Strings to Uppercase : " + toUppercase);


          // 13. Find the Last Element in a List
          List<Integer> numbers1 = List.of(1, 2, 3, 4, 5);
          Integer lastEle = numbers1.stream().reduce((a, b) -> b).orElse(0);
          System.out.println("Find the Last Element in a List : " + lastEle);

          // 14. Check if All Elements in a List Satisfy a Condition
          List<Integer> allEvens = List.of(2, 4, 6, 8, 10);
          boolean areAllEvens = numbers1.stream().allMatch(e -> e % 2 == 0);
          System.out.println(" Check if All Elements in a List Satisfy a Condition : " + areAllEvens);
          areAllEvens = allEvens.stream().allMatch(e -> e % 2 == 0);
          System.out.println(" Check if All Elements in a List Satisfy a Condition : " + areAllEvens);

          // 15. Check if Any Element in a List Satisfies a Condition
          boolean anyMatch = numbers1.stream().anyMatch(n -> n % 2 == 0);
          System.out.println("Check if Any Element in a List Satisfies a Condition : " + anyMatch);

          // 16. Remove Duplicate Elements from a List
          List<Integer> numbers2 = List.of(1, 2, 2, 3, 4, 4, 5);
          Set<Integer> unique = numbers2.stream().collect(Collectors.toSet());
          System.out.println("Remove Duplicate Elements from a List : " + unique);
          List<Integer> unique1 = numbers2.stream().distinct().toList();
          System.out.println("Remove Duplicate Elements from a List : " + unique1);

          // 16.1 Find Duplicate Elements from a List
          List<Integer> duplicates = numbers2.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                          .entrySet().stream().filter(e -> e.getValue() > 1).map(Map.Entry::getKey).toList();
          System.out.println("Find Duplicate Elements from a List : " + duplicates);

          

          List<Integer> duplicates1 = numbers2.stream().filter(e -> Collections.frequency(numbers2, e) > 1).toList();
          System.out.println("Find Duplicate Elements from a List : " + duplicates1);


          // 20. Sort a List of Strings by Their Length
          List<String> words1 = new ArrayList<>(List.of("apple", "banana", "kiwi"));
          List<String> sortedWords = words1.stream().sorted(Comparator.comparingInt(String::length)).toList();
          System.out.println("Sort a List of Strings by Their Length : " + sortedWords);

          // 21. Find the Sum of Digits of a Number
          int number = 12345;
          int sum1 = String.valueOf(number).chars().map(c -> (int) c).sum(); // two mistakes - map(c -> (int) c) is redundant and sum() gives 255 as 1-5 ASCII values are 49-53, hence sum is 255
          System.out.println("Find the Sum of Digits of a Number : " + sum1);
          int sum2 = String.valueOf(number).chars().map(Character::getNumericValue).sum();
          System.out.println("Find the Sum of Digits of a Number : " + sum2);

          //You can use IntStream.range method for converting String into stream of characters
          Stream<Character> str = IntStream.range(0, String.valueOf(number).length()).mapToObj(i -> (char) i);

          // 22. Find the Factorial of a Number
          int num1 = 5;
          int fact = IntStream.rangeClosed(1, 5).reduce((a, b) -> a * b).getAsInt();
          System.out.println("Find the Factorial of a Number : " + fact);

          // 23. Find the Second-Largest Element in a List
          int secondLargest = numbers1.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst().orElse(-1);
          System.out.println("Find the Second-Largest Element in a List : " + secondLargest);

          // 24. Find the Second-Smallest Element in a List
          int secondSmallest = numbers1.stream().sorted().skip(1).findFirst().orElse(-1);
          System.out.println("Find the Second-Smallest Element in a List : " + secondSmallest);

          // 25. Find the Longest String in a List
          String longest = words1.stream().max(Comparator.comparing(String::length)).orElse("NONE");
          System.out.println("Find the Longest String in a List : " + longest);

          words1.addFirst("lichee");
          String longest2 = words1.stream().max(Comparator.comparing(String::length)).orElse("NONE");
          System.out.println("Find the Longest String in a List : " + longest2);

          // 26. Find the Shortest String in a List
          String shortest = words1.stream().min(Comparator.comparing(String::length)).orElse("NONE");
          System.out.println("Find the Shortest String in a List : " + shortest);

          // 27. Group a List of Strings by Their Length
          Map<Integer, List<String>> groupingByLength = words1.stream().collect(Collectors.groupingBy(e -> e.length()));
          System.out.println("Group a List of Strings by Their Length : " + groupingByLength);

          // 29. Partition a List of Integers into Even and Odd Numbers
          Map<Boolean, List<Integer>> partitioningByEvenOdd = numbers1.stream().collect(Collectors.partitioningBy(e -> e % 2 == 0));
          System.out.println("Partition a List of Integers into Even and Odd Numbers : " + partitioningByEvenOdd);

          Map<String, List<Integer>> groupingByEvenOdd = numbers1.stream().collect(Collectors.groupingBy(e -> {
              if (e % 2 == 0) return "even";
              else return "odd";
          }));
          System.out.println("Partition a List of Integers into Even and Odd Numbers : " + groupingByEvenOdd);

          // 30. Merge Two Lists into a Single List
          List<Integer> list1 = new ArrayList<>(List.of(1,2,3,4,5));
          List<Integer> list2 = new ArrayList<>(List.of(6,7,8,9,10));
          List<Integer> list = Stream.concat(list1.stream(), list2.stream()).toList();
          System.out.println("Merge Two Lists into a Single List : " + list);

          // 31. Find the Intersection of Two Lists
          List<Integer> list3 = new ArrayList<>(List.of(1,2,3,4));
          List<Integer> list4 = new ArrayList<>(List.of(3,4,5,6));
          List<Integer> intersection = list3.stream().filter(e -> list4.contains(e)).toList();
          System.out.println("Find the Intersection of Two Lists : " + intersection);

          Set<Integer> intersection1 = new HashSet<>(list3);
          intersection1.retainAll(list4);
          System.out.println(" intersection : " + intersection1);

          // 32. Find the Union of Two Lists
          List<Integer> union = Stream.concat(list1.stream(), list2.stream()).distinct().toList();
          System.out.println("Find the Union of Two Lists : " + union);

          // 33. Find the Difference Between Two Lists
          List<Integer> difference = list3.stream().filter(e -> !list4.contains(e)).toList();
          System.out.println("Find the Difference Between Two Lists : " + difference);

          // 34. Count the Occurrences of Each Element in a List
          List<String> words3 = List.of("apple", "banana", "apple", "orange");
          Map<String, Long> occurrences = words3.stream().collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));
          System.out.println("Count the Occurrences of Each Element in a List : " + occurrences);
          // Count the Occurrences of Each Element in a List : {orange=1, banana=1, apple=2} -- Without LinkedHashMap
          // Count the Occurrences of Each Element in a List : {apple=2, banana=1, orange=1} -- With LinkedHashMap

          // 35. Count the Occurrences of Each Character in a String
          String input = "hello";
          Map<Character, Long> charOccurrences = input.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
          System.out.println("Count the Occurrences of Each Character in a String : " + charOccurrences);

          // 36. Count the Occurrences of Each Word in a String
          String input2 = "hello world hello";
          Map<String, Long> wordOcc = Arrays.stream(input2.split(" ")).collect(Collectors.groupingBy(s -> s, LinkedHashMap::new, Collectors.counting()));
          System.out.println("Count the Occurrences of Each Word in a String : " + wordOcc);

          // 37. Count the Occurrences of Each Vowel in a String
          String input3 = "hello world";
          Map<Character, Long> vowelOcc = input3.chars().mapToObj(c -> (char) c)
                  .filter(c -> "aeiou".contains(String.valueOf(c)))
                  .collect(Collectors.groupingBy(c -> c, Collectors.counting()));
          System.out.println("Count the Occurrences of Each Vowel in a String : " + vowelOcc);

          // 38. Count the Occurrences of Each Digit in a String
          String input4 = "hello 123 world 456";
          Map<Character, Long> digitOcc = input4.chars().mapToObj(c -> (char) c)
                  .filter(c -> "0123456789".contains(String.valueOf(c)))
                  .collect(Collectors.groupingBy(c -> c, Collectors.counting()));
          System.out.println("Count the Occurrences of Each Digit in a String : " + digitOcc);

          // 39. Reverse a List Using Streams
          List<Integer> reversedList = list.stream().collect(
                  Collectors.collectingAndThen(
                          Collectors.toList(),
                          list5 -> {
                              Collections.reverse(list5);
                              return list5;
                          }
                  ));

          list.stream().collect(
                  Collectors.collectingAndThen(
                          Collectors.toList(),
                          list6 -> {
                              Collections.reverse(list6);
                              return list6;
                          }
                  ));

          System.out.println("Reverse a List Using Streams : " + reversedList);

          // 40. Reverse a String Using Streams
          String reversedString = input.chars()
                  //.mapToObj(c -> (char) c)
                  //.mapToObj(c -> String.valueOf(c))
                  .mapToObj(c -> String.valueOf((char) c)) // int codepoint need to cast to char first
                  .collect(
                          Collectors.collectingAndThen(
                                  Collectors.toList(),
                                  list5 -> {
                                      Collections.reverse(list5);
                                      return String.join("", list5);
                                  }
                          )).toString();
          System.out.println("Reverse a String Using Streams : " + reversedString);

          String reversedString2 = input.chars()
                  .mapToObj(c -> String.valueOf((char) c))
                  .reduce("", (a, b) -> b + a);
          System.out.println("Reverse a String Using Streams : " + reversedString);

          String reversed1 = input.chars().mapToObj(c -> String.valueOf((char) c)).reduce("", (a, b) -> b + a);
          System.out.println("reversed1 : " + reversed1);

          // 41. Find the Most Frequent Element in a List
          String mostFrequent = words3.stream()
                  .collect(Collectors.groupingBy(e -> e, Collectors.counting()))
                  .entrySet().stream()
                  .max(Map.Entry.comparingByValue()).get().getKey();
          System.out.println("Find the Most Frequent Element in a List 0 : " + mostFrequent);

          String mostFrequent1 = words3.stream().collect(Collectors.collectingAndThen(
                  Collectors.groupingBy(e -> e, Collectors.counting()),
                  map1 -> Collections.max(map1.entrySet(), Map.Entry.comparingByValue()).getKey()
          ));
          System.out.println("Find the Most Frequent Element in a List 1 : " + mostFrequent1);

          String mostFrequent2 = Collections.max(
                  words3,
                  Comparator.comparing(w -> Collections.frequency(words3, w))
          ); // Time Complexity -- O(n^2)
          System.out.println("Find the Most Frequent Element in a List 2 : " + mostFrequent2);

          String mostFrequent3 = Collections.max(
                  words3.stream().collect(Collectors.groupingBy(e -> e, Collectors.counting())).entrySet(),
                          Map.Entry.comparingByValue()
                  ).getKey(); // Time Complexity -- O(2n) ~ O(n)

          System.out.println("Find the Most Frequent Element in a List 3 : " + mostFrequent3);


          // 42. Find the Least Frequent Element in a List
          String leastFrequent = words3.stream()
                  .collect(Collectors.groupingBy(e -> e, LinkedHashMap::new, Collectors.counting()))
                  .entrySet().stream().min(Map.Entry.comparingByValue()).get().getKey();
          System.out.println("Find the Least Frequent Element in a List 0: " + leastFrequent);

          String leastFrequent1 = words3.stream().collect(Collectors.collectingAndThen(
                  Collectors.groupingBy(e -> e, LinkedHashMap::new, Collectors.counting()),
                  map1 -> Collections.min(map1.entrySet(), Map.Entry.comparingByValue()).getKey()
          ));
          System.out.println("Find the Least Frequent Element in a List 1: " + leastFrequent1);

          String leastFrequent2 = Collections.min(words3, Comparator.comparing(w -> Collections.frequency(words3, w)));
          System.out.println("Find the Least Frequent Element in a List 2: " + leastFrequent2);

          String leastFrequent3 = Collections.min(
                  words3.stream().collect(Collectors.groupingBy(e -> e, LinkedHashMap::new, Collectors.counting())).entrySet(),
                  Map.Entry.comparingByValue()
          ).getKey();
          System.out.println("Find the Least Frequent Element in a List 3: " + leastFrequent3);


          // 43. Find the First Non-Repeated Character in a String
          Character firstNonrepeatedChar = input.chars()
                  .mapToObj(c -> (char) c)
                  .collect(Collectors.groupingBy(c -> c, LinkedHashMap::new, Collectors.counting()))
                  .entrySet().stream()
                  .filter(entry -> entry.getValue() == 1).findFirst().get().getKey();
          System.out.println("Find the First Non-Repeated Character in a String : " + firstNonrepeatedChar);


          // 44. Find the First Repeated Character in a String
          Character firstRepeatedChar = input.chars().mapToObj(c -> (char) c)
                  .collect(Collectors.groupingBy(c -> c, LinkedHashMap::new, Collectors.counting()))
                  .entrySet().stream()
                  .filter(entry -> entry.getValue() > 1)
                  .map(Map.Entry::getKey).findFirst().get();
          System.out.println("Find the First Repeated Character in a String : " + firstRepeatedChar);

          // Non-stream solution
          Map<Character, Integer> map3 = new LinkedHashMap<>();
          for (char c : input.toCharArray()) {
              map3.merge(c, 1, Integer::sum);
          }

          // 45. Check if a String is a Palindrome
          String palin = "level"; int l = palin.length();
          boolean isPalindrome = true;
          for (int i = 0; i < (palin.length()/2); i++) {
              if (palin.charAt(i) != palin.charAt(l-i-1)) {
                  isPalindrome = false;
                  break;
              }
          }
          System.out.println("Check if a String is a Palindrome : " + isPalindrome);

          isPalindrome = IntStream.range(0, l/2).allMatch(i -> palin.charAt(i) == palin.charAt(l-i-1));
          System.out.println("Check if a String is a Palindrome : " + isPalindrome);

          // 46. Find All Anagrams of a String from a List
          List<String> words2 = List.of("listen", "silent", "enlist", "google", "inlets");
          String target = "silent";

          List<String> anagrams = words2.stream()
                  .filter(w -> Arrays.equals(w.chars().sorted().toArray(), target.chars().sorted().toArray()))
                  .toList();
          System.out.println("Find All Anagrams of a String from a List : " + anagrams);

          String sortedTarget = target.chars().sorted().collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();

          List<String> anagrams3 = words2.stream()
                  .filter(w -> w.chars()
                          .sorted()
                          .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                          .toString().equals(sortedTarget)).toList();
          System.out.println("Find All Anagrams of a String from a List : " + anagrams3);


          List<String> result = words2.stream().filter(w -> Arrays.equals(w.chars().sorted().toArray(), target.chars().sorted().toArray())).toList();
          System.out.println("all anagrams : " + result);

          // 47. Generate the Fibonacci Sequence Using Streams
          Stream.iterate(new int[]{0, 1}, fib -> new int[]{fib[1], fib[0] + fib[1]})
                  .limit(10)
                  .map(fib -> fib[0])
                  .forEach(e -> System.out.print(e + " "));
          System.out.println("Generate the Fibonacci Sequence Using Streams : ");

          // 48. Generate a List of Random Numbers Using Streams
          List<Integer> random1 = Stream.generate(() -> new Random().nextInt(100)).limit(10).toList();
          System.out.println("Generate a List of Random Numbers Using Streams : " + random1);
          List<Integer> random2 = Stream.generate(Math::random)
                  .limit(10)
                  .map(e -> e * 100).map(e -> e.intValue()).toList();
          System.out.println("Generate a List of Random Numbers Using Streams : " + random2);
          List<Double> random3 = Stream.generate(Math::random).limit(10).toList();
          System.out.println("Generate a List of Random Numbers Using Streams : " + random3);

          //49. Flatten a List of Lists into a Single List
          List<List<Integer>> listOfLists = List.of(
                  List.of(1, 2, 3),
                  List.of(4, 5, 6),
                  List.of(7, 8, 9)
          );
          List<Integer> flattened = listOfLists.stream().flatMap(List::stream).toList();
          System.out.println("Flatten a List of Lists into a Single List : " + flattened);

          // 50. Find the Sum of All Even Numbers in a Nested List
          Integer sumOfEven = listOfLists.stream()
                  .flatMap(List::stream)
                  .filter(i -> i % 2 == 0)
                  .reduce((a, b) -> a + b).get();
          System.out.println("Find the Sum of All Even Numbers in a Nested List : " + sumOfEven);

          int sumOfEven1 = listOfLists.stream()
                  .flatMap(List::stream)
                  .filter(i -> i % 2 == 0)
                  .mapToInt(Integer::intValue).sum(); // primitive specialization (IntStream), so no boxing/unboxing overhead
          System.out.println("Find the Sum of All Even Numbers in a Nested List : " + sumOfEven1);

          // 52. Find the Longest Palindrome in a List of Strings
          List<String> words4 = List.of("madam", "racecar", "apple", "banana", "level");
          String longestPalindrome = words4.stream()
                          .filter(w -> w.equals(new StringBuilder(w).reverse().toString()))
                          .max(Comparator.comparingInt(String::length))
                  .orElse(null);
          System.out.println("Find the Longest Palindrome in a List of Strings : " + longestPalindrome);

          // MORE performance oriented
          String longestPalindrome1 = words4.stream()
                  .filter(Medium100StreamsExamples::isPalindrome1)
                  .max(Comparator.comparingInt(String::length)).get();
          System.out.println("Find the Longest Palindrome 1 in a List of Strings : " + longestPalindrome1);

          // 53. Find the Shortest Palindrome in a List of Strings
          String shortestPalindrome = words4.stream()
                  .filter(w -> w.equals(new StringBuilder(w).reverse().toString())).min(Comparator.comparingInt(String::length)).get();
          System.out.println("Find the Shortest Palindrome in a List of Strings : " + shortestPalindrome);

          // 54. Find the Longest Word in a String
          String input5 = "hello world this is a test";
          String longestWord = Arrays.stream(input5.split(" ")).max(Comparator.comparingInt(String::length)).get();
          System.out.println("Find the Longest Word in a String : " + longestWord);

          // 55. Find the Shortest Word in a String
          String shortestWord = Arrays.stream(input5.split(" ")).min(Comparator.comparingInt(String::length)).get();
          System.out.println("Find the Shortest Word in a String : " + shortestWord);

          // 58. Find the Number of Characters in a File
          /*Path path = Paths.get("sample.txt");
          long charCount = Files.lines(path).flatMapToInt(String::chars).count();
          System.out.println("Find the Number of Characters in a File : " + charCount);*/

          // 60. Find the Number of Unique Words in a File
          /* Files.lines(path).flatMap(line -> Arrays.stream(line.split(" "))).distinct().count();
          System.out.println("Find the Number of Unique Words in a File : ");*/

          // Real-World Use Case Questions (61–70)
          // 61. Process a CSV File and Calculate Aggregate Statistics
          Path path = Paths.get("D:\\workspace\\Java\\JavaExercises\\src\\com\\java\\streams\\data.csv");
          Map<String, Double> map1 = Files.lines(path)
                  .skip(1)
                  .map(line -> line.split(","))
                  .collect(Collectors.groupingBy(
                          fields -> fields[1],
                          Collectors.averagingDouble(fields -> Double.parseDouble(fields[2])))
                  );
          System.out.println("Process a CSV File and Calculate Aggregate Statistics : " + map1);

          Files.lines(path).skip(1)
                  .map(line -> line.split(","))
                  .collect(Collectors.groupingBy(
                          fields -> fields[1],
                          Collectors.averagingDouble(fields -> Double.parseDouble(fields[2]))
                          )
                  );

          // 62. Filter and Transform Data Fetched from a Database
          List<Employee> employees = new ArrayList<>(Arrays.asList(
                  new Employee("Alice", 29, "HR", 70000),
                  new Employee("Bob", 31, "IT", 50000),
                  new Employee("Charlie", 26, "HR", 60000)
          ));
          List<Employee> emps = Arrays.asList(
                  new Employee("Krishna", 36, "Accounts", 65000),
                  new Employee("Vikram", 39, "IT", 75000),
                  new Employee("Jaya", 24, "HR", 45000)
          );
          employees.addAll(emps);

          // names by department
          Map<String, List<String>> map30 = employees.stream().collect(
                  Collectors.groupingBy(
                          Employee::getDepartment,
                          Collectors.mapping(Employee::getName, Collectors.toList())
                          /*Collectors.collectingAndThen(
                                  Collectors.toList(),
                                  list6 -> list6.stream().map(Employee::getName).toList()
                          )*/
                  ));
          Hashtable table;
          System.out.println("names by department : " + map30);

          Map<String, Double> map4 = employees.stream().collect(Collectors.groupingBy(
                  Employee::getDepartment,
                  Collectors.summingDouble(Employee::getSalary)
          ));
          System.out.println("total salaries by departmet : " + map4);

          // 63. Parse and Validate JSON Payloads
          String json = "[{\"name\":\"Alice\",\"age\":25},{\"name\":\"Bob\",\"age\":30}]";
          //List<Person> persons = new ObjectMapper().readValue(json, new TypeReference<List<Person>>);

          // 64. Combine Multiple Asynchronous Tasks
          CompletableFuture<List<Integer>> future1 = CompletableFuture.supplyAsync(() -> List.of(1, 2, 3));
          CompletableFuture<List<Integer>> future2 = CompletableFuture.supplyAsync(() -> List.of(4, 5, 6));
          List<Integer> combined = Stream.of(future1, future2).map(CompletableFuture::join).flatMap(List::stream).toList();
          System.out.println("Combine Multiple Asynchronous Tasks : " + combined);

          // 65. Process Large Datasets in Parallel
          List<Integer> numbers3 = IntStream.rangeClosed(1, 1000000).boxed().collect(Collectors.toList());
          long sum3 = numbers3.parallelStream().mapToInt(Integer::intValue).sum();
          System.out.println("Process Large Datasets in Parallel : " + sum3);

          long longsum = IntStream.rangeClosed(1, 1000000).asLongStream().parallel().sum();
          System.out.println("longsum : " + longsum);

          // 66. Handle Exceptions in Streams
          List<String> numbers4 = List.of("1", "2", "three", "4");
          List<Integer> res = numbers4.stream()
                  .flatMap(s -> {
                      try {
                          return Stream.of(Integer.parseInt(s));
                      } catch (Exception e) {
                          return Stream.empty();
                      }
                  }).collect(Collectors.toList());

          System.out.println("Handle Exceptions in Streams : " + res);

          // 67. Use Custom Collectors to Calculate Statistics
          DoubleSummaryStatistics stats1 = numbers2.stream().collect(Collectors.summarizingDouble(Integer::intValue));
          System.out.println("Use Custom Collectors to Calculate Statistics : " + stats1);

          // 68. Group Employees by Department and Calculate Average Salary
          Map<String, Double> avgSalaryByDepartment = employees.stream().collect(
                  Collectors.groupingBy(
                          Employee::getDepartment,
                          Collectors.averagingDouble(Employee::getSalary)
                  )
          );
          System.out.println("Group Employees by Department and Calculate Average Salary : " + avgSalaryByDepartment);

          // 69. Find the Top N Highest-Paid Employees
          // Here N = 3
          Employee thirdHighestSalary = employees.stream()
                  .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                  .skip(2)
                  .findFirst()
                  .orElse(null);
          System.out.println("Find the Top N Highest-Paid Employees : " + thirdHighestSalary);

          // Second highest salary in each department
          Map<String, Double> secondHighestSalaryInDepartment = employees.stream()
                  .collect(Collectors.groupingBy(
                          Employee::getDepartment,
                          Collectors.collectingAndThen(
                                  Collectors.mapping(
                                          Employee::getSalary,
                                          Collectors.toCollection(() -> new TreeSet<Double>(Comparator.reverseOrder()))
                                  ),
                                  set -> set.stream().skip(1).findFirst().orElse(-1d) // returns -1 if not present
                          )
                  ));
          System.out.println("Second highest salary in each department : " + secondHighestSalaryInDepartment);

          Map<String, Double> secondHighestByDept = employees.stream()
                  .collect(
                          Collectors.groupingBy(
                                  Employee::getDepartment,
                                  Collectors.collectingAndThen(
                                          Collectors.mapping(
                                                  Employee::getSalary,
                                                  Collectors.toCollection(() -> new TreeSet<Double>(Comparator.reverseOrder()))
                                          ),
                                          set -> set.stream().skip(1).findFirst().orElse(null)
                                  )
                          ));
          System.out.println(secondHighestByDept);

          // 70. Find the Top N Most Frequent Words in a Text File
          Path path1 = Paths.get("D:\\workspace\\Java\\JavaExercises\\src\\com\\java\\streams\\sample.txt");

          List<String> top3MostFrequentWords = Files.lines(path1)
                  .flatMap(line -> Arrays.stream(line.split(" ")))
                  .collect(Collectors.groupingBy(s -> s, Collectors.counting()))
                  .entrySet().stream()
                  .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                  .limit(3)
                  .map(Map.Entry::getKey)
                  .toList();
          System.out.println("Find the Top N Most Frequent Words in a Text File : " + top3MostFrequentWords);

          List<String> top3MostFrequentWords1 = Files.lines(path1)
                  .flatMap(line -> Arrays.stream(line.split(" ")))
                  .collect(Collectors.groupingBy(s -> s, Collectors.counting()))
                  .entrySet().stream()
                  //.sorted(Map.Entry.comparingByValue().reversed())
                  .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                  //.sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())) --> This also works!
                  .limit(3)
                  .map(Map.Entry::getKey)
                  .toList();
          System.out.println("Find the Top N Most Frequent Words in a Text File : " + top3MostFrequentWords1);


          // String Manipulation Questions (71–80)
          // 71. Remove All Vowels from a String
          String input6 = "hello world";

          String vowelsRemoved = input6.chars()
                  .mapToObj(c -> String.valueOf((char) c))
                  .filter(c -> !"aeiou".contains(c))
                  .collect(Collectors.joining());
          System.out.println("Remove All Vowels from a String : " + vowelsRemoved);

          // 72. Remove All Consonants from a String
          String consonantsRemoved = input6.chars()
                  .filter(c -> "aeiou".contains(String.valueOf((char) c)))
                  .mapToObj(c -> String.valueOf((char) c))
                  .collect(Collectors.joining());
          System.out.println("Remove All Consonants from a String : " + consonantsRemoved);

          // 73. Remove All Digits from a String
          String input7 = "hello 123 world";
          String digitsRemoved = input7.chars()
                  .mapToObj(c -> String.valueOf((char) c))
                  .filter(c -> !"0123456789".contains(c))
                  .collect(Collectors.joining());
          System.out.println("Remove All Digits from a String : " + digitsRemoved);

          // 74. Remove All Special Characters from a String
          String input8 = "hello@world!";
          String specialCharsRemoved = input8.chars()
                  .filter(c -> (Character.isLetterOrDigit(c) || Character.isWhitespace(c)))
                  .mapToObj(c -> String.valueOf((char) c))
                  .collect(Collectors.joining());
          System.out.println("Remove All Special Characters from a String : " + specialCharsRemoved);
          
          // 75. Extract All Digits from a String and Sum Them
          String input9 = "hello 123 world 456";
          int digitsRemoved1 = input9.chars()
                  .filter(c -> Character.isDigit(c))
                  //.mapToObj(c -> String.valueOf((char) c))
                  .map(c -> Character.getNumericValue(c))
                  .sum();
          System.out.println("Extract All Digits from a String and Sum Them : " + digitsRemoved1);

          // 76. Extract All Words from a String and Count Their Occurrences
          String input10 = "hello world hello";
          Map<String, Long> map5 = Arrays.stream(input10.split(" "))
                  .collect(Collectors.groupingBy(s -> s, Collectors.counting()));
          System.out.println("Extract All Words from a String and Count Their Occurrences : " + map5);

          // 77. Extract All Unique Words from a String
          List<String> uniqueWords = Arrays.stream(input10.split(" ")).distinct().toList();
          System.out.println("Extract All Unique Words from a String : " + uniqueWords);

          List<String> nonRepeatedWords = Arrays.stream(input10.split(" "))
                  .collect(Collectors.groupingBy(s -> s, Collectors.counting()))
                  .entrySet().stream()
                  .filter(entry -> entry.getValue() == 1)
                  .map(Map.Entry::getKey)
                  .toList();
          System.out.println("Extract All Non Repeated Words from a String : " + nonRepeatedWords);

          // 78. Extract All Palindromic Words from a String
          String input11 = "madam racecar apple banana level";
          List<String> allPalindromes = Arrays.stream(input11.split(" ")).filter(Medium100StreamsExamples::isPalindrome1).toList();
          System.out.println("Extract All Palindromic Words from a String : " + allPalindromes);

          // 79. Extract All Words Starting with a Specific Letter
          List<String> startsWith = Arrays.stream(input11.split(" ")).filter(s -> s.startsWith("a")).toList();
          System.out.println("Extract All Words Starting with a Specific Letter : " + startsWith);

          // 80. Extract All Words Ending with a Specific Letter
          List<String> endsWith = Arrays.stream(input11.split(" ")).filter(c -> c.endsWith("o")).toList();
          System.out.println("Extract All Words Ending with a Specific Letter : " + endsWith);


          Map<String, Integer> mapp = words4.stream().collect(
                  Collectors.toMap(
                          Function.identity(),
                          String::length,
                          (e1, e2) -> e1 + e2
                  ));
          
          
          System.out.println("****************************************************************************************************");
          class Student {
              public int getId() {
                  return id;
              }

              public double getPercentage() {
                  return percentage;
              }

              public String getGrade() {
                  return grade;
              }

              int id;
              double percentage;
              String grade;

              @Override
              public String toString() {
                  return "Student{" +
                          "id=" + id +
                          ", percentage=" + percentage +
                          ", grade='" + grade + '\'' +
                          '}';
              }

              public Student(int id, double percentage, String grade) {
                  this.id = id;
                  this.percentage = percentage;
                  this.grade = grade;
              }
          }

          Student s1 = new Student(1, 87.91d, "");
          Student s2 = new Student(2, 74d, "");
          Student s3 = new Student(3, 59d, "");
          Student s4 = new Student(4, 38d, "");
          List<Student> students = new ArrayList<>(Arrays.asList(s1, s2, s3, s4));

          Map<String, Long> stuMap = students.stream().collect(Collectors.groupingBy(ele -> {
              if (ele.percentage >= 75) {
                  ele.grade = "A";
                  //return "A";
              } else if (ele.percentage >= 60 && ele.percentage < 75) {
                  ele.grade = "B";
                  //return "B";
              } else if (ele.percentage >= 40 && ele.percentage < 60) {
                  ele.grade = "C";
                  //return "C";
              } else {
                  ele.grade = "D";
                  //return "D";
              }
              return ele.grade;
          }, Collectors.counting()));

          Map<String, Long> stuMap1 = students.stream().collect(Collectors.groupingBy(
                  ele -> { return getStudentGrade(ele.percentage); },
                  Collectors.counting()
          ));
          System.out.println("Group students according to their percentages : " + stuMap1);
      }

      private static String getStudentGrade(double percentage) {
          String grade;
          if (percentage >= 75) {
              grade = "A";
          } else if (percentage >= 60 && percentage < 75) {
              grade = "B";
          } else if (percentage >= 40 && percentage < 60) {
              grade = "C";
          } else {
              grade = "D";
          }

          return grade;
      }



      private static boolean isPrime(int i) {
          if (i < 0) return false;
          if (i == 0 || i == 1) return true;

          int i0 = 2;
          while (i0 <= (i/2)) {
              if (i % i0 == 0) return false;
              i0++;
          }
          return true;
      }

      private static boolean isPalindrome(String ss2) {
          return ss2.equalsIgnoreCase(new StringBuilder(ss2).reverse().toString());
      }

      private static boolean isPalindrome1 (String s) {
          int l = s.length();
          for (int i = 0; i < l; i++) {
              if (s.charAt(i) != s.charAt(l-i-1)) return false;
          }
          return true;
      }
  }

  class Employee {
      public String getName() {
          return name;
      }

      public int getAge() {
          return age;
      }

      public String getDepartment() {
          return department;
      }

      public double getSalary() {
          return salary;
      }

      String name;
      int age;
      String department;
      double salary;

      Employee(String name, int age, String department, double salary) {
          this.name = name;
          this.age = age;
          this.department = department;
          this.salary = salary;
      }

      @Override
      public String toString() {
          return name + "[" + age + ", " + department + ", " + salary + "]";
      }
  }
