package org.example.classs;

import java.util.concurrent.atomic.AtomicLong;

public class BankAccount {
    private long balance;
    private static int totalDeposits=0;
    public BankAccount(long balance){
        this.balance = balance;
    }
    public BankAccount() {
        this.balance=0;
    }

    public  void deposit(long amount) throws InterruptedException {
        synchronized(this){this.balance+=amount;}
        Thread.sleep(10);
        synchronized (BankAccount.class){totalDeposits++;}
   }
    public void withdraw(long amount) throws InterruptedException {
        synchronized(this){this.balance-=amount;}
        Thread.sleep(10);
    }

    public void setBalance(long balance) throws InterruptedException {
        synchronized(this){this.balance=balance;}
        Thread.sleep(10);
    }

    public long getBalance() throws InterruptedException {
        synchronized(this){return this.balance;}
    }
}
