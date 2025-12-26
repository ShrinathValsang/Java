package com.freecodecamp.multithreading;

public class JoinThreadExample {

	public static void main(String[] args) throws InterruptedException {
		
		Thread one = new Thread(() -> {
			for (int i = 0; i < 5; i++) {
				System.out.println("Thrad one : " + i);
			}
		});
		
		Thread two = new Thread(() -> {
			for (int i = 0; i < 125; i++) {
				System.out.println("Thrad two : " + i);
			}
		});
		
		/*
		one.start();
		two.start();
		System.out.println("Done executing the threads!"); // printed first as the main thread has the highest priority
		*/

//		/*
		System.out.println("Before executing the threads...");
		one.start();
		two.start();
		one.join(); // mechanism for inter-thread synchronization, calling thread goes to waiting state
					// and remains there till the referenced thread completes the task
		two.join();
		System.out.println("Done executing the threads!");
//		*/
	}

}
