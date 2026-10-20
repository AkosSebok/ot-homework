package com.example.sem4_zad3;

import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

public class Snowflake extends WeatherObject {
    private Color color = Color.LIGHTBLUE;
    private double horizontal = 1;

    @Override
    protected void draw() {
        view.getChildren().clear();

        Line l1 = new Line(20, 0, 20, 40);
        Line l2 = new Line(0, 20, 40, 20);
        Line l3 = new Line(0, 0, 40, 40);
        Line l4 = new Line(40, 0, 0, 40);

        l1.setStroke(color);
        l2.setStroke(color);
        l3.setStroke(color);
        l4.setStroke(color);

        l1.setStrokeWidth(3);
        l2.setStrokeWidth(3);
        l3.setStrokeWidth(3);
        l4.setStrokeWidth(3);

        view.getChildren().addAll(l1,l2,l3,l4);
    }

    @Override
    public void move() {
        view.setTranslateY(view.getTranslateY() + 3);

        double x = view.getTranslateX() + horizontal;

        if (x >= 15 || x <= -15) {
            horizontal = -horizontal;
        }
        view.setTranslateX(x);
    }

}
