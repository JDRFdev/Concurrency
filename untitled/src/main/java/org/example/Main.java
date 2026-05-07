package org.example;

import org.example.classs.BankAccount;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        try {
            BankAccount FirstAccount = new BankAccount(0);
            BankAccount SecondAccount = new BankAccount(0);
            Thread FirstThread = new Thread(() -> {
                FirstAccount.deposit(SecondAccount,1);
            });
            Thread SecondThread = new Thread(() -> {
                SecondAccount.deposit(FirstAccount,1);
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