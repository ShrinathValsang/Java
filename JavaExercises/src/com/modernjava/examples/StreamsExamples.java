package com.modernjava.examples;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.IntSummaryStatistics;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;


public class StreamsExamples {

	public static void main(String[] args) {
		List<Instructor> instructors = ConsumerExample.getInstructors();
		
		Predicate<Instructor> isOnline = i -> i.isOnlineInstructor();
		Predicate<Instructor> has10YrsExp = i -> i.getYrsOfExp() > 10;
		
		Map<String, List<String>> map = instructors.stream()
				.filter(isOnline)
				.filter(has10YrsExp)
				.collect(Collectors.toMap(Instructor::getName, Instructor::getCourses));
		System.out.println("Online Instructors with 10+ yrs of experience: " + map);
		
		List<String> names = Arrays.asList("Mike", "Syed", "Liza", "Bonung", "Kaari");		
		Stream<String> namesStream = names.stream();
		namesStream.forEach(System.out::println);
		
		HashMap hm;
		
//		namesStream.forEach(System.out::println);
//		namesStream.filter(s -> s.startsWith("K"))
//		var v = "K";
//		List<String> list = namesStream.filter(v::startsWith)
//			.collect(Collectors.toList()); 
		// throws -- Exception in thread "main" java.lang.IllegalStateException: stream has already been operated upon or closed
		
//		List<String> names = Arrays.asList("Mike", "Syed", "Liza", "Bonung", "Kaari", "L");
//		List<String> list1 = names.stream().filter(s -> s.startsWith("L")).collect(Collectors.toList());
//		System.out.println("list1 -- " + list1); // prints > list1 -- [Liza]
//		
//		var v1 = "L"; //v1::startsWith
//		Predicate<String> p1 = v1::startsWith;
//		List<String> list2 = names.stream().filter(v1::startsWith).collect(Collectors.toList());
//		System.out.println("list2 -- " + list2); // prints > list2 -- []  empty array!! because you are doing "L".startsWith("Mike") etc.
//		
//		StringChecker ch = String::startsWith;
//		List<String> list3 = names.stream().filter(s -> ch.check(s, v1)).collect(Collectors.toList());
//		System.out.println("list2 -- " + list3); // prints > list2 -- []  empty array!!
//		
//		System.out.println(ch.check("Liz", "L"));
		
		// return only instructors names
		List<String> listOfNames = instructors.stream()
				.map(Instructor::getName) //(i -> i.getName())
				.map(String::toUpperCase) //(s -> s.toUpperCase())
				.collect(Collectors.toList());
		System.out.println(listOfNames);
		
		Set<String> listOfNames1 = instructors.stream()
				.map(Instructor::getName) //(i -> i.getName())
				.map(String::toUpperCase) //(s -> s.toUpperCase())
				.collect(Collectors.toSet());
		System.out.println(listOfNames1);
		
		/*List<Integer> numbers = Arrays.asList(1,4,2,5,9,0);
		List<Integer> squares = numbers.stream().map(x -> x*x).collect(Collectors.toList());
		System.out.println(squares); // [1, 16, 4, 25, 81, 0]
		

		List<Integer> numbers1 = Arrays.asList(1,2,3,4,5,6);
		// stream().reduce(0, Integer::sum) -- also works!
		Integer reduce1 = numbers1.stream().reduce(0, (a,b) -> a + b); // 21
		Integer reduce2 = numbers1.stream().reduce(1, (a,b) -> a + b); // 22
		Integer reduce3 = numbers1.stream().reduce((a,b) -> a + b).get(); // 21
		
		List<String> words = Arrays.asList("hello", "world", "java");
		String concatenated = words.parallelStream()
				.reduce("", (a, b) -> a + b, (a, b) -> a + b);
		System.out.println(concatenated); // Output: helloworldjava
		
		List<String> nameList = Arrays.asList("Mike", "Sandy", "Samit", "Jaya", "Jackie");
		nameList.stream().forEach(s -> System.out.print(s.toUpperCase() + " ")); // MIKE SANDY SAMIT JAYA JACKIE
		
		List<String> startingWithJ = nameList.stream().filter(s -> s.startsWith("J")).collect(Collectors.toList());
		System.out.println(startingWithJ); // [Jaya, Jackie]
		
		List<String> sortedList = nameList.stream().sorted().collect(Collectors.toList());
		System.out.println(sortedList); // [Jackie, Jaya, Mike, Samit, Sandy]
		
		List<String> sortedReverse = nameList.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
		System.out.println(sortedReverse); // [Sandy, Samit, Mike, Jaya, Jackie]
		
		Comparator<String> lengthComparator = (s1, s2) -> Integer.compare(s1.length(), s2.length());
		List<String> sortedList1 = nameList.stream().sorted(lengthComparator).collect(Collectors.toList());
		System.out.println(sortedList1); // [Mike, Jaya, Sandy, Samit, Jackie]
		*/
		
		List<String> courses = instructors.stream()
			.map(Instructor::getCourses)
			.flatMap(List::stream)
			.collect(Collectors.toList());
		System.out.println("All courses: " + courses);
		
		long count = instructors.stream()
				.map(Instructor::getCourses)
				.flatMap(List::stream)
				.count();
			System.out.println("courses count: " + count);
		
		Set<String> distCourses = instructors.stream()
			.map(Instructor::getCourses)
			.flatMap(List::stream)
			.distinct()
			.collect(Collectors.toSet());
		System.out.println("All courses: " + distCourses);
		
		boolean bool = instructors.stream()
			.map(Instructor::getCourses)
			.flatMap(List::stream)
			.allMatch(s -> s.startsWith("S"));
		System.out.println("allMatch(s -> s.startsWith(\"S\") -- " + bool);
		
		boolean bool1 = instructors.stream()
			.map(Instructor::getCourses)
			.flatMap(List::stream)
			.anyMatch(s -> s.startsWith("S"));
		System.out.println("anyMatch(s -> s.startsWith(\"S\") -- " + bool1);
				
		boolean bool2 = instructors.stream()
			.map(Instructor::getCourses)
			.flatMap(List::stream)
			.noneMatch(s -> s.startsWith("S"));
		System.out.println("noneMatch(s -> s.startsWith(\"S\") -- " + bool2);
		
		System.out.println("---------------");
		List<Instructor> sortedList = instructors.stream()
				.sorted(Comparator.comparing(Instructor::getName).reversed())
				.collect(Collectors.toList());
		System.out.println("sortedList -- \n" + sortedList);
		
		
		// reduce
		int result = IntStream.rangeClosed(0, 10).reduce(0, (a,b) -> a + b);
		System.out.println("result -- " + result);
		
		int result1 = IntStream.rangeClosed(0, 10).reduce(1,  (a,b) -> a + b);
		System.out.println("result1 -- " + result1);
				
		//int result2 = IntStream.rangeClosed(0, 10).reduce((a,b) -> a + b).getAsInt();
		int result2 = IntStream.rangeClosed(0, 10).reduce((a,b) -> a * b).getAsInt();
		System.out.println("result1 -- " + result2);
		
		List<Integer> nums = Arrays.asList(0,1,2,3,4,5,6,7,8,9);
		Optional<Integer> opt = nums.stream().reduce((a,b) -> a*b);
		opt.ifPresent(s -> System.out.println(s));
		System.out.println("opt.isPresent() -- " + (opt.isPresent() ? opt.get() : -1));
		
		//instructor with highest years of exeperience
		Optional<Instructor> highestExp = instructors.stream()
			/*.reduce((i1,i2) -> {
				if (i1.getYrsOfExp() > i2.getYrsOfExp())
					return i1;
				else return i2;
			});*/
			.reduce((i1,i2) -> i1.getYrsOfExp() > i2.getYrsOfExp() ? i1 : i2); 
		
		System.out.println(highestExp.orElseGet(null));
		
		int result3 = instructors.stream()
			.filter(Instructor::isOnlineInstructor)
			.map(Instructor::getYrsOfExp)
//			.reduce(0, (a,b) -> a+b);
			.reduce(0, Integer::sum);
		System.out.println(result3);
		
		List<Integer> ints = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		Optional<Integer> res4 = ints.stream().max(Integer::compareTo);
		if (res4.isPresent()) System.out.println(res4.get());
		
		Optional<Integer> res5 = ints.stream().reduce((a,b) -> a > b? a : b);
		if (res5.isPresent()) System.out.println(res5.get());
		
		//course item 53
		List<Integer> nums1 = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

		Optional<Integer> res6 = nums1.stream().min(Integer::compareTo);
		if (res6.isPresent()) System.out.println(res6.get());
		
		// reduce function with identity
		//(0,1) -- 0
		//(0,2) -- 0
		Integer res7 = nums1.stream().reduce(0,(a,b) -> a < b ? a : b);
		System.out.println(res7);
		
		// limit and skip
		List<Integer> res8 = nums1.stream().limit(5).collect(Collectors.toList());
		System.out.println("limit(5) -- " + res8);
		
		List<Integer> res9 = nums1.stream().skip(5).collect(Collectors.toList());
		System.out.println("skip(5) -- " + res9);
		
		// findFirst and findAny
		Optional<Instructor> findAny = instructors.stream().findAny();
		System.out.println("findAny -- " + findAny.get());
		
		Optional<Instructor> findFirst = instructors.stream().findFirst();
		System.out.println("findFirst -- " + findFirst.get());
		
		Arrays.asList(1,2,3,4,5,6,7,8);
		Stream<Integer> st = Stream.of(1,2,3,4,5,6,7,8);
		Stream<Integer> st1 = Stream.of(new Integer[] {1,2,3,4,5,6,7,8});
		
		Stream.iterate(0, i -> i+2).limit(10).forEach(System.out::print);
		
		Stream.generate(new Random()::nextInt).limit(10).forEach(s -> System.out.print(s + ", "));
		
		
		// IntStream
		IntStream is = IntStream.of(1,2,3,4,5);
		System.out.println("Instream is -- " + is);
		
		IntStream nums2 = IntStream.iterate(0, i -> i+2).limit(10);
		IntStream nums3 = IntStream.generate(() -> 
			ThreadLocalRandom.current().nextInt(12, 40))
		.limit(10);
		
		nums3.forEach(s -> System.out.print(s + ", "));
		
		IntStream.range(1, 9).forEach(System.out::println);
		IntStream.rangeClosed(1002020, 1002985).forEach(System.out::println);
		
		/// sum max min
		int sum1 = IntStream.rangeClosed(1000, 1200).sum();
		System.out.println("IntStream.rangeClosed(1000, 1200).sum() -- " + sum1);
		
		OptionalInt min1 = IntStream.range(34, 12342).min();
		System.out.println("IntStream.range(34, 12342).min().getAsInt() -- " + min1.getAsInt());
		
		IntStream.rangeClosed(298, 346).max();
		System.out.println("IntStream.rangeClosed(298, 346).max().getAsInt() -- " + IntStream.rangeClosed(298, 346).max().getAsInt());
		double avg = IntStream.rangeClosed(100, 1000).average().getAsDouble();
		System.out.println(avg);
		
		// Boxing and Unboxing
		IntStream numStream = IntStream.range(0, 500);
		//numStream.collect(Collectors.toList()); // won't work
		
		//returns a stream of elements of this stream each boxed to Integer
		List<Integer> numbers = numStream.boxed().collect(Collectors.toList());
		numbers.forEach(System.out::println);
		
		// Unboxing example 
		Optional<Integer> number = numbers.stream().reduce((a,b) -> a + b);
		System.out.println(number.get());
		
		numbers.stream().mapToInt(Integer::intValue).forEach(System.out::println);
		
		int sum2 = numbers.stream().mapToInt(Integer::intValue).sum();
		System.out.println(sum2);
		
		// lesson 60 -- mapToObject
		List<RandomIds> randomIds = IntStream.range(10, 100)
			.mapToObj(i -> {
				return new RandomIds(i, ThreadLocalRandom.current().nextInt(10));
		}).collect(Collectors.toList());
		
		randomIds.forEach(System.out::println);
		
		IntStream.rangeClosed(0, 12).mapToLong(i -> (long) i).forEach(System.out::println);
		
		/* DoubleStream dStream = */ LongStream.rangeClosed(30, 60).mapToDouble(i -> (double) i).forEach(System.out::println);
		
		//joining
		//Stream.of("E", "F", "G", "H", "K").collect(Collectors.joining().finisher()
		String st111 = Stream.of("E", "F", "G", "H", "K").collect(Collectors.joining());
		System.out.println(st111);
		st111 = Stream.of("E", "F", "G", "H", "K").collect(Collectors.joining(","));
		System.out.println(st111);
		st111 = Stream.of("E", "F", "G", "H", "K").collect(Collectors.joining(",", "{", ")"));
		System.out.println(st111);
		
		String str = instructors.stream().map(Instructor::getName).collect(Collectors.joining(","));
		System.out.println(str);
		
		List<String> strList = List.of("1","2","3");
		
		 
		double avg1 = strList.stream()
				.mapToInt(p-> Integer.parseInt(p))
				.average().getAsDouble();
		System.out.println("##### : " + avg1);
		
		avg1 = strList.stream().
				collect(Collectors.averagingDouble(p-> Integer.parseInt(p)));
		System.out.println("##### : " + avg1);
		
		System.out.println("Stream.of(1,2,3,4,5,6).count() -- " + Stream.of(1,2,3,4,5,6).count());
		Long l = Stream.of(1,2,3,4,5,6).collect(Collectors.counting());
		System.out.println(l);
		
		long onlineInsCount = instructors.stream().filter(Instructor::isOnlineInstructor).count();
		System.out.println("count of online instructors -- " + onlineInsCount);
		
		Map<Boolean, List<String>> m = instructors.stream().collect(
				Collectors.groupingBy(
					Instructor::isOnlineInstructor, 
					Collectors.mapping(Instructor::getName, Collectors.toList())
				)
		);
		System.out.println("Group of online instrctors -- " + m);
		
		Map<Integer, Set<String>> m1 = instructors.stream().collect(
				Collectors.groupingBy(
						Instructor::getYrsOfExp, 
						Collectors.mapping(Instructor::getName, Collectors.toSet())
				)
		);
		System.out.println("Group based on yrs of exp -- " + m1);
		
		
		System.out.println("---------------");
		List<String> namesList = instructors.stream()
			.map(Instructor::getName)
			.collect(Collectors.toList());
		namesList.forEach(System.out::println);
		
		System.out.println("---------------");
		instructors.stream().collect(Collectors.mapping(Instructor::getName, Collectors.toList()));
		namesList.forEach(System.out::println);
		
		Object o;
		Objects obj;
		
		Optional<Instructor> o1 = instructors.stream().min((a1, a2) -> a1.getYrsOfExp() > a2.getYrsOfExp() ? 1 : 0);
		System.out.println("o1.get() -- " + o1.get());
		
		
		Optional<Instructor> res1 = instructors.stream()
		.collect(Collectors.minBy(Comparator.comparing(Instructor::getYrsOfExp)));
		System.out.println("res1.get() -- " + res1.get());
		
		Optional<Instructor> res2 = instructors.stream().collect(Collectors.maxBy(Comparator.comparing(Instructor::getYrsOfExp)));
		System.out.println("res2.get() -- " + res2.get());
		
		// 68 int summing averaging
		Integer isn = instructors.stream().collect(Collectors.summingInt(Instructor::getYrsOfExp));
		System.out.println("summingInt isn -- " + isn);
		
		Double isn2 = instructors.stream().collect(Collectors.averagingInt(Instructor::getYrsOfExp));
		System.out.println("summingInt isn -- " + isn2);
		
		//****** groupingBy ******
		// 68 groupingBy(classifier)
		List<String> strs = List.of("Syed", "Mike", "Delta", "Gene", "Rajeev", "Rozanny", "Packard");
		Map<Integer, List<String>> map1 = strs.stream().collect(Collectors.groupingBy(String::length));
		System.out.println("groupingBy length -- " + map1);
		
		Map<String, List<Instructor>>map2 = instructors.stream().collect(Collectors.groupingBy(Instructor::getGender));
		System.out.println("groupingBy gender -- " + map2);
		
		Map<String, List<String>> map3 = instructors.stream().collect(
				Collectors.groupingBy(
						Instructor::getGender, 
						Collectors.mapping(Instructor::getName, Collectors.toList())));
		System.out.println("groupingBy gender with only names -- " + map3);
		
		Map<Object, List<Instructor>> map4 = instructors.stream().collect(Collectors.groupingBy(instructor -> instructor.getYrsOfExp() > 10 ? "SENIOR" : "MID-LEVEL"));
		System.out.println("\ngroupingBy exp > 10 -- " + map4);
		
		// 70 groupingBy(classifier, downstream)
		Object map5 = strs.stream().collect(
				Collectors.groupingBy(
						String::length, 
						Collectors.filtering(s -> s.contains("e"), Collectors.toList())));
		System.out.println("\ngroupingBy set length, names with e -- " + map5);
		
		Map<Integer, Set<String>> map6 = strs.stream().collect(
				Collectors.groupingBy(
						String::length, 
						Collectors.filtering(s -> s.contains("e"), Collectors.toSet())));
		System.out.println("\ngroupingBy set length, names with e -- " + map6);
		
		Map<Object, List<Instructor>> map7 = instructors.stream().collect(
				Collectors.groupingBy(
						i -> i.getYrsOfExp() > 10 ? "SENIOR" : "MID-LEVEL",
						Collectors.filtering(Instructor::isOnlineInstructor, Collectors.toList())));
		System.out.println("\ngroupingBy SENIORITY, isOnline -- " + map7);
		
		
		// 71 groupingBy(classifier, mapFactory, downstream)
		Map<Integer, List<String>> map8 = strs.stream().collect(
				Collectors.groupingBy(
						String::length, 
						LinkedHashMap::new, 
						Collectors.filtering(s -> s.contains("e"), Collectors.toList())));
		System.out.println("\ngroupingBy  -- " + map8);
		System.out.println("\n");
		// 72 GroupingMinMaxAvgExample
		Map<Boolean, Optional<Instructor>> map9 = instructors.stream().collect(
				Collectors.groupingBy(
						Instructor::isOnlineInstructor, 
						Collectors.maxBy(Comparator.comparing(Instructor::getYrsOfExp))));
		map9.forEach((key, value) -> System.out.println("Key: " + key + ", value: " + value));
		
		// collecting and then
		System.out.println("\ncollecting and then ");
		Map<Boolean, Object> map10 = instructors.stream().collect(
				Collectors.groupingBy(
						Instructor::isOnlineInstructor,
						Collectors.collectingAndThen(
								Collectors.maxBy(
										Comparator.comparing(Instructor::getYrsOfExp)),
										Optional::get
								)
						)
		);
		map10.forEach((key, value) -> System.out.println("Key: " + key + ", value: " + value));
		
		Map<Boolean, Object> map11 = instructors.stream().collect(
				Collectors.groupingBy(
						Instructor::isOnlineInstructor, 
						Collectors.collectingAndThen(
								Collectors.maxBy(Comparator.comparing(Instructor::getYrsOfExp)), 
								Optional::get)
				)
		);
		
		// group by average years of exp of instructors who teaches online or not
		System.out.println("group by average years of exp of instructors who teaches online or not -- ");
		Map<Boolean, Double> map12 = instructors.stream().collect(
				Collectors.groupingBy(
						Instructor::isOnlineInstructor, 
						Collectors.averagingInt(Instructor::getYrsOfExp)));
		map12.forEach((key, value) -> System.out.println("Key: " + key + ", value: " + value));
		
		//drive a statistical summary from properties of grouped items
		System.out.println("drive a statistical summary from properties of grouped items --");
		Map<Boolean, IntSummaryStatistics> map13 = instructors.stream().collect(Collectors.groupingBy(
				Instructor::isOnlineInstructor, 
				Collectors.summarizingInt(Instructor::getYrsOfExp)));
		map13.forEach((key, value) -> System.out.println("Key: " + key + ", value: " + value));
		
		// 73 partitioningBy
		System.out.println("\npartitioningBy (exp > 10) --");
		Predicate<Instructor> expGreter10 = i -> i.getYrsOfExp() > 10;
		Map<Boolean, List<Instructor>> map14 = instructors.stream().collect(
				Collectors.partitioningBy(expGreter10));
		map14.forEach((key, value) -> System.out.println("Key: " + key + ", value: " + value));
		
		System.out.println("\npartitioningBy list by default (exp > 10) only names --");
		Map<Boolean, List<String>> map15 = instructors.stream().collect(
				Collectors.partitioningBy(expGreter10, Collectors.mapping(Instructor::getName, Collectors.toList())));
		map15.forEach((key, value) -> System.out.println("Key: " + key + ", value: " + value));
		
		System.out.println("\npartitioningBy SET (exp > 10) --");
		Map<Boolean, Set<Instructor>> map16 = instructors.stream().collect(
				Collectors.partitioningBy(expGreter10, Collectors.toSet()));
		map16.forEach((key, value) -> System.out.println("Key: " + key + ", value: " + value));

		System.out.println("\npartitioningBy SET (exp > 10) only names --");
		Map<Boolean, Set<String>> map17 = instructors.stream().collect(
				Collectors.partitioningBy(expGreter10, Collectors.mapping(Instructor::getName, Collectors.toSet())));
		map17.forEach((key, value) -> System.out.println("Key: " + key + ", value: " + value));
		
	}

}

class RandomIds {
	int id;
	int randomNumbers;
	
	public RandomIds(int id1, int randomNumbers1) {
		this.id = id1;
		this.randomNumbers = randomNumbers1;
	}

	@Override
	public String toString() {
		return "RandomIds [id=" + id + ", randomNumbers=" + randomNumbers + "]";
	}
}

interface StringChecker {
	boolean check(String s, String pref);
}
