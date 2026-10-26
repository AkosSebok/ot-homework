package com.example.sem5_zad2;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

public class HelloController {
    @FXML
    private BorderPane root;
    @FXML
    private Button addBT, updateBT, removeBT;
    @FXML
    private Label countL;
    @FXML
    private TextField nameTF, quantityTF;
    @FXML
    private ListView<Items> listView;
    private ObservableList<Items> items = FXCollections.observableArrayList();

    @FXML
    private void initialize() {
        listView.setItems(items);
        listView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                nameTF.setText(newValue.getName());
                quantityTF.setText(String.valueOf(newValue.getQuantity()));
            }
        });
    }

    @FXML
    private void add(ActionEvent event) {
        String name = nameTF.getText();
        int quantity = Integer.parseInt(quantityTF.getText());

        if (name.isEmpty() || quantity <= 0) {
            return;
        }

        Items i = new Items(name, quantity);
        items.add(i);
        updateCount();
        nameTF.clear();
        quantityTF.clear();
    }

    @FXML
    private void update(ActionEvent event) {
        Items i = (Items) listView.getSelectionModel().getSelectedItem();
        if (i == null) {
            return;
        }

        String name = nameTF.getText();
        int quantity = Integer.parseInt(quantityTF.getText());
        if (name.isEmpty() || quantity <= 0) {
            return;
        }
        i.setName(name);
        i.setQuantity(quantity);
        listView.refresh();
        updateCount();
    }

    @FXML
    private void remove(ActionEvent event) {
        Items i = (Items) listView.getSelectionModel().getSelectedItem();
        if (i != null) {
            items.remove(i);
            updateCount();
        }
    }

    private void updateCount() {
        countL.setText("Total count: " + items.size());
    }
}