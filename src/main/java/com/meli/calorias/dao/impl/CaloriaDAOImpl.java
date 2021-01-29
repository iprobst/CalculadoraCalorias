package com.meli.calorias.dao.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.calorias.dao.CaloriaDAO;
import com.meli.calorias.dto.IngredienteDTO;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Repository
public class CaloriaDAOImpl implements CaloriaDAO {


    @Override
    public IngredienteDTO buscarIngredientePorNombre(String nombre) {
        List<IngredienteDTO> ingredienteDTOS = null;
        ingredienteDTOS = cargarBaseDatos();
        IngredienteDTO result = null;
        if(ingredienteDTOS != null){
            Optional<IngredienteDTO> item = ingredienteDTOS.stream()
                    .filter(ingredienteDTO -> ingredienteDTO.getName().equals(nombre))
                    .findFirst();
            if(item.isPresent())
                result = item.get();
        }
        return result;
    }

    @Override
    public List<IngredienteDTO> cargarBaseDatos() {
        File file = null;
        try{
            file = ResourceUtils.getFile("classpath:food.json");
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<IngredienteDTO>> typeRef = new TypeReference<>() {};
        List<IngredienteDTO> ingredienteDTOS = null;
        try {
            ingredienteDTOS = objectMapper.readValue(file, typeRef);
        }catch (IOException e){
            e.printStackTrace();
        }
        return ingredienteDTOS;
    }
}
