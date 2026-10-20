package com.example.sem4_zad3;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.Node;

public class Cloud extends WeatherObject {
    private Color color = Color.LIGHTGREY;

    @Override
    public void draw() {
        view.getChildren().clear();

        Circle c1 = new Circle(20, 20, 20, color);
        Circle c2 = new Circle(45, 20, 20, color);
        Circle c3 = new Circle(70, 20, 20, color);

        view.getChildren().addAll(c1,c2,c3);
    }

    @Override
    public void move() {
        view.setTranslateX(view.getTranslateX() + 1);
    }

    public  void setColor(Color color) {
        this.color = color;
        for (Node node : view.getChildren()) {
            if (node instanceof Circle ) {
                Circle circle = (Circle) node;
                circle.setFill(color);
            }
        }
    }
}
