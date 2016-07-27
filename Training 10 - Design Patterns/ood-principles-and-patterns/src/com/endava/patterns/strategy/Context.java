package com.endava.patterns.strategy;

public class Context {
    public static void main(String[] args) {
        Algorithm algorithm = new AlgorithmImpl2();
        System.out.println(algorithm.doStep2(algorithm.doStep1()));
    }
}
