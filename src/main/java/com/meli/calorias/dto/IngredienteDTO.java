package com.meli.calorias.dto;

public class IngredienteDTO {
    private String name;
    private Integer calories;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(Integer calories) {
        this.calories = calories;
    }
}
