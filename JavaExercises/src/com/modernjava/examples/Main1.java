package com.modernjava.examples;

public class Main1 {
	public static void main(String... args) throws Throwable {
		final Class<?> c = Class.forName("A");
	}
}

//public class Main2 {
//	public static void main(String... args) throws Throwable {
//		ClassLoader.getSystemClassLoader().loadClass("A");
//	}
//
//	static {
//		System.out.println("time = " + System.currentTimeMillis());
//	}
//	
//}