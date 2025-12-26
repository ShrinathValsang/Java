package com.leetcode.dsa;

class MyCar {}

public class MySingleton {

	// private static MySingleton INSTANCE = new MySingleton();
	private static MySingleton INSTANCE;

	private MySingleton() {
		// empty constructor
		if (INSTANCE == null) {
			INSTANCE = new MySingleton();
		}
	}
	
	public static MySingleton getInstance() {
		return INSTANCE;
	}
	
	public static void main(String...args) {
		MyCar car1 = new MyCar();
		MyCar car2 = new MyCar();
		
		System.out.println(car1 == car2);
		car2 = car1;
		
		System.out.println(car1 == car2);
	}

}
