package com.designPatterns.singleton;

public class DoubleCheckedLockingSingleton {
	private static DoubleCheckedLockingSingleton INSTANCE;
	
	private DoubleCheckedLockingSingleton() {}
	
	public static DoubleCheckedLockingSingleton getInstance() throws Throwable {
		if (INSTANCE == null) {
			synchronized (DoubleCheckedLockingSingleton.class) {
				if (INSTANCE == null) {
					INSTANCE = new DoubleCheckedLockingSingleton();	
				}	
			}
		}
		return INSTANCE;
	}
}

