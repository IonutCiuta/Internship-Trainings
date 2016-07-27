package com.endava.patterns.visitor;

/**
 * Created by rburlacioiu on 7/22/2016.
 */
public class WeightVisitor implements Visitor {

    @Override
    public int visit(Book book) {
        return book.getWeight();
    }

    @Override
    public int visit(Fruit fruit) {
        return fruit.getWeight();
    }

}