package org.example.classs;

public class BankAccount {
    private volatile long balance;

    public BankAccount(long balance) {
        this.balance = balance;
    }

    public synchronized void deposit(long amount, char c){
        this.balance+=amount;
        System.out.println("Here we have the first result: "+c +"-"+ this.balance);

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
