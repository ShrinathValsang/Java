package com.modernjava.examples;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class DefaultMethods implements InterfaceA, InterfaceB, InterfaceC{

	public static void main(String[] args) {
		List<String> names = Arrays.asList("Mike", "Jaheer", "Youth", "Marissa", "Gouthami");
		System.out.println("names -- " + names);	
//		Collections.sort(names);
//		System.out.println("names -- " + names);
		
		names.sort(Comparator.naturalOrder());
		System.out.println("names naaturalOrder -- " + names);
		
		Calculator sum = (num1, num2) -> num1 + num2;
		System.out.println("sum.operation(9, 100) => " + sum.operation(9, 100));
		
		Calculator divide = (num1, num2) -> num1 / num2;
		System.out.println("divide.operation(100, 9) => " + divide.operation(100, 9));
		
		// 84. Multiple inheritance
		DefaultMethods dm = new DefaultMethods();
		dm.sumA(4, 8); //		InterfaceB - 12 resolves to child impl 
		dm.sumB(5, 9); //		InterfaceB - 14
		dm.sumC(7, 3); //		InterfaceC - 10
		
		Date dateSql = new Date(System.currentTimeMillis());
//		LocalDate localDate = dateSql.toLocalDate();
//		System.out.println(localDate);

		
	}

}

//interface A {
//	default void sum(int num1, int num2) {
//		System.out.println("InterfaceA - " + num1 + num2);
//	}
//}
//
//interface B {
//	default void sum(int num1, int num2) {
//		System.out.println("InterfaceB - " + num1 + num2);
//	}
//}
//
//interface C {
//	default void sum(int num1, int num2) {
//		System.out.println("InterfaceC - " + num1 + num2);
//	}
//}
