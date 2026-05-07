package org.example.classs;

public class BankAccount {
    private volatile long balance;

    public BankAccount(long balance) {
        this.balance = balance;
    }

    public synchronized void deposit(BankAccount account,int amount){
        try {
            Thread.sleep(100);
            account.withdraw(amount);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public synchronized void withdraw(long amount){
        this.balance-=amount;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public long getBalance() {
        return balance;
    }
}
