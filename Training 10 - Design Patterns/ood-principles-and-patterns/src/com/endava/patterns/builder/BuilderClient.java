package com.endava.patterns.builder;

public class BuilderClient {

    public static void main(String[] args) {
        Bike bike;
        ScottBikeBuilder scottBikeBuilder = new ScottBikeBuilder();
        bike = scottBikeBuilder.buildBike().getBike();
        scottBikeBuilder.withBrakes("dsd");
        bike = scottBikeBuilder.getBike();
        printBikeDetails(bike);
        bike = new CubeBikeBuilder().buildBike().withDerailleur("Shimano Alivio").withBrakes("Avid Elixir").getBike();
        printBikeDetails(bike);
    }

    public static void printBikeDetails(Bike bike) {
        System.out.println("I created a " + bike.getBrand() + " bike with " + bike.getDerailleurBrand() + " derailleur and " + bike.getBrakesBrand() + " brakes.");
    }

}
