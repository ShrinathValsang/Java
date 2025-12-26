package com.tests.examples;

public class Deadlock {
	
	static class Friend {
		private final String name;
		
		public Friend(String name1) {
			this.name = name1;
		}
		
		public String getName() {
			return this.name;
		}
		
		public synchronized void bow(Friend bower) {
			System.out.printf("%s: %s has bowed to me!%n", this.name, bower.getName());
			bower.bowback (this);
		}
		
		public synchronized void bowback(Friend bower) {
			System.out.printf("%s: %s has bowed back to me!%n", this.name, bower.getName());
		}
		
	}

	public static void main(String[] args) {
		int i;
		Friend alphonse = new Friend("Alphonse");
		Friend gaston = new Friend("Gaston");
		
		new Thread(new Runnable() {
			public void run() {
				alphonse.bow(gaston);
			}
		}).start();
		
		new Thread(new Runnable() {
			public void run() {
				gaston.bow(alphonse);
			}
		}).start();
		
		Color c = null;
		
		if (c == Color.Black) {
			System.out.println("c == Color.Black => true");
		} else {
			System.out.println("c == Color.Black => false");
		}

		
		if (c.equals(Color.Black)) {
			System.out.println("c.equals(Color.Black) => true");
		} else {
			System.out.println("c.equals(Color.Black) => false");
		}

	}

}

enum Color{Black, White}
