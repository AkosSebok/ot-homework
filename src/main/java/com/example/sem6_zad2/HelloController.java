package com.example.sem6_zad2;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.Random;

public class HelloController {
    @FXML
    private TextField startingBalanceTF;
    @FXML
    private TextField sumTF;
    @FXML
    private TextArea transactionTA;
    @FXML
    private Label balanceL;
    @FXML
    private Button createAccountBTN;
    @FXML
    private Button runBTN;
    @FXML
    private Button run5BTN;
    @FXML
    private ComboBox<String> typeCB;
    private BankAccount account;
    private int id_count = 0;

    @FXML
    private void initialize() {
        typeCB.getItems().addAll("Deposit", "Withdraw");
        typeCB.setValue("Deposit");
        balanceL.setText("0.00$");

    }

    @FXML
    private void createAccount() {
        try {
            double balance = Double.parseDouble(startingBalanceTF.getText());
            if (balance < 0) {
                transactionTA.appendText("Invalid balance\n");
                return;
            }
            account = new BankAccount(balance);
            updateBalance();
            transactionTA.appendText("Account created with " + balance + "$\n");
        } catch (NumberFormatException e) {
            transactionTA.appendText("Invalid balance\n");
        }
    }

    @FXML
    private void runOne() {
        if (account == null) {
            return;
        }

        try {
            double amount = Double.parseDouble(sumTF.getText());
            if (amount < 0) {
                transactionTA.appendText("Invalid amount\n");
                return;
            }
            String type = typeCB.getValue();
            if (type == null) {
                return;
            }
            int id = id_count++;
            Employee e = new Employee(id, account, amount, type);
            Thread t = new Thread(e);
            t.start();
            waitForEmployee(t, e);
        } catch (NumberFormatException e) {
            transactionTA.appendText("Invalid amount\n");
        }
    }

    @FXML
    private void runFive() {
        if (account == null) {
            return;
        }
        Random rand = new Random();
        Thread[] t = new Thread[5];
        Employee[] e = new Employee[5];

        for (int i = 0; i < 5; i++) {
            int id = id_count++;
            String type = rand.nextBoolean() ? "Deposit" : "Withdraw";
            double amount = rand.nextInt(200) + 1;
            e[i] = new Employee(id, account, amount, type);
            t[i] = new Thread(e[i]);
            t[i].start();
        }

        new Thread(() -> {
            try {
                for (int i = 0; i < 5; i++) {
                    t[i].join();
                    Employee employee = e[i];
                    Platform.runLater(() -> {
                        transactionTA.appendText(employee.getMessage() + "\n");
                        updateBalance();
                    });
                    Thread.sleep(500);
                }
            } catch (InterruptedException exc) {
                Thread.currentThread().interrupt();
            }
        }).start();
    }

    private void waitForEmployee(Thread t, Employee e) {
        new Thread(() -> {
            try {
                t.join();
                Platform.runLater(() -> {
                    transactionTA.appendText(e.getMessage() + "\n");
                    updateBalance();
                });
            } catch (InterruptedException exc) {
                Thread.currentThread().interrupt();
            }
        }).start();
    }

    private void updateBalance() {
        if (account != null) {
            balanceL.setText(account.getBalance() + "$");
        }
    }


}
