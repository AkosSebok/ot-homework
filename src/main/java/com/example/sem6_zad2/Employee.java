package com.example.sem6_zad2;

import java.util.Random;

public class Employee implements Runnable {
    private int id;
    private BankAccount account;
    private double amount;
    private String type;

    private String message;

    public Employee(int id, BankAccount account, double amount, String type) {
        this.id = id;
        this.account = account;
        this.amount = amount;
        this.type = type;
    }

    @Override
    public void run() {
        if (type.equals("Deposit")) {
            account.deposit(amount);
            message = "Employee " + id + " deposited " + amount + "$";
        } else {
            boolean success = account.withdraw(amount);
            if (success) {
                message = "Employee " + id + " withdrew " + amount + "$";
            } else {
                message = "Employee " + id + " could not withdraw " + amount + "$";
            }
        }
    }

    public String getMessage() {
        return message;
    }
}
