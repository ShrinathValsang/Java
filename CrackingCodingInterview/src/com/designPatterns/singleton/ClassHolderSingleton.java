package com.designPatterns.singleton;

public class ClassHolderSingleton {

	private ClassHolderSingleton() {}
	
	public static ClassHolderSingleton getInstance() {
		return SingletonHolder.INSTANCE;
	}
	
	private static class SingletonHolder {
		private static final ClassHolderSingleton INSTANCE = new ClassHolderSingleton(); 
	}
}

