package com.example.sem3_zad2;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class HelloController {
    @FXML
    private Pane root;
    private Robot robot;
    private Timeline tl;
    private boolean automatic = false;
    private double ax = 5;
    private double ay = 5;

    @FXML
    public void initialize() {
        robot = new Robot(350, 350);
        root.getChildren().add(robot.getRobot());

        root.setFocusTraversable(true);

        tl = new Timeline(new KeyFrame(Duration.millis(200), e -> autoMove()));
        tl.setCycleCount(Timeline.INDEFINITE);

        robot.getRobot().setOnMouseClicked(event -> {
                    automatic = !automatic;
                    if (automatic)
                        tl.play();
                    else {
                        tl.pause();
                        //root.requestFocus();
                    }
        });

        root.sceneProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                newValue.setOnKeyPressed(event -> {
                    if (automatic) return;

                    switch (event.getCode()) {
                        case W:
                            robot.setColor(Color.BLUE.toString());
                            if (robot.getY() > 0)
                                robot.move(0, -10);
                            break;

                        case A:
                            robot.setColor(Color.RED.toString());
                            if (robot.getX() > 0)
                                robot.move(-10, 0);
                            break;

                        case S:
                            robot.setColor(Color.YELLOW.toString());
                            if (robot.getY() < root.getHeight() - 100)
                                robot.move(0, 10);
                            break;

                        case D:
                            robot.setColor(Color.GREEN.toString());
                            if (robot.getX() < root.getWidth() - 100)
                                robot.move(10, 0);
                            break;

                    }
                });
            }
        });
    }

    public void autoMove() {
        double x = robot.getX();
        double y = robot.getY();

        if (x < 0 || x > root.getWidth() - 100)
            ax = -ax;
        if (y < 0 || y > root.getHeight() - 100)
            ay = -ay;

        x += ax;
        y += ay;
        robot.getRobot().setX(x);
        robot.getRobot().setY(y);
    }
}
