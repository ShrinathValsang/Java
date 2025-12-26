package com.modernjava.examples.realexample;

public interface AccountFactory {
	BankAccount getBankAccount(int id, double balance, String accountName);
}
