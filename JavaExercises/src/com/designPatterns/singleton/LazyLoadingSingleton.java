package com.designPatterns.singleton;

public class LazyLoadingSingleton {
	private static LazyLoadingSingleton INSTANCE;
	
	private LazyLoadingSingleton() {
	}
	
	public static LazyLoadingSingleton getInstance() throws Throwable {
		if (INSTANCE == null) {
			INSTANCE = new LazyLoadingSingleton();
		}
		return INSTANCE;
	}
}
