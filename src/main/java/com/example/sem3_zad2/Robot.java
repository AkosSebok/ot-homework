package com.example.sem3_zad2;

import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

public class Robot {
    private Rectangle robot;
    private String color = Color.BLUE.toString();

    public Robot(double x, double y) {
        robot = new Rectangle(x, y, 100, 100);
        robot.setFill(Paint.valueOf(color));
    }

    public void setColor(String color) {
        this.color = color;
        robot.setFill(Paint.valueOf(color));
    }

    public double getX() {
        return robot.getX();
    }

    public double getY() {
        return robot.getY();
    }

    public Rectangle getRobot() {
        return robot;
    }

    public void move(double x, double y) {
        robot.setX(robot.getX() + x);
        robot.setY(robot.getY() + y);

    }

}
