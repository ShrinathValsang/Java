package com.freecodecamp.multithreading;

public class WaitAndNotifyDemo {
	
	public static final Object LOCK = new Object();
	
	public static void main(String[] args) {
		Thread one  = new Thread(() -> {
			try {
				one();
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		});
		

		Thread two  = new Thread(() -> {
			try {
				two();
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		});
		
		one.start();
		two.start();
	}
	
	private static void one() throws InterruptedException {
		synchronized(LOCK) {
			System.out.println("Hello from method one!");
			LOCK.wait(); // releases lock on LOCK
			System.out.println("Back again in the method one!");
		}
	}

	
	private static void two() throws InterruptedException {
		synchronized (LOCK) {
			System.out.println("Hello from method two!"); // LOCK is free, acquires lock on it
			LOCK.notify(); // release lock after executing all code, 
						   // and notifies the other thread waiting to acquire lock on this object (LOCK)
			System.out.println("Back again in the method two");
		}
	}
}
