package com.example.sem4_zad3;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;

public class Raindrop extends WeatherObject {
    private Color color = Color.BLUE;

    @Override
    public void draw() {
        view.getChildren().clear();

        Circle c1 = new Circle(15, 25, 10, color);
        Polygon p1 = new Polygon(15, 0, 5, 25, 25, 25);
        p1.setFill(color);

        view.getChildren().addAll(c1,p1);
    }

    @Override
    public void move() {
        view.setTranslateY(view.getTranslateY() + 6);
    }
}
