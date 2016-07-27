package com.endava.patterns.strategy;

public class AlgorithmImpl2 implements Algorithm {
    @Override
    public int doStep1() {
        return 2;
    }

    @Override
    public int doStep2(int value) {
        return 5 + value;
    }
}
