package com.freecodecamp.multithreading;

public class SynchronizationDemo {
	private static int counter1 = 0; // shared resource
	private static int counter2 = 0;
	
	public static void main(String[] args) /*throws InterruptedException*/ {
		Thread one = new Thread(() -> {
			for (int i = 0; i < 100000; i++) {
				// counter++;
				increment1();
			}
		});
		
		Thread two = new Thread(() -> {
			for (int i = 0; i < 100000; i++) {
				//counter++; // not one operation but three! - READ, INCREMENT, and WRITE
				increment2();
			}
		});
		
		one.start();
		two.start();
		
		try {
			one.join();
			two.join();
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		
		System.out.println("Counter values : counter1 = " + counter1 + ", counter2 = " + counter2); // value less than 200000! - RACE CONDITION
		
	}

	// allows access to variable counter to only ONE THREAD at a time!
	// monitored lock or INTRINSIC LOCK
	// 
	// synchronized gets the CLASS level lock!!
	private synchronized static void increment1() {
		counter1++;
	}

	private synchronized static void increment2() {
		counter2++;
	}

}
