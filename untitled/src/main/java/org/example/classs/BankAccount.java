package org.example.classs;

public class BankAccount {
    private long balance;
    private int id;
    public BankAccount(long balance, int id) {
        this.balance = balance;
        this.id=id;
    }

    public void deposit(BankAccount account,int amount){
        try {
            if(this.id< account.getId()){

                 synchronized (this) {
                    synchronized (account) {
                        Thread.sleep(100);
                        this.balance+=amount;
                        System.out.println("------------------------------------------");
                        System.out.println("My account has: $"+this.getBalance());
                        System.out.println("Second account has: $"+account.getBalance());
                        System.out.println("------------------------------------------");
                    }
                    }
            }else if(this.id>account.getId()) {
                synchronized (account) {
                    synchronized (this) {
                        Thread.sleep(100);
                        this.balance+=amount;
                        System.out.println("------------------------------------------");
                        System.out.println("My account has: $"+this.getBalance());
                        System.out.println("First account has: $"+account.getBalance());
                        System.out.println("------------------------------------------");
                    }
                }
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
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

    public int getId() {
        return id;
    }
}
