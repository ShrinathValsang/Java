package com.freecodecamp.multithreading;

public class ThreadPriorityExample {
	public static void main(String[] args) throws InterruptedException {
		System.out.println(Thread.currentThread().getName());
		System.out.println(Thread.currentThread().getPriority());
		
		Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
		System.out.println(Thread.currentThread().getPriority());
	}

}
