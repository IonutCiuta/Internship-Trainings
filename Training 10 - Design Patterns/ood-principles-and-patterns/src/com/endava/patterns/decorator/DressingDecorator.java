package com.endava.patterns.decorator;

/**
 * Created by Andra on 7/21/2016.
 */
public class DressingDecorator extends SandwichDecorator {

    public DressingDecorator(Sandwich customSandwich) {
        super(customSandwich);
    }

    public String make() {
        return customSandwich.make() + addDressing();
    }

    public String addDressing() {
        return " + ketchup";
    }
}
