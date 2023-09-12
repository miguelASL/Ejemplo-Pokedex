package com.example.pokedexoficial.service;

import com.example.pokedexoficial.entities.PokedexEntities;
import java.util.List;
import java.util.Optional;

public interface PokedexService {
    List<PokedexEntities> getAllPokemons();
    Optional<PokedexEntities> getPokemonById(Long id);
    PokedexEntities createPokemon(PokedexEntities pokemon);
    PokedexEntities updatePokemon(Long id, PokedexEntities updatedPokemon);
    void deletePokemon(Long id);
}


