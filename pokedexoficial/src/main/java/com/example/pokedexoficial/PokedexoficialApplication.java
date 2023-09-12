package com.example.pokedexoficial;

import com.example.pokedexoficial.data.DataLoader;
import com.example.pokedexoficial.entities.PokedexEntities;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import java.util.List;

@SpringBootApplication
public class PokedexoficialApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(PokedexoficialApplication.class, args);
		DataLoader dataLoader = context.getBean(DataLoader.class);

		List<PokedexEntities> pokemons = dataLoader.loadData();
		System.out.println("El número de pokemons en la pokedex es de -> " + pokemons.size());

		// Imprimir los nombres de los Pokémon
		System.out.println("Nombres de los Pokémon:");
		for (PokedexEntities pokemon : pokemons) {
			System.out.println(pokemon.getName());
		}
	}
}





