package com.edava.training.examples;

/**
 * Created by iciuta on 7/8/2016.
 */
public class ExtendedSimple extends Simple {
    public ExtendedSimple(int i) {
        super(i);
        System.out.println("ExtendedSimple with 1 arg.");
    }

    public ExtendedSimple() {
        super(1);
        System.out.println("ExtendedSimple with 0 arg.");
    }

    public ExtendedSimple(int i, int j) {
        super(i);
        System.out.println("ExtendedSimple with 2 arg.");
    }
}
