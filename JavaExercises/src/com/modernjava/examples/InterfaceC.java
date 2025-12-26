package com.modernjava.examples;

public interface InterfaceC {
	default void sumC(int num1, int num2) {
		System.out.println("InterfaceC - " + (num1 + num2));
	}

}
