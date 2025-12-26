package com.designPatterns.singleton;

public class EnumSingletonDemo {
	
	public static void main(String[] args) {
		EnumSingleton singleton = EnumSingleton.INSTANCE;

		System.out.println(singleton.getValue());
		singleton.setName("MyName");
		singleton.setValue(9);
		System.out.println(singleton.getValue());
	}
}

