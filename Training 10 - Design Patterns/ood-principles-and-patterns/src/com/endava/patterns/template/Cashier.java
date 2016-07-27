package com.endava.patterns.template;

import java.util.ArrayList;
import java.util.List;

public class Cashier {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<Product>();
        products.add(new Bike());
        products.add(new Pen());
        products.add(new Milk());
        double grandTotal = 0;
        for (Product product : products) {
            grandTotal += product.getTotalPrice();
        }
        System.out.println(grandTotal);
    }
}
