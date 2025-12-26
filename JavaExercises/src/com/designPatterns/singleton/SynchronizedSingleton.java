package com.designPatterns.singleton;

public class SynchronizedSingleton {
	private static SynchronizedSingleton INSTANCE;
	
	private SynchronizedSingleton() {
	}
	
	public static SynchronizedSingleton getInstance() {
		if (INSTANCE == null) {
			synchronized (SynchronizedSingleton.class) {
				INSTANCE = new SynchronizedSingleton();	
			}
		}
		return INSTANCE;
	}
}

