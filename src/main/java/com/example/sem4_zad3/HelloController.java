package com.example.sem4_zad3;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class HelloController {
    @FXML
    private Pane root;

    private List<Cloud> clouds = new ArrayList<>();
    private List<Raindrop> rain = new ArrayList<>();
    private List<Snowflake> snow = new ArrayList<>();

    private Timeline t;
    private Random random = new Random();

    private boolean rainStopped = false;

    @FXML
    private void initialize() {
        t = new Timeline(new KeyFrame(Duration.millis(100), ev -> {move();}));
        t.setCycleCount(Timeline.INDEFINITE);
        t.play();
    }

    @FXML
    private void draw(){
        double w = root.getWidth();
        double h = root.getHeight();

        Cloud c =  new Cloud();
        c.draw();
        c.getView().setLayoutX(randomPosition(0, w - 90));
        c.getView().setLayoutY(randomPosition(0, h / 3 - 40));
        clouds.add(c);
        root.getChildren().add(c.getView());

        Raindrop r = new Raindrop();
        r.draw();
        r.getView().setLayoutX(randomPosition(0, w - 30));
        r.getView().setLayoutY(randomPosition(h / 3, 2 * h / 3 - 35));
        rain.add(r);
        root.getChildren().add(r.getView());

        Snowflake s = new Snowflake();
        s.draw();
        s.getView().setLayoutX(randomPosition(0, w - 40));
        s.getView().setLayoutY(randomPosition(h / 3, 2 * h / 3 - 40));
        snow.add(s);
        root.getChildren().add(s.getView());
    }

    private double randomPosition(double min, double max){
        if(max <= min)
            return min;
        return random.nextDouble() * (max - min) + min;
    }

    private void move() {
        moveC();
        moveR();
        moveS();
    }

    private void moveC() {
        Iterator<Cloud> iterator = clouds.iterator();
        while (iterator.hasNext()) {
            Cloud cloud = iterator.next();

            cloud.move();

            if (cloud.getView().getBoundsInParent().getMinX() > root.getWidth()) {
                root.getChildren().remove(cloud.getView());
                iterator.remove();
            }
        }
    }

    private void moveR() {
        if (rainStopped) {
            return;
        }
        Iterator<Raindrop> iterator = rain.iterator();
        while (iterator.hasNext()) {
            Raindrop raindrop = iterator.next();

            raindrop.move();

            if (raindrop.getView().getBoundsInParent().getMinY() > root.getHeight()) {
                root.getChildren().remove(raindrop.getView());
                iterator.remove();
            }
        }
    }

    private void moveS() {
        Iterator<Snowflake> iterator = snow.iterator();
        while (iterator.hasNext()) {
            Snowflake snowflake = iterator.next();

            snowflake.move();

            if (snowflake.getView().getBoundsInParent().getMinY() > root.getHeight()) {
                root.getChildren().remove(snowflake.getView());
                iterator.remove();
            }
        }
    }

    @FXML
    private void stopR() {
        rainStopped = !rainStopped;
    }

    @FXML
    private void recolorC() {
        for (Cloud cloud : clouds) {
            cloud.setColor(Color.DARKBLUE);
        }
    }

    @FXML
    private void moveLeft() {
        for (Cloud c : clouds) {
            c.getView().setLayoutX(c.getView().getLayoutX() -20);
        }
        for (Raindrop r : rain) {
            r.getView().setLayoutX(r.getView().getLayoutX() - 20);
        }
        for (Snowflake s : snow) {
            s.getView().setLayoutX(s.getView().getLayoutX() - 20);
        }
    }

}
