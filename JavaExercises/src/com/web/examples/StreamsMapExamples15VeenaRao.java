package com.web.examples;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

//import com.modernjava.examples.Employee1;

public class StreamsMapExamples15VeenaRao {

	public static void main(String[] args) {
		
		//Creating list of Employee objects
		ExecutorService ei;
		Executors ex;

		List<Employee> empList = new ArrayList<>();
		empList.add(new Employee(1, "abc", 28, 123, "F", "HR", "Blore", 2020));
		empList.add(new Employee(2, "xyz", 29, 120, "F", "HR", "Hyderabad", 2015));
		empList.add(new Employee(3, "efg", 30, 115, "M", "HR", "Chennai", 2014));
		empList.add(new Employee(4, "def", 32, 125, "F", "HR", "Chennai", 2013));
		empList.add(new Employee(5, "ijk", 22, 150, "F", "FINANCE", "Noida", 2013));
		empList.add(new Employee(6, "mno", 37, 140, "M", "IT", "Gurugram", 2017));
		empList.add(new Employee(7, "uvw", 26, 130, "F", "IT", "Pune", 2016));
		empList.add(new Employee(8, "pqr", 23, 145, "M", "IT", "Trivandam", 2015));
		empList.add(new Employee(9, "stv", 28, 160, "F", "FINANCE", "Blore", 2010));
		empList.add(new Employee(10, "klm", 21, 100, "M", "IT", "Pune", 2021));
		empList.add(new Employee(11, "cde", 28, 120, "F", "FINANCE", "Blore", 2010));
		empList.add(new Employee(12, "hig", 31, 130, "M", "IT", "Pune", 2021));
		
		
		// 1. Group the Employees by city.
		Map<String, List<Employee>> map = empList.stream().collect(Collectors.groupingBy(Employee::getCity, Collectors.toList()));
		Map<String, List<String>> map1 = empList.stream().collect(Collectors.groupingBy(Employee::getCity, Collectors.mapping(Employee::getName, Collectors.toList())));
		System.out.println("\n1. Group the Employees by city.");
		map1.forEach((k,v) -> System.out.println("key: " + k + ", val: " + v));
		
		// 2. Group the Employees by age.
		Map<Integer, List<String>> map02 = empList.stream().collect(Collectors.groupingBy(Employee::getAge, Collectors.mapping(Employee::getName, Collectors.toList())));
		System.out.println("\n2. Group the Employees by age.");
		map02.forEach((k,v) -> System.out.println("key: " + k + ", val: " + v));
		
		// 3. Find the count of male and female employees present in the organization.
		Map<String, Long> map03 = empList.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
		System.out.println("\n3. Find the count of male and female employees present in the organization.");
		map03.forEach((k,v) -> System.out.println("key: " + k + ", val: " + v));
				
				
		// 4. Print the names of all departments in the organization.
		List<String> list04 = empList.stream().map(Employee::getDeptName).distinct().toList();
		System.out.println("\n4. Print the names of all departments in the organization.");
		System.out.println(list04);
		
		// 5. Print employee details whose age is greater than 28.
		List<Employee> list05 = empList.stream().filter(e -> e.getAge() > 28).toList();
		List<String> listNames05 = empList.stream().filter(e -> e.getAge() > 28).map(Employee::getName).toList();
		System.out.println("\n5. Print employee details whose age is greater than 28.");
		System.out.println(/* list05 */listNames05);
		
		// 6. Find maximum age of employee.
		OptionalInt int06 = empList.stream().mapToInt(Employee::getAge).max();
		System.out.println("\n6. Find maximum age of employee.");
		System.out.println(int06.getAsInt());
		
		// 7. Print Average age of Male and Female Employees.
		Map<String, Double> map07 = empList.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingInt(Employee::getAge)));
		System.out.println("\n7. Print Average age of Male and Female Employees.");
		map07.forEach((k,v) -> System.out.println("key: " + k + ", val: " + v));
		
		// 8. Print the number of employees in each department.
		Map<String, Long> map08 = empList.stream().collect(Collectors.groupingBy(Employee::getDeptName, Collectors.counting()));
		System.out.println("\n8. Print the number of employees in each department.");
		map08.forEach((k,v) -> System.out.println("key: " + k + ", val: " + v));
		
		// 9. Find oldest employee.
		System.out.println("\n9. Find oldest employee.");
		//FAILED empList.stream().collect(Collectors.minBy(Employee::getYearOfJoining)).toList();
		Optional<Employee> emp09 = empList.stream().max(Comparator.comparingInt(Employee::getYearOfJoining));
		System.out.println(emp09.get());
		
		System.out.println("\n9.1 Find oldest employee in the organization.");
		Optional<Employee> emp0901 = empList.stream().min(Comparator.comparingInt(Employee::getYearOfJoining));
		System.out.println(emp0901.get()); 
		
		// 10. Find youngest female employee.
		System.out.println("\n10. Find youngest female employee.");
		Optional<Employee> emp10 = empList.stream().filter(e -> e.getGender() == "F").min(Comparator.comparingInt(Employee::getAge));
		System.out.println(emp10.get());
		
		// 11. Find employees whose age is greater than 30 and less than 30.
		System.out.println("\n11. Find employees whose age is greater than 30 and less than 30.");
		Map<Boolean, List<Employee>> map11 = empList.stream().collect(Collectors.partitioningBy(e -> e.getAge() > 30));
		map11.forEach((k,v) -> System.out.println("key: " + k + ", val: " + v));
		 
		// Comparator.comparingInt(e -> e.getAge() > 30)
		//empList.stream().collect(Collectors.partitioningBy(null) //TODO
		
		
		
		
		// 12. Find the department name which has the highest number of employees.
		System.out.println("\n12. Find the department name which has the highest number of employees.");
		Map<String, Long> var12 = empList.stream().collect(Collectors.groupingBy(Employee::getDeptName, Collectors.counting()));
		Entry<String, Long> var1212 = var12.entrySet().stream().max(Map.Entry.comparingByValue()).get();
		System.out.println("key: " + var1212.getKey() + ", value: " + var1212.getValue());
		
		// 13. Find if there any employees from HR Department.
		System.out.println("\n13. Find if there any employees from HR Department.");
		Optional<Employee> var13 = empList.stream().filter(e -> e.getDeptName().equalsIgnoreCase("HR")).findAny();
		System.out.println(var13.get());
		
		// 14. Find the department names that these employees work for, where the number of employees in the department is over 3.
		System.out.println("\n14. Find the department names that these employees work for, where the number of employees in the department is over 3.");
		empList.stream().collect(Collectors.groupingBy(Employee::getDeptName, Collectors.counting()))
			.entrySet().stream().filter(entry -> entry.getValue() > 3).forEach(System.out::println);
		
		// 15 . Find distinct department names that employees work for.
		System.out.println("\n15 . Find distinct department names that employees work for.");
		empList.stream().map(Employee::getDeptName).distinct().forEach(System.out::println);
		
//		// 16. Find all employees who lives in ‘Blore’ city, sort them by their name and print the names of employees.
		System.out.println("\n16. Find all employees who lives in ‘Blore’ city, sort them by their name and print the names of employees.");
		/* List<String> var16 = */ empList.stream().filter(e -> e.getCity().equalsIgnoreCase("Blore"))
				//.sorted((e1,e2) -> e1.getName().compareTo(e2.getName()))
				.sorted(Comparator.comparing(Employee::getName))
				.map(Employee::getName).forEach(System.out::println);
				//.collect(Collectors.toList());
		
		// 17. No of employees in the organisation.
		System.out.println("\n17. No of employees in the organisation.");
		long var17 = empList.stream().count(); System.out.println(var17);
		
		// 18. Find employee count in every department
		System.out.println("\n18. Find employee count in every department");
		Map<String, Long> var18 = empList.stream().collect(Collectors.groupingBy(Employee::getDeptName, Collectors.counting()));
		var18.forEach((k, v) -> System.out.println("key: " + k + ", value: " + v));
		
		// 19. Find the department which has the highest number of employees.
		System.out.println("\n19. Find the department which has the highest number of employees.");
		Optional<Entry<String, Long>> var19 = empList.stream().collect(Collectors.groupingBy(Employee::getDeptName, Collectors.counting()))
			.entrySet().stream().max(Map.Entry.comparingByValue());
		System.out.println(var19.get());
		
		// 20. Sorting a Stream by age and name fields.
		System.out.println("\n20. Sorting a Stream by age and name fields.");
		Comparator<Employee> c1 = Comparator.comparing(Employee::getName);
		Comparator<Employee> c2 = Comparator.comparing(Employee::getAge);
		empList.stream().sorted(c1.thenComparing(c2)).forEach(System.out::println);
		
		// 21. Highest experienced employees in the organization.
		System.out.println("\n21. Highest experienced employees in the organization.");
		Optional<Employee> var21 = empList.stream().sorted(Comparator.comparing(Employee::getYearOfJoining)).findFirst();
		System.out.println(var21.get());
		
		// 22. Print average and total salary of the organization.
		System.out.println("\n22. Print average and total salary of the organization.");
		DoubleSummaryStatistics var22 = empList.stream().collect(Collectors.summarizingDouble(Employee::getSalary));
		System.out.println("Organization average salary - " + var22.getAverage());
		System.out.println("Organization total salary - " + var22.getSum());
		
		// 23. Print Average salary of each department.
		System.out.println("\n23. Print Average salary of each department.");
		Map<String, Double> var23 = empList.stream()
				.collect(Collectors.groupingBy(
						Employee::getDeptName, 
						Collectors.averagingDouble(Employee::getSalary)
				));
		var23.forEach((k,v) -> System.out.println("Department: " + k + ", Average salary: " + v));
		
		// 24. Find Highest salary in the organisation.
		System.out.println("\n24. Find Highest salary in the organisation.");
		Optional<Employee> var24 = empList.stream().sorted(Comparator.comparingDouble(Employee::getSalary).reversed()).findFirst();
		System.out.println(var24.get());
		
		// 26. Nth Highest salary. 
		System.out.println("\n26. Nth Highest salary."); int n = 5;
		Optional<Employee> var26 = empList.stream()
				.sorted(Comparator.comparing(Employee::getSalary))
				.skip(n-1)
				.findFirst();
		System.out.println(var26.get());
		
		// 27. Find highest paid salary in the organisation based on gender.
		System.out.println("\n27. Find highest paid salary in the organisation based on gender.");
		empList.stream().collect(Collectors.groupingBy(
				Employee::getGender,
				Collectors.maxBy(Comparator.comparing(Employee::getSalary))
		));
		
		// 29. Sort the employees salary in the organisation in ascending order 
		System.out.println("\n29. Sort the employees salary in the organisation in ascending order");
		List<Employee> var29 = empList.stream().sorted(Comparator.comparing(Employee::getSalary)).toList();
		var29.stream().forEach(System.out::println);
		
		// 31. Highest salary based on department. 
		System.out.println("\n31. Highest salary based on department.");
		Map<String, Employee> map31 = empList.stream().collect(Collectors.groupingBy(
				Employee::getDeptName, 
				//Collectors.maxBy(Comparator.comparing(Employee::getSalary))
				Collectors.collectingAndThen(
						Collectors.maxBy(Comparator.comparing(Employee::getSalary)), 
						Optional::get)
				)
		);
		map31.forEach((k, v) -> System.out.println("key: " + k + ", value: " + v));
		
		
		
		// 32. Print list of employee’s second highest salary record based on department
		System.out.println("\n32. Print list of employee’s second highest salary record based on department");
		Map<String, Object> var32 = empList.stream().collect(Collectors.groupingBy(
				Employee::getDeptName,
				Collectors.collectingAndThen(
						Collectors.toList(), 
						list -> list.stream()
								.sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
								.skip(1)
								.findFirst())
		));
		var32.forEach((k, v) -> System.out.println("key: " + k + ", value: " + v));
		
		// 33. Sort the employees salary in each department in ascending order
		System.out.println("\n33. Sort the employees salary in each department in ascending order");
		Map<String, Object> var33 = empList.stream().collect(Collectors.groupingBy(
				Employee::getDeptName,
				Collectors.collectingAndThen(
						Collectors.toList(), 
						list -> list.stream().sorted(Comparator.comparingDouble(Employee::getSalary)).toList()
				)
		));
		var33.forEach((k,v) -> System.out.println("Key: " + k + ", Val: " + v));
		
		System.out.println("\n");
		Map<String, Object> map33 = empList.stream().collect(Collectors.groupingBy(
				Employee::getDeptName,
				Collectors.collectingAndThen(
						Collectors.toList(), 
						list -> list.stream()
								.sorted(Comparator.comparingDouble(Employee::getSalary))
								.map(e -> "Employee Name: " + e.getName() + ", salary: " + e.getSalary())
								.toList()
				)
		));
		map33.forEach((k,v) -> System.out.println("Key: " + k + ", Val: " + v));
		
		// 34. Sort the employees salary in each department in descending order.
		System.out.println("\n34. Sort the employees salary in each department in descending order.");
		Map<String, Object> map34 = empList.stream().collect(Collectors.groupingBy(
				Employee::getDeptName,
				Collectors.collectingAndThen(
						Collectors.toList(), 
						list -> list.stream()
								.sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
								.map(e -> "EName: " + e.getName() + ", salary: " + e.getSalary())
								.toList()
				)
		));
		map34.forEach((k,v) -> System.out.println("Key: " + k + ", Val: " + v));
		
		
		/*Map<Object, Object> map12 = employees.stream().collect(Collectors.groupingBy(
				Employee1::getDepartment,
				Collectors.collectingAndThen(
						Collectors.averagingDouble(Employee1::getSalary),
						avgSalary -> avgSalary > 3000)))
				.entrySet().stream()
				.filter(Map.Entry::getValue)
				.collect(Collectors.toMap(
						Map.Entry::getKey, 
						entry -> employees.stream()
									.filter(e -> e.getDepartment().equals(entry.getKey()))
									//.map(Employee1::getName)
									.collect(Collectors.toList())
				)
		);*/
		
		empList.stream().collect(Collectors.groupingBy(
				Employee::getDeptName,
				Collectors.collectingAndThen(
						Collectors.averagingDouble(Employee::getSalary), 
						avgSalary -> avgSalary > 3000))
		).entrySet().stream()
			.filter(Map.Entry::getValue)
			.collect(Collectors.toMap(
					Map.Entry::getKey, 
					entry -> empList.stream()
						.filter(e -> e.getDeptName().equals(entry.getKey()))
						.collect(Collectors.toList())
		));
		
		Map<String, List<Employee>> map41 = empList.stream().collect(Collectors.groupingBy(Employee::getDeptName));
		map41.entrySet().stream()
			.filter(entry -> 
					entry.getValue().stream()
							.mapToDouble(Employee::getSalary).average().getAsDouble() > 3000)
			.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
		//System.out.println("\n\nDeparments whose average salary is greater than 3000 : \n" + map41);
		map41.forEach((dept, empList1) -> {
	            System.out.println(dept + ":");
	            empList1.forEach(emp -> System.out.println("  " + emp.getName()));
	    });
		
	}

}

class Employee {
    private int id;
    private String name;
    private int age;
    private long salary;
    private String gender;
    private String deptName;
    private String city;
    private int yearOfJoining;

    public Employee(int id, String name, int age, long salary, String gender, 
                    String deptName, String city, int yearOfJoining) {
         this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.gender = gender;
        this.deptName = deptName;
        this.city = city;
        this.yearOfJoining = yearOfJoining;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", gender='" + gender + '\'' +
                ", deptName='" + deptName + '\'' +
                ", city='" + city + '\'' +
                ", yearOfJoining='" + yearOfJoining + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getYearOfJoining() {
        return yearOfJoining;
    }

    public void setYearOfJoining(int yearOfJoining) {
        this.yearOfJoining = yearOfJoining;
    }
}


