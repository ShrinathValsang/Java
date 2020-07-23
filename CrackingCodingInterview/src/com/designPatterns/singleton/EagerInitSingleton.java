package com.designPatterns.singleton;

public class EagerInitSingleton {
	private static final EagerInitSingleton singleton = new EagerInitSingleton();
	
	private EagerInitSingleton() {
	}
	
	public static EagerInitSingleton getInstance() {
		return singleton;
	}
}
