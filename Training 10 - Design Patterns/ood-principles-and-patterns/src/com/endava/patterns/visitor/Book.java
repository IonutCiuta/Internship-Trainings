package com.endava.patterns.visitor;

/**
 * Created by rburlacioiu on 7/22/2016.
 */
public class Book implements Element {

    private int price;
    private int weight;
    private String isbnNumber;

    public Book(int price, int weight, String isbnNumber) {
        this.price = price;
        this.weight = weight;
        this.isbnNumber = isbnNumber;
    }

    public int getPrice() {
        return price;
    }

    public int getWeight() {
        return weight;
    }

    public String getIsbnNumber() {
        return isbnNumber;
    }

    @Override
    public int accept(Visitor visitor) {
        return visitor.visit(this);
    }

    @Override
    public String toString() {
        return "Book{" +
                "price=" + price +
                ", isbnNumber='" + isbnNumber + '\'' +
                '}';
    }
}
