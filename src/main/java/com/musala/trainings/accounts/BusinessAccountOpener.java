package com.musala.trainings.accounts;

public class BusinessAccountOpener implements Opener {

	private static final int BUSINESS_RATE = 14;
	private static final int BUSINESS_OVERDRAFT = 10000;

	public void open(Account account) {
//		if (account instanceof SavingsAccount) {
//			((SavingsAccount)account).setInterestRate(BUSINESS_RATE);
//		}
//
//		if (account instanceof CurrentAccount) {
//			((CurrentAccount)account).setOverdraftLimit(BUSINESS_OVERDRAFT);
//		}
	}
}
