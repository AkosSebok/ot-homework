package com.example.sem2_zad2;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML
    private Label l_mgResult, l_gResult, l_kgResult, l_tResult;
    @FXML
    private TextField tf_value;
    @FXML
    private RadioButton rb_mg, rb_g, rb_kg, rb_t;

    @FXML
    private void convert() {
        double a = Double.parseDouble(tf_value.getText());
        double mg, g, kg, t;

        if  (rb_mg.isSelected()) {
            mg = a;
            g = a / 1000;
            kg = a / 1000000;
            t = a / 1000000000;
        }
        else if (rb_g.isSelected()) {
            mg = a * 1000;
            g = a;
            kg = a / 1000;
            t = a / 1000000;
        }
        else if (rb_kg.isSelected()) {
            mg = a * 100000;
            g = a * 1000;
            kg = a;
            t = a / 1000;
        }
        else if (rb_t.isSelected()) {
            mg = a * 1000000000;
            g = a * 1000000;
            kg = a * 1000;
            t = a;
        }
        else {
            return;
        }
        l_mgResult.setText(String.format("%f", mg));
        l_gResult.setText(String.format("%f", g));
        l_kgResult.setText(String.format("%f", kg));
        l_tResult.setText(String.format("%f", t));
    }
}
