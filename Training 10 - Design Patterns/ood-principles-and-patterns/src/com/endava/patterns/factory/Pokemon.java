package com.endava.patterns.factory;

/**
 * Created by Andra on 7/21/2016.
 */
public abstract class Pokemon {

    protected String type;

    protected Double weight;

    public String getType() {
        return type;
    }

    public Double getWeight() {
        return weight;
    }

    public Pokemon() {
        this.generatePokemon();
    }

    public abstract void generatePokemon();
}
