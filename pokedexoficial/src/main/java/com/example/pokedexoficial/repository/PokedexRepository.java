package com.example.pokedexoficial.repository;

import com.example.pokedexoficial.entities.PokedexEntities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository //Se utiliza para marcar una clase como un componente de repositorio. Indica que la clase es responsable de
//interactuar con la capa de persistencia de la aplicación, generalmente para realizar operaciones de acceso a la base
//de datos.
public interface PokedexRepository extends JpaRepository<PokedexEntities, Long> {
}
