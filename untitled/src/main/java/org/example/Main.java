package org.example;

import org.example.classs.BankAccount;

public class Main {
    public static void main(String[] args) {
        BankAccount OnlyAccount=new BankAccount(0);
        Thread oneThread=new Thread(()->{
            for (int i=0;i<10_000;i++){
                OnlyAccount.deposit(1);
            }
            System.out.println("Here we have the first result: "+OnlyAccount.getBalance());
        });
        Thread twoThread=new Thread(()->{
            for (int i=0;i<10_000;i++){
                OnlyAccount.deposit(1);
            }
            System.out.println("Here we have th second result: "+OnlyAccount.getBalance());
        });
        oneThread.start();
        twoThread.start();
        try {
            oneThread.join();
            twoThread.join();
           
            System.out.println("Here we have the final result: "+OnlyAccount.getBalance());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}