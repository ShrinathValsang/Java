package com.rough;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static java.util.Map.entry;

public class TestClass {
    public static void main(String[] args) {
        int[] intArray = {
                17, 23, 29, 31, 37, 41, 43, 47, 53, 59
        };

        Integer [] intArray1 = {
                17, 23, 29, 31, 37, 41, 43, 47, 53, 59
        };

        new TestClass().printArray(intArray1);

        Arrays.stream(intArray)
                 .reduce((x, y) -> (x > y ? x : y))
                 .ifPresent(max -> System.out.println("max " + max));

        Arrays.stream(intArray)
                .reduce((x, y) -> (x < y ? x : y))
                .ifPresent(min -> System.out.println("min " + min));

        Employee e1 = new Employee("1000", "e1", 10000);
        Employee e2 = new Employee("1001", "e2", 10001);
        Employee e3 = new Employee("1002", "e3", 10002);
        Employee e4 = new Employee("1003", "e4", 10003);
        Employee e5 = new Employee("1004", "e5", 10004);

        List<Employee> elist = new ArrayList<>();
        elist.add(e1);
        elist.add(e2);
        elist.add(e3);
        elist.add(e4);
        elist.add(e5);

        // OR
        List<Employee> empList = new ArrayList<>() {
            {
                add(new Employee("1005", "e5", 10005));
                add(new Employee("1006", "e6", 10006));
                add(new Employee("1007", "e7", 10007));
                add(new Employee("1008", "e8", 10008));
                add(new Employee("1009", "e9", 10009));
            }
        };

        // Remember Arrays.asList returns immutable collection, any
        // modification will throw UnsupportedOperationException.
        List<Employee> empList2 = Arrays.asList(
                new Employee("1010", "e10", 10010),
                new Employee("1011", "e11", 10011),
                new Employee("1012", "e12", 10012)
        );

        // To get a mutable collection
        List<Employee> empList3 = new ArrayList<>(
                Arrays.asList(
                        new Employee("1013", "e13", 10013),
                        new Employee("1014", "e14", 10014),
                        new Employee("1015", "e15", 10015)
                )
        );

        System.out.println("Sorted elist - ascending order");
        Collections.sort(elist, (
                (Employee e11, Employee e22) -> e22.getId().compareTo(e11.getId())
        ));

        Map<String, Integer> map = new HashMap<>();

        //Map<String, Integer> map22 = new HashMap<>(Map.ofEntries()); -- mutable map
        Map<String, Integer> map2 = Map.ofEntries(
                java.util.Map.entry("A", 1032),
                java.util.Map.entry("C", 1053),
                java.util.Map.entry("D", 831),
                java.util.Map.entry("B", 1291),
                java.util.Map.entry("E", 1142)
        );
        // sort map based on values only

        LinkedList<Map.Entry<String, Integer>> list10 = new LinkedList<Map.Entry<String, Integer>>(map2.entrySet());
        System.out.println("*** Before sorting *** ");
        list10.forEach(e -> System.out.println(e));

        Collections.sort(list10, (ele1, ele2) -> {
            return ele1.getValue().compareTo(ele2.getValue());
        });

        System.out.println("*** After sorting *** ");
        list10.forEach(e -> System.out.println(e));


        // System.out.println("elist.toString() " + elist.toString());
        System.out.println("Sorted elist - descending order");
        elist.forEach(e -> System.out.println(e.getId()));
        Collections.sort(elist, ((e11, e22) -> e11.getId().compareTo(e22.getId())));

        Employee[] empArr = new Employee[]{e1, e2, e3, e4, e5};
        // List<Employee> list = Arrays.asList(empArr);
        // list.stream().reduce(e1.getSalary(), e2.getSalary() -> ((e1.getSalary() > e2.getSalary()) ? e1.getSalary() : e2.getSalary())

        //list.stream().reduce(e1.getSalary(), e2.getSalary() -> ((e1.getSalary() > e2.getSalary()) ? e1.getSalary() : e2.getSalary());

        Arrays.stream(intArray)
                .reduce((x, y) -> (x > y ? x : y))
                .ifPresent(max -> System.out.println("max " + max));

        /*Arrays.stream(empArr)
                .reduce((a, b) -> {
                    a.getSalary() > b.getSalary() ? a :  b;
                }).isPresent(e1.getSalary());*/

        //Arrays.stream(empArr).collect(collectingAndThen(maxBy(comparingInt(e -> e.getSalary()), Optional::get));

       Optional<Employee> emp = Arrays.stream(empArr)
               .collect(
                       Collectors.maxBy(
                               Comparator.comparingInt(Employee::getSalary))
               );
       if (emp.isPresent()) {
           System.out.println("emp.get().getSalary() " + emp.get().getSalary());
       }

        Optional<Integer> empSal = Arrays.stream(empArr)
                .map(e -> e.getSalary())
                .sorted(Comparator.reverseOrder())
                .findFirst();

        System.out.println("empSal.get() " + empSal.get());

        Optional<Integer> thirdHighetSalary = Arrays.stream(empArr)
                .map(e -> e.getSalary())
                .sorted(Comparator.reverseOrder())
                .skip(2)
                .findFirst();

        System.out.println("thirdHighetSalary.get() " + thirdHighetSalary.get());

        // Length of a string without using size or length method
        // Method 1
        String st = "my name is anthony";
        char[] ch = st.toCharArray();

        int count = 0;
        for (char c : ch) {
            count++;
        }
        System.out.println("Length of the String: " + count);

        // Method 2
        int j=0;
        try {
            for (; ;j++) {
            //for (j=0; ;j++) {
                st.charAt(j);
            }
        } catch (StringIndexOutOfBoundsException e) {
            // don't do anything
        }
        System.out.println("Length of the String (2): " + j++);

        // Method 2.1
        int k=0;
        try {
            while(true) {
                st.charAt(k);
                k++;
            }
        } catch (StringIndexOutOfBoundsException e) {
            // no action needed
        }
        System.out.println("Length of the String (2.1): " + k++);

        // Method 3
        // Runs in constant time time, complexity => O(1)
        System.out.println("Length of the String (3): " + st.lastIndexOf(""));

        // Method 4
        Matcher m = Pattern.compile("$").matcher(st);
        m.find();
        System.out.println("Length of the String (4): " + m.end());


        // program to find get keys having same values from a map
            LinkedHashMap<String,Integer> m1 = new LinkedHashMap<String, Integer>();
            m1.put("1 - Bedroom" , 25000);
            m1.put("2 - Bedroom" , 50000);
            m1.put("3 - Bedroom" , 75000);
            m1.put("22 - Bedroom" , 50000);
            m1.put("33 - Bedroom" , 75000);
            m1.put("333 - Bedroom" , 75000);
//        m1.put("1 - Bedroom - hall", 65000);
//        m1.put("2 - Bedroom - hall", 85000);
//        m1.put("3 - Bedroom - hall", 105000);

        Set<Map.Entry<String, Integer>> entrySet = m1.entrySet();

        for (Map.Entry<String, Integer> entry : entrySet) {
        }

        /*Map<Object, List<Object>> map = entrySet.stream()
                .collect(Collectors.groupingBy(
                        Map.Entry::getValue,
                        Collectors.mapping(Map.Entry::getKey, Collectors.toList())
                        )
                );*/

//        map.forEach((key,val) -> System.out.printf("Key: %d, Values: %s \\n",  key, val.toString() /*StringUtils.join(v, " ")*/));
        //map.forEach((key,val) -> System.out.println("key " + key/*.toString()*/ + ", values " + val.toString()));
        //map.forEach((key,val) -> System.out.println("key: " + (Integer) key + ", values: " + Arrays.toString(val.toArray())));
        //map.forEach((key,val) -> System.out.println("key: " + (Integer) key + ", values: " + val.toArray()));

        //String values =
        /*System.out.println("**********************************************");
        map.forEach((key,val) -> {
            System.out.print("key: " + (Integer) key + ", values: ");
            //val.forEach(System.out::println);
            val.forEach(o -> System.out.print(o + " "));
            System.out.println();
        });*/


//        Map<String, Integer> m2 = new HashMap<String, Integer>();
//        if ( !m.isEmpty() ) {
//            for ( String key : m.values() ) {
//                m2.put(key, 1);
//                if ( m2.containsKey(key) )
//                    m2.put(key, m2.get(key) + 1);
//            }
//
//            for ( Integer v : m2.values() ) {
//                if( v > 1 )
//                    return false;
//            }
//        }
//        else
//            return true;


        LinkedList<String> list = new LinkedList<>();
        list.add("first");
        list.add("second");
        list.add("third");
        list.add("fourth");
        list.add("fifth");

        String middle = list.get(list.size()/2);
        System.out.println("Middle element: " + middle);
    }

    public <T> void printArray(T[] array) {
        for (T t : array) {
            System.out.println(t);
        }

        //Arrays.stream(array).forEach(e -> System.out.println(e));
    }
}

class Employee {
    private String id;
    private String name;
    private int salary;

    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Employee(String s, String e1, int s1) {
        this.id = s;
        this.name = e1;
        this.salary = s1;
    }
}