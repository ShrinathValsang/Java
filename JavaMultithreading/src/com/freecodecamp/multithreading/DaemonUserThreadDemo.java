package com.freecodecamp.multithreading;

public class DaemonUserThreadDemo {
	
	public static void main(String...args) {
		Thread daemonThread = new Thread(new DaemonHelper());
		Thread userThread = new Thread(new UserThreadHelper());
		daemonThread.setDaemon(true);
		
		daemonThread.start();
		userThread.start();
	}

}

class DaemonHelper implements Runnable {

	@Override
	public void run() {
		int count = 0;
		
		while (count < 500) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
			count++;
			System.out.println("Daemon helper running...");
		}
		
	}
	
}

class UserThreadHelper implements Runnable {

	@Override
	public void run() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		
		System.out.println("User Thread done with execution.");
	}
}