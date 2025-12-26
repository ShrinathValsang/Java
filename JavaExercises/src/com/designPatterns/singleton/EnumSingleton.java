package com.designPatterns.singleton;

public enum EnumSingleton {
	INSTANCE;
	
	private int value;
	private String name;
	
	private EnumSingleton() {
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
