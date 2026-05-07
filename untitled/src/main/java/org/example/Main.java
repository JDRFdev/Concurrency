package org.example;

import org.example.classs.BankAccount;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        BankAccount OnlyAccount=new BankAccount(0);
        ArrayList<Thread> threads=new ArrayList<>();
        try {
        for (int i=0;i<100;i++){
            threads.add(
                    new Thread(()->{
                        for (int j=0;j<10_000;j++){
                            OnlyAccount.deposit(1);
                        }
                        System.out.println("Here we have the first result: "+OnlyAccount.getBalance());

                    })
            );
            threads.get(i).start();
        }
        for (int i=0;i<100;i++){
            threads.get(i).join();
        }
            System.out.println("Here we have the final result: "+OnlyAccount.getBalance());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}