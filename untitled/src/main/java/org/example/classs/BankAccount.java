package org.example.classs;

import java.util.concurrent.atomic.AtomicLong;

public class BankAccount {
    private AtomicLong balance;
    public BankAccount(AtomicLong balance){
        this.balance = balance;
    }
    public BankAccount() {
        this.balance=new AtomicLong(0);
    }

    public void deposit(long amount){
        this.balance.addAndGet(amount);
    }
    public void withdraw(long amount){
        this.balance.addAndGet(-amount);
    }

    public void setBalance(long balance) {
        this.balance.set(balance);
    }

    public long getBalance() {
        return this.balance.get();
    }
}
