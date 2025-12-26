package com.hiramkamau.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

//https://stackabuse.com/guide-to-java-8-collectors-groupingby/
public class GroupingByExamples {

	public static void main(String[] args) {
		List<Student> students = Arrays.asList(
			    new Student("Math", "John", "Smith", "Miami", 19),
			    new Student("Programming", "Mike", "Miles", "New York", 21),
			    new Student("Math", "Michael", "Peterson", "New York", 20),
			    new Student("Math", "James", "Robertson", "Miami", 20),
			    new Student("Programming", "Kyle", "Miller", "Pittsburgh", 22),
			    new Student("Science", "Marco", "D'Alessandro", "Pittsburgh", 20),
			    new Student("Science", "Pier", "Thompson", "Miami", 21)
		);
		
		Map<String, List<String>> namesByCity = students.stream().collect(Collectors.groupingBy(
				Student::getCity, // Function classifier
				TreeMap::new, // Supplier mapFactory
				Collectors.mapping(Student::getName, Collectors.toList()) // Collector downstream
		));
		System.out.println(namesByCity.getClass().getSimpleName());
		//namesByCity.forEach((k,v) -> System.out.println("key: " + k + ", val: " + v));
		System.out.println(namesByCity);
		
		// Group the student by Subject where average age is greater than 20
		
		
		Map<String, Double> var1 = students.stream()
				.collect(Collectors.groupingBy(
						Student::getCity, 
						TreeMap::new,
						Collectors.averagingDouble(Student::getAge)
		));
		//System.out.println(var1);
		
		Map<String, List<String>> var3 = students
				.stream()
				.collect(Collectors.groupingBy(
						Student::getCity,
						Collectors.mapping(Student::getName, Collectors.toList()))
				);
		System.out.println(var3);
		System.out.println(var3.getClass().getSimpleName());

	}

}

class Student {
    private String subject;
    private String name;
    private String surname;
    private String city;
    private int age;

    // Constructors, Getters, Setters, toString()    
	public Student(String subject, String name, String surname, String city, int age) {
		super();
		this.subject = subject;
		this.name = name;
		this.surname = surname;
		this.city = city;
		this.age = age;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}