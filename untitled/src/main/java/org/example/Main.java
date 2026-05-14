package org.example;

import org.example.classs.BankAccount;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        try {
            BankAccount FirstAccount = new BankAccount();
            BankAccount SecondAccount = new BankAccount();
            Thread FirstThread = new Thread(() -> {
                try {
                    for (int i = 0; i < 100; i++) {
                        FirstAccount.deposit(1);
                    }
                    System.out.println("The value with thread #1 is: $"+FirstAccount.getBalance());
                }catch (InterruptedException e){
                    System.out.println(e.getCause());
                }
            });
            Thread SecondThread = new Thread(() -> {
                try{
                for (int i=0;i<100;i++){
                    FirstAccount.deposit(1);
                }
                System.out.println("The value with thread #2 is: $"+FirstAccount.getBalance());
                }catch (InterruptedException e){
                    System.out.println(e.getCause());
                }
            });
            Thread ThirdThread = new Thread(() -> {
                try{
                    for (int i=0;i<100;i++){
                        SecondAccount.deposit(1);
                    }
                    System.out.println("The value with thread #3 is: $"+SecondAccount.getBalance());
                }catch (InterruptedException e){
                    System.out.println(e.getCause());
                }
            });
            FirstThread.start();
            SecondThread.start();
            ThirdThread.start();
            FirstThread.join();
            SecondThread.join();
            ThirdThread.join();
            Field f=BankAccount.class.getDeclaredField("totalDeposits");
            f.setAccessible(true);
            System.out.println(f.get(null));
        } catch (InterruptedException e) {

        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

    }

}