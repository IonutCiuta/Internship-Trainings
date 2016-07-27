package com.endava.patterns.strategy;

public class AlgorithmImpl1 implements Algorithm {
    @Override
    public int doStep1() {
        return 4;
    }

    @Override
    public int doStep2(int value) {
        return 3 + value;
    }
}
