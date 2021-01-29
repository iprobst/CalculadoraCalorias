package com.meli.calorias.service.impl;

import com.meli.calorias.dto.InformacionPlatoDTO;
import com.meli.calorias.model.Ingrediente;
import com.meli.calorias.dao.CaloriaDAO;
import com.meli.calorias.dto.IngredienteDTO;
import com.meli.calorias.dto.PlatoDTO;
import com.meli.calorias.service.CaloriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CaloriaServiceImpl implements CaloriaService {
    @Autowired
    private CaloriaDAO caloriaDAO;


    @Override
    public int calcularCalorias(PlatoDTO platoDTO) {
        int totalCaloria = 0;
        for(Ingrediente ing : platoDTO.getIngredientes()) {
            IngredienteDTO ingDTO = caloriaDAO.buscarIngredientePorNombre(ing.getNombre());
            totalCaloria += ingDTO.getCalories();
        }
        return totalCaloria;
    }

    @Override
    public ArrayList<IngredienteDTO> caloriasPorIngrediente(PlatoDTO platoDTO) {
        ArrayList<IngredienteDTO> caloriasIngredientes = new ArrayList<>();
        for (Ingrediente ing: platoDTO.getIngredientes()){
            caloriasIngredientes.add(caloriaDAO.buscarIngredientePorNombre(ing.getNombre()));
        }
             return  caloriasIngredientes;
    }

    @Override
    public IngredienteDTO ingredienteMasCalorico(PlatoDTO platoDTO) {
        int caloriasMax = 0;
        IngredienteDTO masCalorico = new IngredienteDTO();
        for(Ingrediente ing : platoDTO.getIngredientes()) {
            IngredienteDTO ingDTO = caloriaDAO.buscarIngredientePorNombre(ing.getNombre());
            int caloriasActuales = ingDTO.getCalories();
            if(caloriasMax < caloriasActuales) {
                caloriasMax = caloriasActuales;
                masCalorico = ingDTO;
            }
        }
        return masCalorico;
    }

    @Override
    public ArrayList<InformacionPlatoDTO> obtenerInformacionPlatos(ArrayList<PlatoDTO> platoDTOS) {

        ArrayList<InformacionPlatoDTO> informacionPlatoDTOS = new ArrayList<>();

        for(PlatoDTO platoDTO: platoDTOS){
            InformacionPlatoDTO infoPlato = new InformacionPlatoDTO();
            infoPlato.setCaloriasIngredientes(caloriasPorIngrediente(platoDTO));
            infoPlato.setIngredienteMasCalorico(ingredienteMasCalorico(platoDTO));
            infoPlato.setTotalCalorias(calcularCalorias(platoDTO));
            informacionPlatoDTOS.add(infoPlato);
        }

        return informacionPlatoDTOS;

    }


}
