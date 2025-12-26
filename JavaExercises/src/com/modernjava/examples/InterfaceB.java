package com.modernjava.examples;

public interface InterfaceB extends InterfaceA {
	default void sumB(int num1, int num2) {
		System.out.println("InterfaceB - " + (num1 + num2));
	}

	default void sumA(int num1, int num2) {
		System.out.println("InterfaceB - " + (num1 + num2));
	}

}
