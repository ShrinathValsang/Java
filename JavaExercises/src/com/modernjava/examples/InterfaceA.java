package com.modernjava.examples;

public interface InterfaceA {
	default void sumA(int num1, int num2) {
		System.out.println("InterfaceA - " + (num1 + num2));
	}

}
