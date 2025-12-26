  package com.java.streams;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamsExamples {

    public static void main(String... args) {
        System.out.println("My class");

        // https://www.w3resource.com/java-exercises/stream/

        System.out.println("****** https://www.w3resource.com/java-exercises/stream/ ******");
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

        // https://github.com/sathishmadem123/java-streams-practice/tree/main/src/com/streams

        // Problem 11: Sort employees by salary
        List<Employee> employees = new ArrayList<>(Arrays.asList(
                new Employee("Alice", 29, "HR", 70000),
                new Employee("Bob", 31, "IT", 50000),
                new Employee("Charlie", 26, "HR", 60000)
        ));

        employees.stream().sorted(Comparator.comparingDouble(e -> e.salary)).toList();
        List<Employee> list1 = employees.stream().sorted(Comparator.comparingDouble((Employee e) -> e.salary)).toList();
        System.out.println("Sort employees by salary : " + list1);


        // Problem 13: Group employees by their department.
        Map<String, List<Employee>> group = employees.stream().collect(Collectors.groupingBy(e -> e.department));
        System.out.println("Group employees by their department : " + group);

        // Problem 13.1: Group employee count by their department.
        Map<String, Long> group1 = employees.stream().collect(Collectors.groupingBy(e -> e.department, Collectors.counting()));
        System.out.println("Group employee count by their department : " + group1);

        //  Problem 13.2: Compute sum of salaries by department
        Map<String, Double> map5 = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.summingDouble(Employee::getSalary)));
        System.out.println("Compute sum of salaries by department : " + map5);

        //  Problem 13.3: Compute average salaries by department
        Map<String, Double> map6 = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
        System.out.println("Compute average salaries by department : " + map6);

        // Problem 14: Divide a list of integers into even and odd numbers
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Map<Boolean, List<Integer>> group2 = numbers.stream().collect(Collectors.groupingBy(i -> i % 2 == 0));
        System.out.println("Collectors.groupingBy(i -> i % 2 == 0) : " + group2);
        Map<Boolean, List<Integer>> group3 = numbers.stream().collect(Collectors.partitioningBy(i -> i % 2 == 0));
        System.out.println("Collectors.partitioningBy(i -> i % 2 == 0) : " + group3);

        Map<String, List<Integer>> group4 = numbers.stream().collect(Collectors.groupingBy(i -> i % 2 == 0 ? "even" : "odd"));
        System.out.println("Divide a list of integers into even and odd numbers : " + group4);

        // Problem 15: Convert a list of lists into a single list.
        List<Integer> numbers2 = Arrays.asList(11, 12, 13, 14, 15, 16);
        List<Integer> numbers3 = Arrays.asList(21, 22, 23, 24, 25, 26);

        List<List<Integer>> lists = List.of(numbers, numbers2, numbers3);
        List<Integer> flatList = lists.stream().flatMap(Collection::stream).toList();
        System.out.println("Convert a list of lists into a single list. : " + flatList);

        // Problem 15.1: Print all the words in a file
        /*String path = "C:/myfolder";
        Stream<String> lines1 = Files.lines(Path.of(path), StandardCharsets.UTF_8);
        List<String> words1 = lines1.flatMap(line -> Stream.of(line.split(" +"))).toList();*/

        // Problem 16: Join all the strings in a list with a delimiter.
        List<String> words2 = Arrays.asList("Louis", "Vitton", "France");
        String str1 = words2.stream().collect(Collectors.joining()).toString();
        System.out.println("Join all the strings in a list with a delimiter. : " + str1);
        String str2 = words2.stream().reduce((s1, s2) -> s1 + s2).get().toString();
        System.out.println("Join all the strings in a list with a delimiter. : " + str2);
        String str3 = words2.stream().collect(Collectors.joining(", ")).toString();
        System.out.println("Join all the strings in a list with a delimiter. : " + str3);
        String str4 = words2.stream().collect(Collectors.joining(", ", "pref", "suff")).toString();
        System.out.println("Join all the strings in a list with a delimiter. : " + str4);

        // Problem 17: Find the top 3 highest salaries from a list of employees.
        List<Employee> emps = Arrays.asList(
                new Employee("Krishna", 36, "Accounts", 65000),
                new Employee("Vikram", 39, "IT", 75000),
                new Employee("Jaya", 24, "HR", 45000)
        );
        employees.addAll(emps);

        List<Double> list3 = employees.stream()
                .sorted(Comparator.comparingDouble((Employee e) -> e.salary).reversed()) // cast to e is required
                .limit(3)
                .map(Employee::getSalary)
                .toList();
        System.out.println("Find the top 3 highest salaries : " + list3);

        List<String> list4 = employees.stream().sorted(Comparator.comparingDouble((Employee e) -> e.getSalary()).reversed()).limit(3).map(e -> e.getName() + " " + e.getSalary()).toList();
        System.out.println("Find the top 3 highest salaries : " + list4);

        Map<String, Double> map3 = employees.stream()
                .sorted(Comparator.comparingDouble((Employee e) -> e.getSalary()).reversed())
                .limit(3)
                //.collect(Collectors.toMap(e -> e.getName(), e -> e.getSalary()));
                .collect(
                        Collectors.toMap(
                                Employee::getName, // key mapper
                                Employee::getSalary,  // value mapper
                                (v1, v2) -> v1, // merge function, action to be taken when keys are duplicate
                                LinkedHashMap::new) // collector to keep the Order preserved (default is HashMap which loses the order)
                );
        System.out.println("Find the top 3 highest salaries with names : " + map3);

        // Problem 18: Find and print duplicate elements from a list.
        List<String> fruits = Arrays.asList("apple", "banana", "apple", "orange", "banana");
        List<String> duplicates3 = fruits.stream()
                //.collect(Collectors.groupingBy(e -> e, Collectors.counting())) // Default HashMap (unordered)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting())) // Preserve insertion order
                .entrySet().stream()
                .filter(e -> e.getValue() > 1)
                .map(e -> e.getKey())
                .toList(); // Time complexity -- O(n), efficient -- For large datasets
        System.out.println("Find and print duplicate elements from a list : " + duplicates3);

        List<String> coll1 = fruits.stream().distinct().filter(e -> Collections.frequency(fruits, e) > 1).toList();
        System.out.println("coll1 : " + coll1);

        List<String> coll2 = fruits.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .filter(e -> e.getValue() > 1)
                .map(e -> e.getKey())
                .toList();
        System.out.println("coll2 : " + coll2);


        List<String> duplicates4 = fruits.stream()
                .distinct()
                .filter(e -> Collections.frequency(fruits, e) > 1) // Time complexity -- O(n2), not much efficient but cleaner -- For small collections
                .toList();
        System.out.println("Find and print duplicate elements from a list : " + duplicates4);

        // Problem 19: Count how many times each word appears in a list.
        List<String> words = Arrays.asList("apple", "banana", "apple", "cherry", "jackfruit", "kiwi", "guava", "kiwi");
        Map<String, Long> fruitCount = words.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println("Count how many times each word : " + fruitCount);

        // Problem 21: Find the frequency of each character in a string using streams.
        String s = "a grey brown fox jumps";
        Stream<Character> stream1 = s.chars().mapToObj(c -> (char) c);
        Stream<Character> stream2 = s.codePoints().mapToObj(c -> (char) c);
        s.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        //Stream<char[]> str = Stream.of(s.toCharArray());
        char[] charArr = s.toCharArray();
        Stream<Character> stream3 = IntStream.range(0, s.length()).mapToObj(i -> charArr[i]);

        Stream<Character> charStream = IntStream.range(0, s.length()).mapToObj(i -> s.toCharArray()[i]);
        Map<Character, Long> map4 = charStream.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println("Find the frequency of each character in a string : " + map4);

        /*
        Problem 22:
        Count the number of employees in each department.
        Given a list of Employee objects, group them by department and count how many employees are in each department.
        */

        Map<String, Long> map7 = employees.stream().collect(Collectors.groupingBy((Employee e) -> e.getDepartment(), Collectors.counting()));
        map7 = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
        System.out.println("Count the number of employees in each department : " + map7);

        /*
        Problem 23:
        Find the employee with the highest salary in each department.
        Group employees by department and find the one with the maximum salary in each group.
        */
        Map<String, Double> map8 = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment))
                .entrySet().stream().map(e -> e.getValue().stream().max(Comparator.comparingDouble(Employee::getSalary)).get())
                .collect(Collectors.toMap(Employee::getDepartment, Employee::getSalary)); // very much verbose
        System.out.println("Find the employee with the highest salary in each department : " + map8);

        Map<String, Employee> map9 = employees.stream().collect(Collectors.groupingBy(
                Employee::getDepartment,
                Collectors.collectingAndThen(
                        Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)),
                        Optional::get
                )
        ));// Return complete Employee object
        System.out.println("Find the employee with the highest salary in each department : " + map9);

        Map<String, Double> map10 = employees.stream().collect(Collectors.groupingBy(
                Employee::getDepartment,
                Collectors.collectingAndThen(
                        Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)),
                        e -> e.get().getSalary()
                )
        )); // Return only salary department-wise
        System.out.println("Find the employee with the highest salary in each department : " + map10);


        /*
        Problem 24:
        Filter and collect only distinct elements starting with a specific prefix.
        */
        List<String> words1 = List.of("apple", "apricot", "banana", "apple", "apple", "apricot");
        String prefix = "ap";
        List<String> filtered1 = words1.stream().distinct().filter(s1 -> s1.startsWith(prefix)).toList();
        System.out.println("Filter and collect only distinct elements starting with a specific prefix : " + filtered1);

        /*
        Problem 25:
        Sort a list of strings by their lengths and then alphabetically.
        */
        List<String> words3 = List.of("pear", "banana", "fig", "fag", "apple");
        List<String> sorted1 = words3.stream().sorted(
                Comparator.comparingInt(String::length)
                        .thenComparing(Comparator.naturalOrder())
        ).toList();
        System.out.println("Sort a list of strings by their lengths and then alphabetically : " + sorted1);

        /*
        Problem 26:
        Find the average salary of employees in each department.
        Group employees by department and calculate the average salary.
        */
        Map<String, Double> avgSalaries = employees.stream().collect(Collectors.groupingBy(
                Employee::getDepartment,
                Collectors.averagingDouble(Employee::getSalary)
        ));
        System.out.println("Find the average salary of employees in each department : " + avgSalaries);

        /*
        Problem 27:
        Convert a list of integers into a map where key = number, value = square of number.
        */
        Map<Integer, Integer> map11 = numbers.stream().collect(Collectors.toMap(k -> k, v -> (int) Math.pow(v, 2)));
        System.out.println("Convert a list of integers into a map where key = number, value = square of number : " + map11);


        /*
        Problem 28:
        Group words by starting character and sort each group alphabetically.
        */
        List<String> words4 = List.of("apple", "ant", "artist", "asphalt", "banana", "banter", "ballard", "bat", "ball", "car");
        Map<Character, List<String>> map12 = words4.stream().collect(Collectors.groupingBy(
                (String s5) -> s5.charAt(0),
                Collectors.collectingAndThen(
                        Collectors.toList(),
                        list10 -> list10.stream().sorted().toList()
                )
        ));
        System.out.println("Group words by starting character and sort each group alphabetically - map12 : " + map12);

        words4.stream().collect(Collectors.groupingBy(s4 -> s4.charAt(0)));
        Map<Character, List<String>> map13 = words4.stream().collect(
                Collectors.groupingBy(
                        s4 -> s4.charAt(0), // classifier
                        Collectors.collectingAndThen( // downstream collector function
                                Collectors.toList(), // actual collector
                                //list -> list.stream().sorted().collect(Collectors.toCollection(ArrayList::new)) // finisher
                                list -> list.stream().sorted(String::compareTo).collect(Collectors.toCollection(ArrayList::new)) // finisher
                        )
                )
        );
        System.out.println("Group words by starting character and sort each group alphabetically - map13 : " + map13);

        Map<Character, List<String>> map14 = words4.stream().collect(Collectors.groupingBy(
                (String s6) -> s6.charAt(0),
                Collectors.toCollection(LinkedList::new)) // LinkedList preserves the insertion order but does not sort elements
        );
        System.out.println("Group words by starting character and sort each group alphabetically - map14 : " + map14);

        Map<Character, Set<String>> map15 = words4.stream().collect(Collectors.groupingBy(
                (String s7) -> s7.charAt(0),
                Collectors.toCollection(() -> new TreeSet<>()) // keeps elements sorted in their natural order
        ));
        System.out.println("Group words by starting character and sort each group alphabetically - map15 : " + map15);

        Map<Character, List<String>> map16 = words4.stream().sorted().collect(Collectors.groupingBy((String s8) -> s8.charAt(0)));
        System.out.println("Group words by starting character and sort each group alphabetically - map16 : " + map16);

        /*
        Problem 30:
        Find the most frequent element in a list.
        */
        List<String> items = List.of("a", "b", "a", "c", "b", "b", "b", "a");
        String frequentEle = items.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                //.collect(Collectors.maxBy(Comparator.comparingInt(entry -> entry.getValue())))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                //.get().getKey()
                .map(Map.Entry::getKey).orElse(null);
        System.out.println("Find the most frequent element in a list : " + frequentEle);

        /*
        Problem 33:
        Sort employees first by department, then by descending salary.
        */
        List<Employee> list5 = employees.stream().sorted(
                        Comparator.comparing(Employee::getDepartment)
                                .thenComparing(Comparator.comparingDouble(Employee::getSalary)
                                        .reversed()))
                .toList();
        System.out.println("Sort employees first by department, then by descending salary. : " + list5);

        /*
        Problem 35:
        Find words that occur only once in the list.
        */
        List<String> fruits2 = Arrays.asList("apple", "banana", "apple", "cherry", "jackfruit", "kiwi", "guava", "kiwi");
        List<String> uniqueFruits = fruits2.stream().filter(e -> Collections.frequency(fruits2, e) == 1).toList(); // Time complexity - O(n^2)
        System.out.println("Find words that occur only once in the list. : " + uniqueFruits);

        List<String> uniqueFruits1 = fruits2.stream()
                //.collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .filter(e -> e.getValue() == 1)
                .map(Map.Entry::getKey)
                .toList(); // Time complexity - O(n), actually it is O(2n) in worst case but Big-O ignores constant factor
        System.out.println("Find words that occur only once in the list. : " + uniqueFruits1);

        /*
        Problem 37:
        Flatten a nested list of integers and sort the result.
        */
        List<Integer> nums1 = new ArrayList<>(Arrays.asList(2, 7, 31, 82, 01));
        List<Integer> nums2 = new ArrayList<>(Arrays.asList(11, 27, 16, 52, 97));
        List<Integer> nums3 = new ArrayList<>(Arrays.asList(65, 73, 39, 47, 10));
        List<List<Integer>> numsList = new ArrayList<>(Arrays.asList(nums1, nums2, nums3));

        List<Integer> sorted2 = numsList.stream().flatMap(List::stream).sorted().toList();
        System.out.println("Flatten a nested list of integers and sort the result. : " + sorted2);

        /*
        Problem 38:
        Get summary statistics of a list of integers.
        */
        IntSummaryStatistics stats = sorted2.stream().mapToInt(Integer::intValue).summaryStatistics();
        System.out.println("Get summary statistics of a list of integers : " + stats);

        /*
        Problem 40:
        Get the top 3 longest names.
        */
        List<String> list6 = fruits2.stream()
                .sorted(Comparator.comparingInt(String::length).reversed())
                .limit(3)
                .toList();
        System.out.println("Get the top 3 longest names : " + list6);

        /*
        Problem 41:
        Get the total salary paid to employees older than 30.
        Filter the list of employees and sum the salaries of those older than 30.
        */
        Double totalSalaryAge30Above = employees.stream().filter(e -> e.getAge() > 30).collect(Collectors.summingDouble(Employee::getSalary));
        employees.stream().filter(e -> e.getAge() > 30).mapToDouble(e -> e.getSalary()).sum();
        employees.stream().filter(e -> e.getAge() > 30).map(Employee::getSalary).reduce(Double::sum).orElse(0.0);
        System.out.println("Get the total salary paid to employees older than 30 : " + totalSalaryAge30Above);

        /*
        Problem 42:
        Convert a list of strings to a single string with unique characters only.
        */
        List<String> list = List.of("abc", "bcd", "cde");
        String uniqueCharsStr = list.stream()
                .flatMap(s9 -> s9.chars().mapToObj(c -> (char) c))
                .distinct()
                .map(Object::toString)
                .collect(Collectors.joining());
        System.out.println("Convert a list of strings to a single string with unique characters only. : " + uniqueCharsStr);

        /*
        Problem 43:
        Find the second-highest number in a list.
        */
        int secondHighest = numbers.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst().orElse(0); //.get();
        System.out.println("Find the second-highest number in a list : " + secondHighest);

        /*
        Problem 44:
        Check if any string in the list is a palindrome.
        */
        //List<String> words6 = List.of("level", "world", "radar", "java");
        List<String> words6 = List.of("Level", "World", "Radar", "Java");
        List<String> palindromes = words6.stream().filter(ss -> {
            StringBuilder sb = new StringBuilder(ss);
            return ss.equalsIgnoreCase(sb.reverse().toString());
        }).toList();
        palindromes = words6.stream().filter(ss1 -> ss1.equalsIgnoreCase(new StringBuilder(ss1).reverse().toString())).toList();
        palindromes = words6.stream().filter(StreamsExamples::isPalindrome).toList(); // more cleaner approach
        System.out.println("Check if any string in the list is a palindrome : " + palindromes);

        /*
        Problem 45:
        Group people by age group: "Minor" (<18), "Adult" (18–60), "Senior" (>60).
        Use streams to categorize people into age groups.
        */
        class Person {

            String name;
            int age;
            String city;

            Person(String name, int age) {
                this.age = age;
                this.name = name;
            }
            public String getName() { return name; }

            public int getAge() { return age; }

            public String getCity() { return city; }

            @Override
            public String toString() { return "Person[" +  "name=" + name + ", age=" + age + "]"; };
        }

        Person p1 = new Person("Anil", 18);
        Person p2 = new Person("Kareena", 48);
        Person p3 = new Person("Amanda", 33);
        Person p4 = new Person("Jignesh", 61);
        Person p5 = new Person("Rocky", 9);
        Person p6 = new Person("Ramesh", 79);
        List<Person> personList = new ArrayList<>(List.of(p1, p2, p3, p4, p5, p6));

        Map<String, List<Person>> map18 = personList.stream().collect(
                Collectors.groupingBy(
                        per -> {
                            if (per.age < 18) return "Minor";
                            else if (per.age > 60) return "Senior";
                            else return "Adult";
                        }/*,
                        Collectors.toList()*/
        ));

        Map<String, List<Person>> map18Sorted = personList.stream().collect(Collectors.groupingBy(
                per -> {
                    if (per.age < 18) return "Minor";
                    else if (per.age > 60) return "Senior";
                    else return "Adult";
                },
                Collectors.collectingAndThen(
                        Collectors.toList(),
                        listt -> listt.stream().sorted(Comparator.comparing(Person::getName)).toList()
                )
        ));
        System.out.println("Group people by age group : " + map18);
        System.out.println("Group people by age group : " + map18Sorted);

        /*
        Problem 46:
        Partition numbers into prime and non-prime.
        */
        List<Integer> ints = IntStream.range(0, 100).mapToObj(i -> i).toList();
        Map<String, List<Integer>> mapPrimes = ints.stream().collect(Collectors.groupingBy(i -> {
            if (isPrime(i)) return "prime";
            else return "non-prime";
        }));

        Map<String, List<Integer>> mapPrimes2 = ints.stream().collect(Collectors.groupingBy(i2 -> {
            if (i2 == 0 || i2 == 1) return "prime";
            else {
                for (int j = 2; j <= i2 / 2; j++) {
                    if (i2 % j == 0) return "non-prime";
                }
                return "prime";
            }
        }));

        System.out.println("Partition numbers into prime and non-prime : " + mapPrimes);
        System.out.println("Partition numbers into prime and non-prime : " + mapPrimes2);

        /*
        Problem 47:
        Find duplicate characters in a string.
        */
        String s1 = "aabra ka dabra";
        List<Character> duplicateChars = s1.codePoints().mapToObj(c -> (char) c).collect(Collectors.toList())
                .stream().collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream().filter(e -> e.getValue() > 1)
                .map(Map.Entry::getKey)
                .toList();
        System.out.println("Find duplicate characters in a string. : " + duplicateChars);

        // Using HashSet
        Set<Character> seen = new HashSet<>();
        List<Character> duplicateChars1 = s1.codePoints().mapToObj(c -> (char) c).filter(c -> c != ' ').filter(c -> !seen.add(c)).distinct().toList();
        System.out.println("Find duplicate characters in a string. : " + duplicateChars1);

        /*
        Problem 48:
        Find the first repeated word in a list.
        */
        String firstRepeated = fruits2.stream().collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream().filter(e -> e.getValue() > 1).map(Map.Entry::getKey).findFirst().get();
        System.out.println("Find the first repeated word in a list : " + firstRepeated);

        Set<String> seen2 = new HashSet<>();
        String firstRepeated2 = fruits2.stream().filter(c -> !seen2.add(c)).findFirst().get();
        System.out.println("Find the first repeated word in a list : " + firstRepeated2);

        /*
        Problem 49:
        Find the longest palindrome string in a list.
        */
        List<String> words5 = List.of("madam", "racecar", "apple", "wow", "abcddcba");
        String longestPalindrome = words5.stream().filter(s4 -> {
            StringBuilder sb = new StringBuilder(s4);
            return s4.equals(sb.reverse().toString());
        }).max(Comparator.comparing(String::length)).orElse("null");
        System.out.println("Find the longest palindrome string in a list : " + longestPalindrome);

        System.out.println("");

        /*
        Problem 50:
        From a list of transactions, group by type and calculate total amount for each type.
        Use streams to group and summarize.
        */
        class Transaction {
            String type;
            double amount;

            public String getType() { return type; }
            public double getAmount() { return amount; }

            Transaction(String type, double amount) {
                this.type = type;
                this.amount = amount;
            }

            public String toString() {
                return type + ": " + amount;
            }
        }

        List<Transaction> transactions = List.of(
                new Transaction("Credit", 100.0),
                new Transaction("Debit", 50.0),
                new Transaction("Credit", 200.0)
        );

        Map<String, Double> txgroup = transactions.stream().collect(Collectors.groupingBy(
                        Transaction::getType,
                        Collectors.summingDouble(Transaction::getAmount)
                )
        );
        System.out.println("Transactions group by type and calculate total amount for each type : " + txgroup);
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
}
