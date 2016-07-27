package com.endava.patterns.builder;

public abstract class BikeBuilder {

    protected abstract BikeBuilder buildBike();
    protected abstract BikeBuilder withDerailleur(String derailleur);
    protected abstract BikeBuilder withBrakes(String brakes);
    protected abstract Bike getBike();
}
