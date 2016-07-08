package com.edava.training.shape.impl;

import com.edava.training.shape.Shape2D;

/**
 * Created by iciuta on 7/8/2016.
 */
/*describes a triangle with vertices A, B, C from left to right, AB representing the base of the triangle*/
public class Triangle implements Shape2D{
    private double edgeAB, edgeBC, edgeCA;

    public Triangle(double edgeAB, double edgeBC, double edgeCA) {
        this.edgeAB = edgeAB;
        this.edgeBC = edgeBC;
        this.edgeCA = edgeCA;
    }

    @Override
    public double computePerimeter() {
        return edgeAB + edgeBC + edgeCA;
    }

    @Override
    public double computeArea() {
        double semiPerimeter = computePerimeter() / 2;
        return Math.sqrt(
                semiPerimeter * (semiPerimeter - edgeAB) * (semiPerimeter - getEdgeBC() * (semiPerimeter - edgeCA)));
    }

    public double getEdgeAB() {
        return edgeAB;
    }

    public void setEdgeAB(double edgeAB) {
        this.edgeAB = edgeAB;
    }

    public double getEdgeBC() {
        return edgeBC;
    }

    public void setEdgeBC(double edgeBC) {
        this.edgeBC = edgeBC;
    }

    public double getEdgeCA() {
        return edgeCA;
    }

    public void setEdgeCA(double edgeCA) {
        this.edgeCA = edgeCA;
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "edgeAB=" + edgeAB +
                ", edgeBC=" + edgeBC +
                ", edgeCA=" + edgeCA +
                '}';
    }
}
