package com.musala.trainings.accounts;

public class CurrentAccount extends Account {

	private double overdraftLimit;
	
	public double getOverdraftLimit() {
		return overdraftLimit;
	}

	public void setOverdraftLimit(double overdraftLimit) {
		this.overdraftLimit = overdraftLimit;
	}

	public CurrentAccount(String accountNumber) {
		super(accountNumber);
	}
	
	@Override
	public void withdraw(double amount) {
		
		if (getBalance() - amount >= -overdraftLimit) {			
			super.withdraw(amount);
		}
	}
	
	@Override
	public void update() {
		if (getBalance() < 0) {
			sendLetter();
		}
	}
	
	private void sendLetter() {
		System.out.println("The account is in overdraft!");
	}
	
	@Override
	public String toString() {
		return String.format("%s\nOverdraft Limit: %f", super.toString(), overdraftLimit);
	}
}
