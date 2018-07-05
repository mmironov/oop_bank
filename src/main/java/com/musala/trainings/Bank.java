package com.musala.trainings;

import com.musala.trainings.accounts.Account;
import com.musala.trainings.accounts.Opener;

/**
 * This class is responsible for managing the accounts in the bank
 * and all financial operations with regard to the accounts.
 * This class does not deal with the physical customers of the bank.
 * @author mmironov
 *
 */
public class Bank {
	
	private static final int CAPACITY = 250;
	
	private Account[] accounts;
	private int size;
	private Opener opener;
	
	public Bank(Opener opener) {
		this.opener = opener;
		accounts = new Account[CAPACITY];
		size = 0;
	}
	
	public void add(Account account) {
		if (size < CAPACITY) {
			accounts[size] = account;
			++size;
			opener.open(account);
		}
	}
	
	public void remove(int index) {
		if (index >= 0 && index < size) {
			for(int i=index; i < size; ++i) {
				accounts[i] = accounts[i + 1];
			}
			--size;
			accounts[size] = null;
		}
	}
	
	public void updateAll() {
		for(int i=0; i < size; ++i) {
			accounts[i].update();
		}
	}
	
	public int size() {
		return size;
	}
	
	public Account get(int index) {
		return accounts[index];
	}
}
