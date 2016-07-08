package com.edava.training.shape.impl;

/**
 * Created by iciuta on 7/8/2016.
 */
public class Square extends Rectangle {

    /*squares are just rectangles that got their sh*t together*/
    public Square(double edge) {
        super(edge, edge);
    }

    @Override
    public String toString() {
        return "Square{" +
                "width=" + getWidth() +
                ", height=" + getWidth() +
                '}';
    }
}
