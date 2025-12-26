package com.modernjava.examples;

import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.stream.Collectors;

public class Test {

	public static void main(String[] args) {
//		Get department-wise employee names where the department average salary is greater than 3000.
		Employee1 e1 = new Employee1(1, "E1", 2000, "Dept1");
		Employee1 e2 = new Employee1(2, "E2", 4000, "Dept2");
		Employee1 e3 = new Employee1(3, "E3", 6000, "Dept3");
		Employee1 e11 = new Employee1(11, "E4", 3000, "Dept1");
		Employee1 e22 = new Employee1(22, "E5", 5000, "Dept2");
		Employee1 e33 = new Employee1(33, "E6", 7000, "Dept3");
		List<Employee1> employees = List.of(e1, e2, e3, e11, e22, e33);

		
//		Map<String, Object> deptMap = employees.stream().collect(
//		Collectors.groupingBy(
//				Employee1::getDepartment,
//				Collectors.collectingAndThen(
//						Collectors.averagingDouble(Employee1::getSalary),
//						Collectors.filtering(avgSalary -> avgSalary > 3000, Collectors.toList())
//				))); // WORKING
//		System.out.println("\ndepartment-wise employee names where the department average salary is greater than 3000");
//		deptMap.forEach((k,v) -> System.out.println("key: " + k + ", value: " + v));
//		key: Dept2, value: true
//		key: Dept1, value: false
//		key: Dept3, value: true

		
		Map<String, Object> map11 = employees.stream().collect(Collectors.groupingBy(
				Employee1::getDepartment,
				Collectors.collectingAndThen(
						Collectors.averagingDouble(Employee1::getSalary), 
						avgSalary -> avgSalary > 3000)));
		//map11.forEach((k,v) -> System.out.println("key: " + k + ", value: " + v));
		
		Map<Object, Object> map12 = employees.stream().collect(Collectors.groupingBy(
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
		);
		map12.forEach((k,v) -> System.out.println("key: " + k + ", value: " + v));
		
		Map<Object, Object> map15 = employees.stream().collect(Collectors.groupingBy(Employee1::getDepartment))
			.entrySet().stream()
				.filter(entry -> entry.getValue().stream().mapToDouble(Employee1::getSalary).average().orElse(0) > 3000)
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
		System.out.println("\nDepartment-wise employee list whose average salary is greater than 3000");
		map12.forEach((k,v) -> System.out.println("key: " + k + ", value: " + v));
		
//		Map<Object, Object> map12 = employees.stream().collect(Collectors.groupingBy(
//				Employee1::getDepartment,
//				Collectors.collectingAndThen(
//						Collectors.averagingDouble(Employee1::getSalary),
//						Collectors.filtering(avgSalary -> avgSalary > 3000 ))));
		
		
//		empList.stream().collect(Collectors.groupingBy(
//				Employee1::getDepartment, 
//				Collectors.collectingAndThen(Collectors.averagingInt(Employee1::getSalary), Collectors.toList())));
		
	}

}

// SQL query
//select * from employee1 e1 where e1.departmentId = ed1.departmentId and ed1.avg_salary > 3000
//(select departmentId, avg(salary) as avg_salary from employee1 
//group_by departmentId) as ed1)
//group_by departmentId;


//Employee1 Entity:
//id, name, salary, department

class Employee1 {
	private int id;
	private String name;
	private int salary;
	private String department;
	
	public Employee1(int id, String name, int salary, String department) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.department = department;
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
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Employee1 [id=" + id + ", name=" + name + ", salary=" + salary + ", department=" + department + "]";
	}
		
}