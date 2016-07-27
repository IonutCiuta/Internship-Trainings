package com.endava.patterns.factory;

/**
 * Created by Andra on 7/21/2016.
 */
public class PokemonFactory {
    public static Pokemon getPokemon(PokemonType pokemonType) {
        switch (pokemonType) {
            case JIGGLYPUFF:
                return new JigglyPuff();
            case CHARMANDER:
                return new Charmander();
            default:
                return null;
        }
    }
}
