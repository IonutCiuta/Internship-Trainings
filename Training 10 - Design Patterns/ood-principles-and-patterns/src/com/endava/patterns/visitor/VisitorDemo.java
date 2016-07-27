package com.endava.patterns.visitor;

/**
 * Created by rburlacioiu on 7/22/2016.
 */
public class VisitorDemo {

    public static void main(String[] args) {
        Element[] items = new Element[]{
            new Book(20, 1,"1234"),
            new Book(100, 2, "5678"),
            new Fruit(10, 2, "Banana"),
            new Fruit(5, 5, "Apple")
        };

        System.out.println("Total Cost = " + calculatePrice(items));
        System.out.println("Total Weight = " + calculateWeight(items));

    }

    private static int calculatePrice(Element[] items) {
        System.out.println("=== PRICE ===");
        Visitor visitor = new ShoppingCartVisitor();
        int sum = 0;
        for(Element item : items){
            sum = sum + item.accept(visitor);
        }
        return sum;
    }

    private static int calculateWeight(Element[] items) {
        System.out.println("=== WEIGHT ===");
        Visitor visitor = new WeightVisitor();
        int weight = 0;
        for(Element item : items){
            weight = weight + item.accept(visitor);
        }
        return weight;
    }

}