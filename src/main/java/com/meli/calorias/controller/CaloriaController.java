package com.meli.calorias.controller;

import com.meli.calorias.dto.InformacionPlatoDTO;
import com.meli.calorias.dto.IngredienteDTO;
import com.meli.calorias.dto.PlatoDTO;
import com.meli.calorias.model.Ingrediente;
import com.meli.calorias.service.CaloriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/comida")
public class CaloriaController {

    @Autowired
    private CaloriaService caloriaService;

    @PostMapping("/totalCaloria")
    @ResponseBody
    public String obtenerTotalCaloria(@RequestBody PlatoDTO platoDTO){
        return "Calorias totales: " + caloriaService.calcularCalorias(platoDTO);
    }

    @PostMapping("/caloriasIngredientes")
    @ResponseBody
    public ArrayList<IngredienteDTO> obtenerCaloriasIngredientes(@RequestBody PlatoDTO platoDTO){
        return caloriaService.caloriasPorIngrediente(platoDTO);
    }

    @PostMapping("/ingredienteMasCalorico")
    @ResponseBody
    public IngredienteDTO ingredienteMasCalorico(@RequestBody PlatoDTO platoDTO){
        return caloriaService.ingredienteMasCalorico(platoDTO);
    }

    @PostMapping("/informacionPlatos")
    @ResponseBody
    public ArrayList<InformacionPlatoDTO> obtenerInformacionPlatos(@RequestBody ArrayList<PlatoDTO> platosDTOS){
        return caloriaService.obtenerInformacionPlatos(platosDTOS);
    }
}
