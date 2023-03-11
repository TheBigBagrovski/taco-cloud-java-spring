package com.example.tacos.utils;

import com.example.tacos.models.Ingredient;
import com.example.tacos.services.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component // класс создается как bean компонент
public class IngredientByIdConverter implements Converter<String, Ingredient> {

    private final IngredientService ingredientService;

    @Autowired
    public IngredientByIdConverter(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @Override
    public Ingredient convert(String id) {
        return ingredientService.findById(id).orElse(null);
    }

}