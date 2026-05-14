package org.example.classs;

import java.util.concurrent.atomic.AtomicLong;

public class BankAccount {
    private final Object balanceLock=new Object();
    private static final Object totallock=new Object();
    private long balance;
    private static int totalDeposits=0;
    public BankAccount(long balance){
        this.balance = balance;
    }
    public BankAccount() {
        this.balance=0;
    }

    public  void deposit(long amount) throws InterruptedException {
        synchronized(balanceLock){this.balance+=amount;}
        synchronized (totallock){totalDeposits++;}
   }
    public void withdraw(long amount) throws InterruptedException {
        synchronized(balanceLock){this.balance-=amount;}
    }

    public void setBalance(long balance) throws InterruptedException {
        synchronized(balanceLock){this.balance=balance;}
    }

    public long getBalance() throws InterruptedException {
        synchronized(balanceLock){return this.balance;}
    }
}
