package org.example.classs;

public class BankAccount {
    private long balance;

    public BankAccount(long balance) {
        this.balance = balance;
    }

    public synchronized void deposit(long amount){
        this.balance+=amount;
    }
    public void withdraw(long amount){
        this.balance-=amount;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public long getBalance() {
        return balance;
    }
}
