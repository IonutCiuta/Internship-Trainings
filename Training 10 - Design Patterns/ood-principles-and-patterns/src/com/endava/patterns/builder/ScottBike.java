package com.endava.patterns.builder;

public class ScottBike implements Bike {

    private String derailleurBrand;
    private String brakesBrand;

    @Override
    public String getBrand() {
        return "Scott";
    }

    @Override
    public String getDerailleurBrand() {
        return derailleurBrand;
    }

    @Override
    public String getBrakesBrand() {
        return brakesBrand;
    }

    public void setDerailleurBrand(String derailleurBrand) {
        this.derailleurBrand = derailleurBrand;
    }

    public void setBrakesBrand(String brakesBrand) {
        this.brakesBrand = brakesBrand;
    }
}
