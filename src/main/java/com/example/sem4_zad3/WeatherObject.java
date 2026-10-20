package com.example.sem4_zad3;

import javafx.scene.Group;
import javafx.scene.paint.Color;

public abstract class WeatherObject{
    protected Group view = new Group();

    protected abstract void draw();
    protected abstract void move();

    protected Group getView(){
        return view;
    };
}
