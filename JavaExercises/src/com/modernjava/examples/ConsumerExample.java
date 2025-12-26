package com.modernjava.examples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.IntStream;

public class ConsumerExample {

	public static void main(String[] args) {
		Consumer<Integer> sqare = x -> System.out.println(x*x);
		
		Predicate<Integer> isPerfectSquare = x -> {
			int sqrt = (int) Math.sqrt(x);
			return x == (sqrt * sqrt);
		};
		
		//IntStream.rangeClosed(1, 100).forEach(x -> isPerfectSquare.test(x));
		//IntStream.rangeClosed(1, 100).forEach(x -> System.out.println(x + " isPerfectSquare()? - " + isPerfectSquare.test(x)));
		IntStream.rangeClosed(1, 100)
			.filter(x -> isPerfectSquare.test(x) == true)
			.forEach(x -> System.out.println(x + " is a Perfect Square."));
		
		Consumer<Integer> sqrtAndRoot = x -> {
			System.out.println("Math.sqrt(" + x + "): " + Math.sqrt(x) + ", SquareOf(" + x + "): " + x * x);
			System.out.println("Is " + x + " a perfect square?: " + isPerfectSquare.test(x));
		};
		
		for (int x = 0; x < 10; x++) {
			sqrtAndRoot.accept(x);
		}
		
		
		// Instructors
		List<Instructor> instructors = getInstructors();
		
		Consumer<Instructor> c1 = instr -> System.out.println(instr.toString());
		instructors.forEach(c1);
		
		Consumer<Instructor> c2 = i -> System.out.println(i.getName());
		instructors.forEach(c2);
		
		instructors.forEach(c1.andThen(c2));
		
//		Consumer<Instructor> c3 = x -> {
//			if x.ge
//		};
		
		BiConsumer<String, String> bc1 = (name, gender) -> System.out.println("name is " + name + " and gender is " + gender);
		instructors.forEach(i -> bc1.accept(i.getName(), i.getGender()));
		
		BiConsumer<String, List<String>> bc2 = (name, courses) -> System.out.println("name is " + name + " and courses are " + courses);
		instructors.forEach(i -> bc2.accept(i.getName(), i.getCourses()));
		
		instructors.forEach(i -> {
			if (i.getGender() == "F") {
				bc1.accept(i.getName(), i.getGender());
			}
		});
		
		System.out.println("Instructors with 10+  yrs of experience --");
		Predicate<Integer> pexp = i -> i > 10;
		Predicate<Integer> p22 = i -> i % 2 == 0;
		instructors.forEach(instr -> {
			if (pexp.and(p22).test(instr.getYrsOfExp()))
				System.out.println(instr.getName() + " has more than " + instr.getYrsOfExp() + " of experience.");
		});
		
		System.out.println("Online instructors with 5 yrs of experience --");
		Predicate<Instructor> p1 = i -> i.getYrsOfExp() > 5;
		Predicate<Instructor> p2 = i -> i.isOnlineInstructor();
		Predicate<Instructor> p3 = Instructor::isOnlineInstructor;
		instructors.forEach(i -> {
			if (p1.and(p2).test(i))
				//System.out.println(i.getName());
				bc1.accept(i.getName(), i.getGender());
		});
		
		BiPredicate<Boolean, Integer> bp1 = (online, yrsOfExp) -> online == true && yrsOfExp > 1;
		
		instructors.forEach(i -> {
			if (bp1.test(i.isOnlineInstructor(), i.getYrsOfExp()))
				System.out.println(i.toString());;
		});
		
		Function<Integer, Double> sqrt = x -> Math.sqrt(x);
		Function<Integer, Double> sqrt1 = Math::sqrt;
		
		for (int n = 0; n < 11; n++) {
			System.out.println("Square root of " + n + " is - " + sqrt.apply(n));	
		}
		
		Function<String, String> lowercase = s -> s.toLowerCase();
		Function<String, String> concat = s -> s.concat(" IN JAVA");
		
		System.out.println(lowercase.apply("PROGRAMMING"));
		System.out.println("lowercase.andThen(concat) -- " + lowercase.andThen(concat).apply("PROGRAMMING"));
		System.out.println("lowercase.compose(concat) -- " + lowercase.compose(concat).apply("PROGRAMMING"));
		
		System.out.println("concat.compose(lowercase) -- " + concat.compose(lowercase).apply("PROGRAMMING"));
		
		
		Function<List<Instructor>, Map<String, Integer>> mapFunction = (instructors1 -> {
			Map<String, Integer> map = new HashMap<>();
			
			instructors1.forEach(instructor -> {
				map.put(instructor.getName(), instructor.getYrsOfExp());
			});
			
			return map;
		});
		
		System.out.println(mapFunction.apply(instructors));
		System.out.println("List of online instructors: ");
		
		Predicate<Instructor> p4 = i -> i.isOnlineInstructor() == true;
		Function<List<Instructor>, Map<String, Integer>> mapf2 = (instructors2 -> {
			Map<String, Integer> map = new HashMap<>();
			
			instructors2.forEach(ins -> {
				if (p4.test(ins)) {
					map.put(ins.getName(), ins.getYrsOfExp()); 
				}
			});
			
			return map;
		});
		System.out.println(mapf2.apply(instructors));
		
		BiFunction<List<Instructor>, Predicate<Instructor>, Map<String, Integer>> bifun = (instructors4, predicate) -> {
			Map<String, Integer> map = new HashMap<>();
			instructors4.forEach(instructor -> {
				if (predicate.test(instructor)) {
					map.put(instructor.getName(), instructor.getYrsOfExp());
				}
			});
			return map;
		};
		
		System.out.println("BiFunction<List<Instructor>, Predicate<Instructor>, Map<String, Integer>> bifun \n" 
		+ bifun.apply(instructors, p3));
		
		BinaryOperator<Integer> binOpAdd = (a, b) -> a + b;
		System.out.println("binOpAdd.apply(2, 4): " + binOpAdd.apply(2, 4));
		
		Comparator<Integer> comp = (a, b) -> a.compareTo(b);
		
		BinaryOperator<Integer> binOp = null;
		System.out.println("BinaryOperator.maxBy(comp).apply(4, 5) -- " 
				+ BinaryOperator.maxBy(comp).apply(4, 5));

		System.out.println("BinaryOperator.minBy(comp).apply(4, 5) -- " 
				+ BinaryOperator.minBy(comp).apply(4, 5));
		
		UnaryOperator<Integer> unaryOp = i -> i*10;
		UnaryOperator<Integer> unaryOpIdentity =  UnaryOperator.identity();
		System.out.println("UnaryOperator.identity() --" + UnaryOperator.identity());
		for (int i=0; i <11; i++) {
			System.out.println(unaryOpIdentity.apply(i) + " multiplied by 10 is equal to " + unaryOp.apply(i));
		}
		
		//Supplier<Integer> sup = () -> (int) Math.random() * 1000; returns always zero!!
		Supplier<Integer> sup1 = () -> (int) (Math.random() * 1000);
		for (int i=1; i <= 10; i++) {
			System.out.println(sup1.get());
		}
		
		// Constructor reference
		InstructorFactory insf = Instructor::new;
		Instructor i1 = insf.getInstructor("Roger", 11, "M", true, Arrays.asList("JavaScript", "BootStrap", "Hadoop"));
		System.out.println(i1);
		
		
		
	} // end of main method
	
	interface InstructorFactory {
		Instructor getInstructor(String name1, int exp, String gender1, boolean isOnlineInstructor1, List<String> asList);
	}
	
	
	
	
	public static List<Instructor> getInstructors() {
		List<Instructor> instructors = new ArrayList<>();
		instructors.add(new Instructor("Mike", 10, "M", false, Arrays.asList("Java", "Python", "C++")));
		instructors.add(new Instructor("Liz", 9, "F", true, Arrays.asList("ReactJS", "Python", "JavaScript")));
		instructors.add(new Instructor("Nigella", 14, "F", false, Arrays.asList("Product development", "Humans are not resources")));
		instructors.add(new Instructor("Syed", 15, "M", true, Arrays.asList("Java 8", "CI/CD", "Kubernetes")));
		instructors.add(new Instructor("Kathy", 16, "F", true, Arrays.asList("Java 8", "Spring Boot", "Docker")));
		return instructors;
	}
	
	public static void makeSound(String sound) {
		LearnToSpeak learner = s -> System.out.println(s);
		
		LearnToSpeak learner2 = System.out::println;
		
		//DuckHelper.teacher(sound, learner);
	}
}

interface LearnToSpeak {
	void speak(String sound);
}

class Instructor {
	private String name;
	private int yrsOfExp;
	private String gender;
	private boolean isOnlineInstructor;
	private List<String> courses;
	

	public Instructor(String name1, int exp, String gender1, boolean isOnlineInstructor1, List<String> asList) {
		this.name = name1;
		this.yrsOfExp = exp;
		this.gender = gender1;
		this.isOnlineInstructor = isOnlineInstructor1;
		this.courses = asList;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getYrsOfExp() {
		return yrsOfExp;
	}
	
	public void setYrsOfExp(int yrsOfExp) {
		this.yrsOfExp = yrsOfExp;
	}
	
	public String getGender() {
		return gender;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public boolean isOnlineInstructor() {
		return isOnlineInstructor;
	}

	public void setOnlineInstructor(boolean isOnlineInstructor) {
		this.isOnlineInstructor = isOnlineInstructor;
	}

	public List<String> getCourses() {
		return courses;
	}
	
	public void setCourses(List<String> courses) {
		this.courses = courses;
	}


	@Override
	public String toString() {
		return "Instructor [name=" + name + ", yrsOfExp=" + yrsOfExp + ", gender=" + gender + ", courses=" + courses
				+ "]";
	}
}
