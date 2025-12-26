package com.tests.examples;


class Test {
	private String name;
	private int code;	
	
	Test(Test t) {
		this.name = t.name;
		this.code = t.code;
	}
	
	Test() {}
	
//	public void method1(String s) {
//		System.out.println("This is String");
//	}
	
	public void method1(Integer s) {
		System.out.println("This is Integer");
	}
	
	public void method1(Object s) {
		System.out.println("This is Object");
	}
	
	public static void main(String[] args) {
//		Test test = null;
//		Test t = new Test(test);
//		System.out.println(t);
		
		new Test().method1(null);
		
	}
}

/*
 * public class CopyConstructor {
 * 
 * public static void main(String[] args) { Test test = null; Test t = new
 * Test(test);
 * 
 * }
 * 
 * }
 */
