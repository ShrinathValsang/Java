package com.oracle.questionsAndExercises;

public class MyThread extends Thread {

	public static void main(String[] args) {
		MyThread thread = new MyThread();
//		thread.start();
		
		ThreadGroup group;/* = new MyThreadGroup */
		
		Runnable r = () -> {
			System.out.println("first line");
			System.out.println("second line");
		};
		
		Thread t = new Thread(r);
		t.start();
		
		Runnable r2 = () ->  {
			System.out.println("third line");
		};
		
		//Thread.startVirtualThread(r2);
	}
	
	public void run() {
		System.out.println("In the MyThread run method...");
	}

}
