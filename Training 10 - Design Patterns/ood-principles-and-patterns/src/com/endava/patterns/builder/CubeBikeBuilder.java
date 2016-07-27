package com.endava.patterns.builder;

public class CubeBikeBuilder extends BikeBuilder {

    private CubeBike bike;

    @Override
    protected BikeBuilder buildBike() {
        this.bike = new CubeBike();
        return this;
    }

    @Override
    protected BikeBuilder withDerailleur(String derailleur) {
        bike.setDerailleurBrand(derailleur);
        return this;
    }

    @Override
    protected BikeBuilder withBrakes(String brakes) {
        bike.setBrakesBrand(brakes);
        return this;
    }

    @Override
    protected Bike getBike() {
        return bike;
    }
}
