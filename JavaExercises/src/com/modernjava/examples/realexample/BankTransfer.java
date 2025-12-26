package com.modernjava.examples.realexample; 

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;

public class BankTransfer {

	public static void main(String[] args) throws InterruptedException {
		AccountFactory accountFactory = BankAccount::new;
		
		BankAccount studentAcc = accountFactory.getBankAccount(1, 50000, "StudentA");
		BankAccount universityAcc = accountFactory.getBankAccount(2, 200000, "UniversityA");
		
		BiPredicate<Double, Double> isBalanceSufficient = (balance, amount) -> (balance > amount);
		BiConsumer<String, Double> printer = (x, y) -> System.out.println(x + y);
		BiConsumer<BankAccount, BankAccount> printer2 = 
				(student, university) -> System.out.println("Ending balance of student account: " + student.getBalance() + ", University account balance: " + university.getBalance());
		
		ExecutorService service = Executors.newFixedThreadPool(10);
		
		Thread t1 = new Thread(() -> {
			System.out.println(Thread.currentThread().getName() + " says :: Executing transfer... ");
			
			try {
				double amount = 1000;
				
				if (!isBalanceSufficient.test(studentAcc.getBalance(), amount)) {
					printer.accept(Thread.currentThread().getName() + " says :: balance insufficient, ", amount);
					return;
				}
				
				while (!studentAcc.transfer(universityAcc, amount)) {
					TimeUnit.MILLISECONDS.sleep(100);
					continue;
				}
			} catch (InterruptedException ie) {
				ie.printStackTrace();
			}
			
			printer.accept(Thread.currentThread().getName() + " says :: transfer successful. University account balance: ", universityAcc.getBalance());
		});
		
		for (int i = 0; i < 20; i++) {
			service.submit(t1);
		}
		
		service.shutdown();
		
		try {
			while (!service.awaitTermination(24L, TimeUnit.HOURS)) {
				System.out.println("Not yet... Stil waiting termination");
			}
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}
		
		printer2.accept(studentAcc, universityAcc);
	}

}
