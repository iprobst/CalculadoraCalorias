package com.meli.calorias.service;

import com.meli.calorias.dto.InformacionPlatoDTO;
import com.meli.calorias.dto.IngredienteDTO;
import com.meli.calorias.dto.PlatoDTO;

import java.util.ArrayList;

public interface CaloriaService {
    int calcularCalorias(PlatoDTO platoDTO);

    ArrayList<IngredienteDTO> caloriasPorIngrediente(PlatoDTO plato);

    IngredienteDTO ingredienteMasCalorico(PlatoDTO platoDTO);

    ArrayList<InformacionPlatoDTO> obtenerInformacionPlatos(ArrayList<PlatoDTO> platoDTOS);


}
