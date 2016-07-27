package com.endava.patterns.template;

public abstract class Product {

    public double getTotalPrice() {
        return getPrice() * 1.24;
    }

    protected abstract int getPrice();
}
