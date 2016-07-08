package com.edava.training;

import com.edava.training.examples.DoubleExtendedSimple;
import com.edava.training.shape.Shape2D;
import com.edava.training.shape.impl.ShapeFactory;


import java.util.ArrayList;
import java.util.List;

import static com.edava.training.shape.impl.ShapeFactory.Shape.*;


public class Main {

    public static void main(String[] args) {
        System.out.println("Hello OOP!");

        List<Shape2D> shapes = new ArrayList<>();
        shapes.add(ShapeFactory.getShape(CIRCLE));
        shapes.add(ShapeFactory.getShape(SQUARE));
        shapes.add(ShapeFactory.getShape(RECTANGLE));
        shapes.add(ShapeFactory.getShape(TRIANGLE));

        for(Shape2D shape : shapes) {
            display(shape);
        }

        new DoubleExtendedSimple();
    }

    private static String format(double value) {
        return String.format("%.2f", value);
    }

    private static void display(Shape2D shape) {
        String area = format(shape.computeArea());
        String perimeter = format(shape.computePerimeter());
        System.out.println(shape + "\nAREA = " + area + "\nPERIMTER = " + perimeter);
    }
}
