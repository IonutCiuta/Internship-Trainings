package com.edava.training.shape.impl;

import com.edava.training.shape.Shape2D;

/**
 * Created by iciuta on 7/8/2016.
 */
public class Rectangle implements Shape2D{
    private double width, height;

    public Rectangle() {
    }

    public Rectangle(double length, double height) {
        this.width = length;
        this.height = height;
    }

    @Override
    public double computeArea() {
        return width * height;
    }

    @Override
    public double computePerimeter() {
        return 2*width + 2*height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "width=" + width +
                ", height=" + height +
                '}';
    }
}
