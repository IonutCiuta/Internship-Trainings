package com.edava.training.shape.impl;

import com.edava.training.shape.Shape2D;

/**
 * Created by iciuta on 7/8/2016.
 */
public class ShapeFactory {
    public enum Shape {
        CIRCLE, TRIANGLE, SQUARE, RECTANGLE;
    }

    public static Shape2D getShape(Shape shape) {
        Shape2D result;

        switch (shape) {
            case CIRCLE:
                result = new Circle(3);
                break;

            case TRIANGLE:
                result = new Triangle(2, 3, 4);
                break;

            case SQUARE:
                result = new Square(20);
                break;

            case RECTANGLE:
                result = new Rectangle(50, 40);
                break;

            default:
                throw new UnsupportedOperationException("Unknown shape!");
        }

        return result;
    }
}
