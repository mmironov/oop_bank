package com.musala.trainings;

import com.musala.trainings.accounts.SavingsAccount;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class SavingsAccountTest {

    @Test
    public void testWithdrawMoreThanBalance() {

        SavingsAccount account = new SavingsAccount("124");

        final double expected = account.getBalance();

        account.withdraw(100);

        final double actual = account.getBalance();

        assertEquals(expected, actual);
    }

    @Test
    public void testInterestHasBeenPaid() {

        final SavingsAccount account = new SavingsAccount("124");
        account.deposit(1000);

        final double interestRate = 12;
        account.setInterestRate(interestRate);

        final double balanceBeforeInterest = account.getBalance();

        account.payInterestNow();

        final double balanceAfterInterest = account.getBalance();

        final double expected = balanceBeforeInterest + (balanceBeforeInterest * interestRate) / 100;

        assertEquals(expected, balanceAfterInterest, 0.001);
    }

    @Test
    public void testInterestPayableOnlyOnce() {
        final SavingsAccount account = new SavingsAccount("124");
        account.deposit(1000);

        final double interestRate = 12;
        account.setInterestRate(interestRate);

        final double balanceBeforeInterest = account.getBalance();

        account.payInterestNow();

        final double balanceAfterFirstAttempt = account.getBalance();

        account.payInterestNow();

        final double balanceAfterSecondAttempt = account.getBalance();

        assertEquals(balanceAfterFirstAttempt, balanceAfterSecondAttempt, 0.001);
    }
}
