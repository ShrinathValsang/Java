package com.modernjava.examples;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class ComparisonOfStreamAndIterators {

	public static void main(String[] args) {
		ArrayList<String> strings = new ArrayList<>();
		for (int i = 0; i < 100000; i++) {
			strings.add("String" + i);
		}
		
		//List<String> strings2 = new ArrayList<>(strings);
		List<String> strings2 = new ArrayList<>();
		for (int i = 0; i < 100000; i++) {
			strings2.add("String" + i);
		}
		
		long start = System.currentTimeMillis();
		Iterator<String> it = strings.iterator();
		while (it.hasNext()) {
			String st = it.next();
			if (st.contains("0")) it.remove();
		}
		
		long elapsed = System.currentTimeMillis() - start;
		System.out.println(strings);
//		System.out.println("AFTER ITERATOR strings -- " + strings);
//		System.out.println("AFTER ITERATOR strings2 -- " + strings2);
		
		System.out.println("Iterator time taken -- " + elapsed); // Iterator time taken -- 23
		
		//Collections.copy(null, null);
		ArrayList<String> clonedStrings = (ArrayList<String>) strings.clone();

		long start1 = System.currentTimeMillis();
		List<String> list = strings2.stream().filter(s -> !s.contains("0")).collect(Collectors.toList());
		long elapsed1 = System.currentTimeMillis() - start1;
		System.out.println(list);
		System.out.println("Stream time taken -- " + elapsed1); // Stream time taken -- 14
		//System.out.println(strings);
		
//		Iterator time taken -- 368
//		Stream time taken -- 17
		
		
		ArrayList<Employee> employeeList = new ArrayList<>(); 
		employeeList.add(new Employee(1l, "adam", new Date(1982, 02, 12)));
		 
		ArrayList<Employee> employeeListClone = new ArrayList<>(); 
		Collections.copy(employeeList, employeeListClone);
		
		System.out.println("before change employeeList -- " + employeeList); 
		System.out.println("before change employeeListClone -- " + employeeListClone); 
		//Modify the list item in cloned list - it should affect the original list item
//		employeeListClone.get(0).setId(2l);
//		employeeListClone.get(0).setName("brian");
//		employeeListClone.get(0).getDob().setDate(13);
		
		employeeList.get(0).setId(2l);
		employeeList.get(0).setName("brian");
		employeeList.get(0).getDob().setDate(13);
		System.out.println("after change -- " + employeeList);
		 
//		System.out.println(employeeList); 
		System.out.println("employeeListClone --" + employeeListClone);   
	}

}

class Employee implements Cloneable {

    private Long id;
    private String name;
    private Date dob;		//Mutable field
    
	public Employee(Long id, String name, Date dob) {
        super();
        this.id = id;
        this.name = name;
        this.dob = dob;
    }
	
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

    public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	//Getters and setters
    @Override
    protected Object clone() throws CloneNotSupportedException {
        Employee clone = null;
        try  {
            clone = (Employee) super.clone();
            //Copy new date object to cloned method
            clone.setDob((Date) this.getDob().clone());
        }
        catch (CloneNotSupportedException e)  {
            throw new RuntimeException(e);
        }
        return clone;
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + ", dob=" + dob + "]";
    }
}
