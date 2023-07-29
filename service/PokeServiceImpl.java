package com.example.pokedexoficial.service;

import com.example.pokedexoficial.entities.PokedexEntities;
import com.example.pokedexoficial.repository.PokedexRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service //Se utiliza para marcar una clase como un componente de servicio. Indica que la clase es una clase de servicio
//y se utiliza para realizar operaciones relacionadas con la lógica de negocio de la aplicación.
public class PokeServiceImpl implements PokeService {

    private final PokedexRepository repository;

    public PokeServiceImpl(PokedexRepository repository) {
        this.repository = repository;
    }

    public List<PokedexEntities> getAllPokemons() {
        return repository.findAll();
    }

    public Optional<PokedexEntities> getPokemonById(Long id) {
        return repository.findById(id);
    }


    public PokedexEntities createPokemon(PokedexEntities pokemon) {
        return repository.save(pokemon);
    }

    public PokedexEntities updatePokemon(Long id, PokedexEntities updatedPokemon) {
        Optional<PokedexEntities> existingPokemon = repository.findById(id);
        if (existingPokemon.isPresent()) {
            updatedPokemon.setId(id);
            return repository.save(updatedPokemon);
        } else {
            throw new IllegalArgumentException("Pokemon with ID " + id + " not found.");
        }
    }

    public void deletePokemon(Long id) {
        repository.deleteById(id);
    }
}
