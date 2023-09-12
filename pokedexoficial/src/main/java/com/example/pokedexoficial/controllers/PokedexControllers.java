package com.example.pokedexoficial.controllers;

import com.example.pokedexoficial.entities.PokedexEntities;
import com.example.pokedexoficial.repository.PokedexRepository;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController //Se utiliza para marcar una clase como un controlador en una aplicación web basada en Spring.
//Un controlador es responsable de manejar las solicitudes HTTP entrantes y devolver las respuestas correspondientes.
@RequestMapping("pokedex") //Se utiliza para mapear las solicitudes HTTP entrantes a los métodos de un controlador.
//Esta anotación permite asociar un método del controlador con una o más rutas de solicitud específicas.
public class PokedexControllers {
    private final PokedexRepository repository;

    public PokedexControllers(PokedexRepository repository) {
        this.repository = repository;
    }
    @GetMapping("/todos")
    @ApiOperation("Aquí verías a todos los pokemons de la pokedex.")
    public List<PokedexEntities> findAll(){
        return (List<PokedexEntities>) repository.findAll();
    }

    @GetMapping("/{id}")
    @ApiOperation("Buscaria al pokemon segun su id.")
    public ResponseEntity<PokedexEntities> findOne(@PathVariable Long id) {
        Optional<PokedexEntities> pokemonSolo = repository.findById(id);
        if (pokemonSolo.isPresent()) {
            PokedexEntities pokemon = pokemonSolo.get();
            // Aquí puedes añadir un comentario en la respuesta utilizando una cadena de mensaje personalizada
            String aciertoMessage = "Ole es un buen pokemon, aunque tu eres mas guapo <3 !";
            return ResponseEntity.ok().header("Acierto-Message", aciertoMessage).body(pokemon);
        } else {
            // Si el Pokémon con el ID proporcionado no existe, puedes devolver un ResponseEntity con un mensaje de error.
            String errorMessage = "Tio, el pokemon con id -> " + id + " no lo he encontrado!";
            return ResponseEntity.notFound().header("Error-Message", errorMessage).build();
        }
    }

    @PostMapping("/nuevo")
    @ApiOperation("Aqui podras añadir un pokemon pero con los datos que ya he dado.")
    public ResponseEntity<Object> create(@RequestBody PokedexEntities pokemon, @RequestHeader HttpHeaders headers) {
        String cambio = "Listo hemos añadido tu nuevo Pokemon";
        System.out.println(cambio);
        repository.save(pokemon);
        return ResponseEntity.ok().body(cambio);
    }

    @PutMapping("/modificar/{id}")
    @ApiOperation("Aqui puedes modificar un pokemon ya existente.")
    public ResponseEntity<String> modificar(@PathVariable Long id){
        Optional<PokedexEntities> optionalPokemon = repository.findById(id);
        if (optionalPokemon.isPresent()) {
            PokedexEntities pokemon = optionalPokemon.get();
            pokemon.setName("");
            pokemon.setTipo("");
            repository.save(pokemon);
            return ResponseEntity.ok("Cambio realizado mi Bro!");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/eliminar/{id}")
    @ApiOperation("Aqui podras eliminar un pokemon por el id.")
    public ResponseEntity<Object> eliminar(@PathVariable Long id){

        Optional<PokedexEntities> optionalPokemon = repository.findById(id);
        String eliminar = "Este pokemon es como moshe, inutil asi que mejor fuera";
        if (optionalPokemon.isPresent()){
            PokedexEntities pokemonToDelete = optionalPokemon.get();
            repository.delete(pokemonToDelete);
            System.out.println(eliminar);
            System.out.println("Vuela alto vaquero!");
            return ResponseEntity.noContent().header("Eliminado-Message", eliminar).build();
        }else {
            String errorMessage = "Tio, el pokemon con id -> " + id + " no lo he encontrado!";
            return ResponseEntity.notFound().header("Error-Message", errorMessage).build();
        }
    }
}