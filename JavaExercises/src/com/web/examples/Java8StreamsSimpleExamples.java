package com.web.examples;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


/**
 * Java 8 Simple interview coding questions -- mostly int array and strings.
 * 
 * https://javaconceptoftheday.com/java-8-interview-sample-coding-questions/
 */
public class Java8StreamsSimpleExamples {

	public static void main(String[] args) {
		
		// GIVEN AN ARRAY...
		int[] arr = { 5, 4, 9, 12, 3, 8, 5, 7, 10, 3, 2, 13, 6, 15, 1, 5, 9 };
		List<Integer> original = IntStream.of(arr).boxed().collect(Collectors.toList());
		List<Integer> original1 = IntStream.of(arr).boxed().collect(Collectors.toCollection(ArrayList::new));
		System.out.println("Input array: " + original);
		
		// Q1. Separate odd and even numbers.
		System.out.println("Separate odd and even numbers.");
		Map<Boolean, List<Integer>> map0 = Arrays.stream(arr).boxed().collect(Collectors.partitioningBy(i -> i % 2 == 0));
		Map<Boolean, List<Integer>> map1 = IntStream.of(arr).boxed().collect(Collectors.partitioningBy(e -> (e & 1) == 0));
		map1.entrySet().stream()
			.forEach(entry -> System.out.println("key: " + entry.getKey() + " value: " + entry.getValue()));
		
		// Q2. Sort array in reverse order
		// Arrays.stream(arr).boxed().map(i -> arr[arr.length - 1 - i]).collect(Collectors.toList()).forEach(i -> System.out.printf(i + " "));
		 List<Integer> reverseSorted = Arrays.stream(arr).boxed().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
		 System.out.println("\nSort array in reverse order -- " + reverseSorted);
		
		// Q2. Sort array
		List<Integer> sorted = IntStream.of(arr).boxed().sorted().collect(Collectors.toList());
		System.out.println("\nSort array -- " + sorted);
		
		// Q2A. Reverse the array
		int[] reversedArr = IntStream.range(0, arr.length).map(i -> arr[arr.length - 1 - i]).toArray();
		List<Integer> reversed = IntStream.of(reversedArr).boxed().collect(Collectors.toList());
		System.out.println("\nReverse the array -- " + reversed);
		
		// Q3. Print multiples of 5 in the list
		System.out.println("\nPrint multiples of 5 in the list -- ");
		original.stream().filter(i -> i%5 == 0).forEach(e -> System.out.print(e + " "));
		
		// Q4. Merge two unsorted arrays into single sorted array
		int[] a1 = { 2, 9, 1, 0, 67, 58, 34, 38, 50 };
		int[] a2 = { 16, 29, 19, 10, 50, 47, 38, 2 };
		System.out.println("\nMerge two unsorted arrays into single sorted array");
		IntStream.concat(Arrays.stream(a1), Arrays.stream(a2)).sorted().forEach(e -> System.out.print(e + " "));
		
		// Q5. Merge two unsorted arrays into single sorted array without duplicates
		System.out.println("\nMerge two unsorted arrays into single sorted array without duplicates");
		IntStream.concat(IntStream.of(a1), IntStream.of(a2)).distinct().sorted().forEach(e -> System.out.print(e + " "));
		
		// Q6. Three max and min numbers from the list
		System.out.println("\nThree max numbers from the list");
		original.stream().sorted().limit(3).forEach(e -> System.out.print(e + " "));
		
		System.out.println("\nThree min numbers from the list");
		original.stream().sorted(Comparator.reverseOrder()).limit(3).forEach(e -> System.out.print(e + " "));
		
		// Q7. Sum and average of all elements in an array
		System.out.println("\nSum of all elements in an array -- " + IntStream.of(arr).sum());
		System.out.println("\naverage of all elements in an array -- " + IntStream.of(arr).average().getAsDouble());
		
		// Q8. Reverse an integer array
		System.out.println("\nReverse an integer array");
		int[] revArray = IntStream.range(0, arr.length).map(i -> arr[arr.length-i-1]).toArray();
		Arrays.stream(revArray).boxed().forEach(e -> System.out.print(e + " "));
		
		// Q9. Remove duplicates from the list
		System.out.println("\nRemove duplicates from the list");
		original.stream().distinct().forEach(e -> System.out.print(e + " "));
		
		// Q10. Frequency of each element in an array
		System.out.println("\nFrequency of each element in an array");
		Map<Integer, Long> map01 = original.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println(map01);
		
		// Q11. Find the last element in the array
		int last = IntStream.of(arr).boxed().skip(arr.length - 1).findFirst().orElse(-1);
		System.out.println("\nFind the last element in the array -- " + last);

		// Q11A. Find the second last element in the array
		int secondLast = IntStream.of(arr).boxed().skip(arr.length - 2).findFirst().orElse(-1);
		System.out.println("\nFind the second last element in the array -- " + secondLast);
		
		// Q12. Maximum and minimum in a list
		int max = IntStream.of(arr).boxed().max(Comparator.naturalOrder()).orElse(-1);
		System.out.println("Maximum in a list -- " + max);
		
		int min = IntStream.of(arr).boxed().min(Comparator.naturalOrder()).orElse(-1);
		System.out.println("minimum in a list -- " + min);
		
		// Q13. Anagram program in Java 8
		// anagram - strings containing exact same characters with same occurrences
		System.out.println("\nAnagram program in Java 8");
		String s1 = "listen", s2 = "silent";
		String s11 = Arrays.stream(s1.split("")).sorted().collect(Collectors.joining());
		String s12 = Arrays.stream(s2.split("")).sorted().collect(Collectors.joining());
		System.out.println(s11.equals(s12));
		
		// Q14. Sum of all digits of a number
		int n = 23492, sum = 0;
		while (n > 0) {
			sum += n % 10;
			n /= 10; 
		}
		System.out.println("\nSum of all digits of a number -- " + sum);
		
		int sum1 = String.valueOf("23492").chars().map(n1 -> Character.getNumericValue(n1)).sum();
		System.out.println("Sum of all digits of a number using String.chars() -- " + sum1);
		
		int num = 23492;
		// Stream.iterate(T seed, Predicate<? super T> hasNext, UnaryOperator<T> next)
		int digitSum = Stream.iterate(num, i -> i != 0, i -> i / 10)
			.map(i -> i % 10)
			.reduce(0, Integer::sum);
		System.out.println("Sum of all digits of a number using Stream.iterate -- " + digitSum);
		
		// Q15. Second largest number in an array
		int secondLargest = original.stream().sorted(Comparator.reverseOrder()).skip(original.size() - 2).findFirst().orElse(-1);
		System.out.println("Second largest number in an array -- " + secondLargest);
		
		// Q15A. Second lowest number in an array
		int secondLowest = original.stream().sorted(Comparator.naturalOrder()).skip(original.size() - 2).findFirst().orElse(-1);
		System.out.println("Second lowest number in an array -- " + secondLowest);
				
		// Q16. Common elements between two arrays
		List<Integer> l1 = Arrays.stream(a1).boxed().toList();
		List<Integer> l2 = Arrays.stream(a2).boxed().toList();
		List<Integer> common = l1.stream().filter(l2::contains).toList();
		System.out.println("\nCommon elements between two arrays -- " + common);
		
		// Q17. Find sum of first 10 natural numbers
		System.out.println("Find sum of first 10 natural numbers -- " + IntStream.range(0, 11).sum());
		
		
		// Q18. Find duplicate element in an array
		List<Integer> duplicates = original.stream().distinct().filter(x -> Collections.frequency(original, x) > 1).toList();
		System.out.println("Find duplicate element in an array -- " + duplicates);
		
		
		// Q19. Fibonacci series using Java 8
		// Method 1 -- using Stream.generate method
		System.out.println("\nFibonacci series using Java 8 - Using Stream.generate function ");
		
		// This doesn't work. Instead, use a mutable object to hold the state:
		//		UnaryOperator<int[]> fibonacci = n -> new int[]{n[1], n[0] + n[1]};
		//		List<Integer> fib2 = Stream.generate(() -> new int[] {0, 1})
		//			.map(n -> fibonacci.apply(n))
		//			.limit(25).map(n -> n[0])
		//			.takeWhile(n -> n <= 500)
		//			.collect(Collectors.toList());
		//		fib2.forEach(i -> System.out.print(i + " "));

		// Instead, use a mutable object to hold the state:
        Supplier<int[]> fibonacciSupplier = new Supplier<int[]>() {
        	private int[] fib = new int[] {0, 1};

        	@Override
            public int[] get() {
                int[] oldFib = fib.clone();
                fib[0] = fib[1];
                fib[1] = oldFib[0] + oldFib[1];
                return oldFib;
            }
        };
        
        Stream.generate(fibonacciSupplier)
        	.limit(30)
        	.map(ar -> ar[0])
        	.takeWhile(i -> i <= 1000)
        	.forEach(ele -> System.out.print(ele + " "));
		
		// Method 2 -- using Stream.iterate method, simpler
		System.out.println("\nFibonacci series using Java 8 - Using Stream.iterate method, simpler");
		List<Integer> fib = Stream.iterate(new int[]{0, 1}, n2 -> new int[] {n2[1], n2[0] + n2[1]})
			//.limit(20)
			.map(n2 -> n2[0])
			.takeWhile(n2 -> n2 <= 1000)
			.collect(Collectors.toList());
		fib.forEach(i -> System.out.print(i + " "));
		
		
		
		// Q20. Given an array of consecutive number find the missing number
		int[] numbers = { 108, 109, 110, 111, 112, 114, 115, 116, 117, 118, 119 };
		
		// consecutive sum = number of terms * (first + last) / 2
		int l = numbers.length, consecutiveSum = (l + 1)  * (numbers[0] + numbers[l-1]) / 2; 
		int missingNum = consecutiveSum - Arrays.stream(numbers).sum();
		System.out.println("\nThe missing number in the consecutive numbers array : " + missingNum);
		
		// Q21. Most repeated element in an array
		int[] input2 = { 1, 2, 3, 4, 2, 2, 3, 4, 4, 4, 5, 5, 4 };
		int maxOcc = Arrays.stream(input2).boxed().collect(Collectors.groupingBy(
				Function.identity(), 
				Collectors.counting()
		)).entrySet().stream().max(Map.Entry.comparingByValue()).get().getKey();
		System.out.println("Most repeated element in an array -- " + maxOcc);
		
		
		/*******************************************************************************************/
		System.out.println("*** STRING QUESTIONS ***");
		// GIVEN A STRING...
		// Q. Given an string, find frequency of each character in the string
		String str = "ABBBCDDEFEFGGH";
		// convert string to char list
		List<Character> charList = str.chars().mapToObj(c -> (char) c).toList(); //str.chars() returns IntStream
		System.out.println("charList -- " + charList);
		
		List<Character> charList1 = Arrays.stream(str.split("")).map(s -> s.charAt(0)).toList();
		System.out.println("charList1 -- " + charList1);
		
		// Q. Sort the strings in the the increasing order of their length
		
		 
		// Q. Reverse a string using Java 8 (Streams) OR Palindrome program in Java 8
		String st1 = "silolis";
		int le = st1.length();
		
		for (int i = 0; i < le / 2; i++) {
			if (st1.charAt(i) != st1.charAt(le-i-1)) {
				System.out.println("String %s is");
			}
		}
		
		// Q. Reverse each word of a string using Java 8
		// Q. Find strings which start with a number
		// Q. 
		// Q. 
		// Q. 
		// Q. Sort the Employees based on the last letter of their first names.
		// Q11. Join the list of strings with prefix, suffix and delimiter
		// Q12. Find all pair of elements whose sum=10 using Java 8.
		// Q13. Find out all consecutive characters in a String using Java 8. 
		String str1 = "ABBBCDDEFEFGGH";
		
		// Q14. Find no of occurrences of a character in a String 
		String st = "AXYT:DOOGEBBBCDDEFEFGGH";
		
		// Q. Age of a person in years
		LocalDate bday = LocalDate.of(1985, 8, 28);
		LocalDate today = LocalDate.now();
		System.out.println("\n\nAge of the person : " + ChronoUnit.YEARS.between(bday, today));
		
		String s33 = "apple, orange, banana, apple, orange, pineapple, coconut, banana, orange, kiwi";
		String[] strArray = s33.split(", ");
		
		List<String> s33List = Arrays.asList(strArray);
		
		Map<String, Long> map11 = s33List.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		
		int N = 3;
		List<Entry<String, Long>> coll = map11.entrySet()
			.stream()
//			.sorted(Map.Entry.<String, Long>comparingByValue().reversed())
			.sorted(Map.Entry.<String, Long>comparingByValue(Comparator.reverseOrder()))
			.limit(N) 
			.collect(Collectors.toList());
		
		coll.forEach(entry -> System.out.println(entry.getKey() + " " + entry.getValue()));
		
		
	}

}
