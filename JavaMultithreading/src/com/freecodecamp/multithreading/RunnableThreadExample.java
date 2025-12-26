package com.freecodecamp.multithreading;

public class RunnableThreadExample {

	public static void main(String[] args) {
		new Thread(new ThreadOne()).start();
		new Thread(new ThreadTwo()).start();
		
		new Thread(() -> {
			for (int i = 0; i < 100; i++) {
				System.out.println("Thrad three : " + i);
			}
		}).start();
	}

}

class ThreadOne implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println("Thread one : " + i);
		}
	}
	
}

class ThreadTwo implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println("Thread two : " + i);
		}
	}
	
}