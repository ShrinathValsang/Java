package com.designPatterns.singleton;

public class VolatileSingleton {
	private static volatile VolatileSingleton INSTANCE;
	
	private VolatileSingleton() {}
	
	public static VolatileSingleton getInstance() {
		if (INSTANCE == null) {
			synchronized (VolatileSingleton.class) {
				if (INSTANCE == null) {
					INSTANCE = new VolatileSingleton();	
				}	
			}
		}
		return INSTANCE;
	}
}

