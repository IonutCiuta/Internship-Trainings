package com.endava.patterns.factory;

/**
 * Created by Andra on 7/21/2016.
 */

public class FactoryDemo {
    public static void main(String args[]) {
        Pokemon jigglypuff = PokemonFactory.getPokemon(PokemonType.JIGGLYPUFF);
        System.out.println("Jigglypuff: " + jigglypuff.getType());

        Pokemon charmander = PokemonFactory.getPokemon((PokemonType.CHARMANDER));
        System.out.println("Charmander: " + charmander.getType());
    }
}
