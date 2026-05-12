package org.example;

import org.example.classs.BankAccount;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        try {
            BankAccount OnlyAccount = new BankAccount();
            Thread FirstThread = new Thread(() -> {
                for (int i=0;i<1000000;i++){
                    OnlyAccount.deposit(1);
                }
                System.out.println("The value with thread #1 is: $"+OnlyAccount.getBalance());
            });
            Thread SecondThread = new Thread(() -> {
                for (int i=0;i<1000000;i++){
                    OnlyAccount.deposit(1);
                }
                System.out.println("The value with thread #2 is: $"+OnlyAccount.getBalance());
            });
            FirstThread.start();
            SecondThread.start();
            FirstThread.join();
            SecondThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

}