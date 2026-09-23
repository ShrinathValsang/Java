package com.test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Employee e1 = new Employee(1234, "Employee1");
        Employee e2 = new Employee(1234, "Employee1");

        Set<Employee> set = new HashSet<>();
        set.add(e1);
        System.out.println("After adding e1 only -- " + set);
        set.add(e2);
        System.out.println("After adding e2 -- " + set);

        System.out.println();
        Map<Employee, String> map = new HashMap<>();
        map.put(e1, "xyz");
        System.out.println("After adding e1 only -- " + map.toString());
        map.put(e2, "xyz");
        System.out.println("After adding e2 -- " + map.toString());

        e2.setEmpname("asldkfj");
        System.out.println("After updating e2 -- " + map.toString());

        System.out.println("map.get(e1): " + map.get(e1));
        System.out.println("map.get(e2): " + map.get(e2));
    }

    public static String getLongestSubstringMy(String s) {
        int startInd = 0, left = 0, maxl = 0;
        Set<Character> seen = new HashSet<>();

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);

            if (seen.contains(c)) {
                startInd = left;
                seen.remove(c);
            }
            seen.add(c);

            maxl = Math.max(left - right + 1, maxl);
        }

        return s.substring(startInd, startInd + maxl);
    }
}

class Employee {
    int empid;
    String empname;

    public Employee(){};
    public Employee(int id, String name){
        this.empid = id;
        this.empname = name;
    };

    public String getEmpname() {
        return empname;
    }

    public void setEmpname(String empname) {
        this.empname = empname;
    }

    public int getEmpid() {
        return empid;
    }

    public void setEmpid(int empid) {
        this.empid = empid;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empid=" + empid +
                ", empname='" + empname + '\'' +
                '}';
    }
}
