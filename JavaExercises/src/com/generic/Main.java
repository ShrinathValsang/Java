package com.generic;

// Online Java Compiler
// Use this editor to write, compile and run your Java code online


import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class Main {
    public static void main(String[] args) {
        System.out.println("Try programiz.pro");

        int[] arr = {1, 0, 2, 0, 3, 0, 4, 0};
        int[] arr1 = {1, 0, 2, 0, 0, 3, 0, 9, 0, 14, 0, 15, 0, 16, 91};

        int ptr = 0;
        for (int j = 0; j < arr1.length; j++) {
            if (arr1[j] != 0) {
                arr1[ptr] = arr1[j];
                ptr++;
            }
        }

        while (ptr < arr1.length) {
            arr1[ptr++] = 0;
        }
        System.out.println(Arrays.toString(arr1));

        /*int i = 0;
        while (i < arr.length) {
            if (arr[i] == 0) {
                // keep looking for next positive integer
                int ptr = i + 1;

                while (ptr < arr.length && arr[ptr] == 0) {
                    ptr++;
                }

                if (ptr < arr.length) {
                    arr[i] = arr[ptr];
                    arr[ptr] = 0;
                }
            }

            i++;
        }

        System.out.println(Arrays.toString(arr));*/

        List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
        list.removeIf(x -> x == 0); // keep only non-zeros
        list.addAll(Collections.nCopies(arr.length - list.size(), 0));
        System.out.println(list);

        // balanced brackets
        String br = "{[()()[]]}ssssssssss";
        boolean isBalanced = isBracketsBalanced(br);
        System.out.println("Brackets are balanced in the string " + br + " :" + isBalanced);

        System.out.println("Brackets are balanced in the string " + br + " :" + isBracketsBalanced1(br));


        Function<Integer, Double> priceCalc = age -> {
            double price;
            if (age <= 12) {
                System.out.println("Attendee is a child");
                price = 50.0;
            } else {
                System.out.println("Attendee is not a child");
                price = 100;
            };
            return price;

        };
        System.out.println("price : " + priceCalc.apply(11));
        System.out.println("price : " + priceCalc.apply(12));
        System.out.println("price : " + priceCalc.apply(13));

        Predicate<String> isValidNumber = s -> s.matches("\\d{10}");
        System.out.println(isValidNumber.test("1234567890"));
        System.out.println(isValidNumber.test("123456789"));

        Consumer<String> cons = e -> System.out.println("My name is " + e);
        cons.accept("Shrinath");

        Supplier<String> sup = () -> "ACC" + new Random().nextInt(100);
        System.out.println(sup.get());



        // get all permutations for a string
        String st = "MUSKE";
        System.out.println("String permutatoins for : " + st + ": " + getPermutations(st, ""));

        List<Integer> myList = List.of(6,7,8,9,10);
        double average1 = myList.stream().mapToInt(i -> i.intValue()).average().getAsDouble();
        System.out.println("average1 : " + average1);
        double average2 = myList.stream().mapToDouble(i -> i.doubleValue()).average().getAsDouble();
        System.out.println("average2 : " + average2);

        //Arrays.asList("apple", "banana", "kiwi", "orange", "pear").stream().collect(Collections.reverseOrder());
        List<Integer> numbers = Arrays.asList(1, 3, 5, 7, 9, 2, 4, 6, 8, 10);
        int targetNumber = 7;

        int ind = IntStream.range(0, numbers.size()).filter(i -> numbers.get(i) == targetNumber).findFirst().getAsInt();
        System.out.println("Index of targetNumber : " + ind);

        /**
         * https://medium.com/@bhangalekunal2631996/java-stream-api-coding-interview-questions-and-answers-2a212505e1c6
         *
         * **/
        // 38. Given a list of strings, write a program to find and print the strings with the maximum number of vowels using Java Stream API.
        List<String> strings = Arrays.asList("apple", "banana", "kiwi", "orange", "pear");
        String vowels = "aeiouAEIOU";

        String strwithmaxvowels = strings.stream().collect(
                Collectors.toMap(
                        Function.identity(),
                        s -> s.chars().filter(ch -> vowels.indexOf(ch) != -1).count()
                )).entrySet().stream().max(Map.Entry.comparingByValue()).get().getKey();

        System.out.println("String with the maximum number of vowels : " + strwithmaxvowels);

        // USING collectingAndThen
        Map.Entry<String, Long> map1 = strings.stream().collect(
                Collectors.collectingAndThen( // this grouping will only give only one element!!
                        Collectors.toMap(
                                Function.identity(),
                                s -> s.chars().filter(ch -> vowels.indexOf(ch) != -1).count()
                        ),
                        map -> map.entrySet().stream().max(Map.Entry.comparingByValue()).get()
                ));
        System.out.println("strings with the maximum number of vowels  : " + map1);

        Map.Entry<Long, List<String>> map2 = strings.stream().collect(
                Collectors.collectingAndThen(
                        Collectors.groupingBy(s -> s.chars().filter(ch -> vowels.indexOf(ch) != -1).count()),
                        map -> map.entrySet().stream().max(Map.Entry.comparingByKey()).get()
                ));
        System.out.println("strings with the maximum number of vowels  : " + map2);


        // 40. Given a list of strings, write a program to find and print the strings with the minimum number of vowels using Java Stream API.
        Map.Entry<Long, List<String>> map3 = strings.stream().collect(
                Collectors.collectingAndThen(
                        Collectors.groupingBy(s -> s.chars().filter(ch -> vowels.indexOf(ch) != -1).count()),
                        map -> map.entrySet().stream().min(Map.Entry.comparingByKey()).get()
                )
        );
        System.out.println("strings with the minimum number of vowels  : " + map3);




        List<Employee> employees = new ArrayList<>(Arrays.asList(
                new Employee("Rajesh", 32, "HR", "Senior HR", 39000),
                new Employee("Shriya", 26, "HR", "Junior HR", 26000),
                new Employee("Bholeshwar", 42, "Projects", "Team Lead", 72000),
                new Employee("Joseph", 30, "Projects", "Associate", 41000),
                new Employee("Mahima", 27, "Projects", "Analyst", 30000)
        ));

        // group by department -- traditional approach
        Map<String, List<Employee>> result = groupEmployeesByDeparment(employees);
        System.out.println("group by department -- traditional approach : " + result);

        // group by department -- using Java Streams
        result = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment));
        System.out.println("group by department -- using Java Streams : " + result);


    }


    static Map<String, List<Employee>>  groupEmployeesByDeparment(List<Employee> list) {
        Map<String, List<Employee>> groupByDeppt = new HashMap<>();

        for (Employee e : list) {
            List<Employee> depptList = groupByDeppt.getOrDefault(e.getDepartment(), new ArrayList<Employee>());
            depptList.add(e);
            groupByDeppt.put(e.getDepartment(), depptList);
        }

        return groupByDeppt;
    }


    static List<String> getPermutations(String st, String prefix) {
        List<String> result = new ArrayList<>();

        if (st.length() == 0) {
            result.add(prefix);
            return result;
        }

        for (int i = 0; i < st.length(); i++) {
            char ch = st.charAt(i);
            String remaining = st.substring(0, i) + st.substring(i + 1);
            result.addAll(getPermutations(remaining, prefix + ch));
        }

        return result;
    }

    public static boolean isBracketsBalanced(String br) {
        char[] brch = br.toCharArray();
        Deque<Character> deque = new ArrayDeque<>();
        boolean isBalanced = true;

        for (char ch : brch) {
            if (ch == '{' || ch == '[' || ch == '(') {
                deque.push(ch);
            }

            //if (deque.isEmpty()) return false;

            if (ch == '}' || ch == ']' || ch == ')') {
                if (deque.isEmpty()) return false;

                char pop = deque.pop();
                if (ch == '}' && pop != '{') return false;
                else if (ch == ']' && pop != '[') return false;
                else if (ch == ')' && pop != '(') return false;
            }
        }

        return deque.isEmpty();
    }

    public static boolean isBracketsBalanced1(String br) {
        Deque<Character> deque = new ArrayDeque<>();

        for (char ch : br.toCharArray()) {
            switch(ch) {
                case '{': case '[': case '(':
                    deque.push(ch);
                    break;
                case '}':
                    if (deque.isEmpty() || deque.pop() != '{') return false;
                    break;
                case ']':
                    if (deque.isEmpty() || deque.pop() != '[') return false;
                    break;
                case ')':
                    if (deque.isEmpty() || deque.pop() != '(') return false;
                    break;
                default:
                    // non-bracket characters ignored
            }
        }

        return deque.isEmpty();
    }



}

class Employee {
    private String name;
    private int age;
    private String department;
    private String title;
    private int salary;

    public Employee(String name, int age, String department, String title, int salary) {
        this.name = name;
        this.age = age;
        this.department = department;
        this.title = title;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getDepartment() {
        return department;
    }

    public String getTitle() {
        return title;
    }

    public int getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", department='" + department + '\'' +
                ", title='" + title + '\'' +
                ", salary=" + salary +
                '}';
    }
}