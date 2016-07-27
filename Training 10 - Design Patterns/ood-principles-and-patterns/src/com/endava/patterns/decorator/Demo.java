package com.endava.patterns.decorator;

import java.util.Calendar;

/**
 * Created by Andra on 7/21/2016.
 */
public class Demo {

    public static void main(String[] args) {
        Sandwich sandwich = new DressingDecorator(new DressingDecorator(new MeatDecorator(new SimpleSandwich())));

        System.out.println(sandwich.make());

    }
}
