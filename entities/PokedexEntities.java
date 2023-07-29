package com.example.pokedexoficial.entities;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity //Se utiliza para marcar una clase como una entidad de persistencia. Indica que la clase representa una tabla
//en la base de datos y que sus instancias se pueden almacenar y recuperar de la base de datos.
@ApiModel(value = "Ejemplo de DB de la pokedex", description = "Aqui pondremos los datos de los pokemons")
public class PokedexEntities {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @ApiModelProperty(value = "ID del pokemon")
    private Long id;
    @ApiModelProperty(value = "Nombre del pokemon")
    private String name;
    @ApiModelProperty(value = "Tipo del pokemon")
    private String tipo;

    public PokedexEntities() {
    }

    public PokedexEntities(Long id, String name, String tipo) {
        this.id = id;
        this.name = name;
        this.tipo = tipo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
