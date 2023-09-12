package com.example.pokedexoficial.data;

import com.example.pokedexoficial.entities.PokedexEntities;
import com.example.pokedexoficial.repository.PokedexRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component //Se utiliza para indicar que una clase es un componente de Spring y debe ser automáticamente detectado y
//registrado en el contexto de la aplicación durante la fase de escaneo de componentes.
public class DataLoader {

    private final PokedexRepository repository;

    @Autowired //Se utiliza para realizar la inyección de dependencias automáticamente en los beans de la aplicación.
    //Spring intentará resolver y asignar automáticamente el valor de ese campo o parámetro mediante la búsqueda de un
    //bean correspondiente en el contexto de la aplicación.
    public DataLoader(PokedexRepository repository) {
        this.repository = repository;
    }

    public List<PokedexEntities> loadData() {
        List<String> nombres = Arrays.asList(
                "Bulbasaur", "Ivysaur", "Venusaur", "Charmander", "Charmeleon",
                "Charizard", "Squirtle", "Wartortle", "Blastoise", "Caterpie",
                "Metapod", "Butterfree", "Weedle", "Kakuna", "Beedrill",
                "Pidgey", "Pidgeotto", "Pidgeot", "Rattata", "Raticate",
                "Spearow", "Fearow", "Ekans", "Arbok", "Pikachu",
                "Raichu", "Sandshrew", "Sandslash", "Nidoran♀", "Nidorina",
                "Nidoqueen", "Nidoran♂", "Nidorino", "Nidoking", "Clefairy",
                "Clefable", "Vulpix", "Ninetales", "Jigglypuff", "Wigglytuff",
                "Zubat", "Golbat", "Oddish", "Gloom", "Vileplume",
                "Paras", "Parasect", "Venonat", "Venomoth", "Diglett"
        );

        List<String> tipos = Arrays.asList(
                "Planta", "Planta", "Planta", "Fuego", "Fuego",
                "Fuego", "Agua", "Agua", "Agua", "Bicho",
                "Bicho", "Bicho", "Bicho", "Bicho", "Bicho",
                "Volador", "Volador", "Volador", "Normal", "Normal",
                "Volador", "Volador", "Veneno", "Veneno", "Eléctrico",
                "Eléctrico", "Tierra", "Tierra", "Veneno", "Veneno",
                "Veneno", "Veneno", "Veneno", "Hada", "Hada",
                "Fuego", "Fuego", "Hada", "Hada", "Veneno",
                "Volador", "Veneno", "Veneno", "Planta", "Planta",
                "Bicho", "Bicho", "Veneno", "Veneno", "Tierra"
        );

        List<PokedexEntities> pokemons = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            String name = nombres.get(i);
            String tipo = tipos.get(i);

            PokedexEntities pokemon = new PokedexEntities(name, tipo); // Aquí se utiliza el constructor con todos los argumentos
            pokemons.add(pokemon);
        }

        repository.saveAll(pokemons);
        return pokemons;
    }
}
