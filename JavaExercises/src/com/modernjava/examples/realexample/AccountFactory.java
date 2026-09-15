package com.modernjava.examples.realexample;

import com.generic.BankAccount;

public interface AccountFactory {
	BankAccount getBankAccount(int id, double balance, String accountName);
}
