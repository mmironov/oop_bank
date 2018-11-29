package com.musala.trainings.accounts;

public class SavingsAccount extends Account {

	private double interestRate;
	private boolean hasInterestBeenPaid;

	public SavingsAccount(String accountNumber) {
		super(accountNumber);
		hasInterestBeenPaid = false;
	}

	@Override
	public void withdraw(double amount) {

		if (getBalance() - amount >= 0) {
			super.withdraw(amount);
		}
	}

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

	public void payInterestNow() {

		if (!hasInterestBeenPaid) {
			final double interest = (getBalance() * interestRate) / 100;
			deposit(interest);
			hasInterestBeenPaid = true;
		}
	}

	public void update() {

	}
}
