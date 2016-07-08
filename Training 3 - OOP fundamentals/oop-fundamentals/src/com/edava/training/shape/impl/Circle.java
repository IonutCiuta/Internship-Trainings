package com.edava.training.shape.impl;

import com.edava.training.shape.Shape2D;
import static java.lang.Math.PI;

/**
 * Created by iciuta on 7/8/2016.
 */
public class Circle implements Shape2D{
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double computeArea() {
        return PI * Math.pow(radius, 2);
    }

    @Override
    public double computePerimeter() {
        return 2*radius*PI;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                '}';
    }
}
