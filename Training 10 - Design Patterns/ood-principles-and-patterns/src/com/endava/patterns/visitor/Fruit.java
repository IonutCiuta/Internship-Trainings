package com.endava.patterns.visitor;

/**
 * Created by rburlacioiu on 7/22/2016.
 */
public class Fruit implements Element {

    private int pricePerKg;
    private int weight;
    private String name;

    public Fruit(int priceKg, int weight, String name){
        this.pricePerKg=priceKg;
        this.weight=weight;
        this.name = name;
    }

    public int getPricePerKg() {
        return pricePerKg;
    }


    public int getWeight() {
        return weight;
    }

    public String getName(){
        return this.name;
    }

    @Override
    public int accept(Visitor visitor) {
        return visitor.visit(this);
    }

    @Override
    public String toString() {
        return "Fruit{" +
                "pricePerKg=" + pricePerKg +
                ", weight=" + weight +
                ", name='" + name + '\'' +
                '}';
    }
}
