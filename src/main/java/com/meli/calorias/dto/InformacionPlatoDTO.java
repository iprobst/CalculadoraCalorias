package com.meli.calorias.dto;

import java.util.ArrayList;

public class InformacionPlatoDTO {

    private Integer totalCalorias;
    private ArrayList<IngredienteDTO> caloriasIngredientes;
    private IngredienteDTO ingredienteMasCalorico;

    public Integer getTotalCalorias() {
        return totalCalorias;
    }

    public void setTotalCalorias(Integer totalCalorias) {
        this.totalCalorias = totalCalorias;
    }

    public ArrayList<IngredienteDTO> getCaloriasIngredientes() {
        return caloriasIngredientes;
    }

    public void setCaloriasIngredientes(ArrayList<IngredienteDTO> caloriasIngredientes) {
        this.caloriasIngredientes = caloriasIngredientes;
    }

    public IngredienteDTO getIngredienteMasCalorico() {
        return ingredienteMasCalorico;
    }

    public void setIngredienteMasCalorico(IngredienteDTO ingredienteMasCalorico) {
        this.ingredienteMasCalorico = ingredienteMasCalorico;
    }
}
