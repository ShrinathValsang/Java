package com.modernjava.examples;

@FunctionalInterface
public interface Calculator {
	double operation(int num1, int num2);
	
	default int substract(int num1, int num2) {
		return num1 - num2;
	}
	
	default int divide(int num1, int num2) {
		return num1 / num2;
	}
	
	static int multiply (int num1, int num2) {
		return num1 * num2;
	}
}
