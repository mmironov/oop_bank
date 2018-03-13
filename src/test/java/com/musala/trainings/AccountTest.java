package com.musala.trainings;

import com.musala.trainings.accounts.CurrentAccount;
import org.junit.Assert;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class AccountTest {

    @Test
    public void depositTest() {

        CurrentAccount account = new CurrentAccount("123");

        final double amountToDeposit = 1000;
        account.deposit(amountToDeposit);

        final double balance = account.getBalance();

        assertEquals(amountToDeposit, balance);
    }

    @Test
    public void withdrawTest() {

        CurrentAccount account = new CurrentAccount("123");

        final double amountToDeposit = 1000;
        account.deposit(amountToDeposit);

        final double amountToWithdraw = 300;
        account.withdraw(amountToWithdraw);

        final double balance = account.getBalance();

        assertEquals(amountToDeposit - amountToWithdraw, balance);
    }

    @Test
    public void creatingEmptyAccountTest() {

        CurrentAccount account = new CurrentAccount("123");

        final double balance = account.getBalance();

        assertEquals(0.0, balance);
    }
}
