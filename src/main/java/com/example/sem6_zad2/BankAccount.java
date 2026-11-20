package com.example.sem6_zad2;

public class BankAccount {
    private double balance;

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public synchronized double getBalance() {
        return balance;
    }

    public synchronized void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public synchronized boolean withdraw(double amount) {
        if (balance >= amount && amount > 0) {
            balance -= amount;
            return true;
        }
        return false;
    }
}
