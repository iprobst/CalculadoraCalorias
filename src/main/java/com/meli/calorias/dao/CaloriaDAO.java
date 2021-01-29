package com.meli.calorias.dao;

import com.meli.calorias.dto.IngredienteDTO;

import java.util.List;

public interface CaloriaDAO {

    IngredienteDTO buscarIngredientePorNombre(String nombre);

    List<IngredienteDTO> cargarBaseDatos();
}
