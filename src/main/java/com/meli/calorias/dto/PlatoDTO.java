package com.meli.calorias.dto;

import com.meli.calorias.model.Ingrediente;

import java.util.List;

public class PlatoDTO {
    private String nombre;
    private List<Ingrediente> ingredientes;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Ingrediente> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(List<Ingrediente> ingredientes) {
        this.ingredientes = ingredientes;
    }
}
