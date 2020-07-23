package com.designPatterns.singleton;

public class ThreadSafeSingleton {
	private static ThreadSafeSingleton INSTANCE;
	
	private ThreadSafeSingleton() {}
	
	public static synchronized ThreadSafeSingleton getInstance() throws Throwable {
		if (INSTANCE == null) {
			INSTANCE = new ThreadSafeSingleton();	
		}
		return INSTANCE;
	}
}

