package com.example.tacos.utils;

import com.example.tacos.models.Ingredient;
import com.example.tacos.models.Ingredient.*;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component // класс создается как bean компонент
public class IngredientByIdConverter implements Converter<String, Ingredient> {

    private final Map<String, Ingredient> ingredientMap = new HashMap<>();

    public IngredientByIdConverter() { // пока нет БД конвертируем в коде
        ingredientMap.put("FLTO", new Ingredient("FLTO", "Flour Tortilla", Category.WRAP));
        ingredientMap.put("COTO", new Ingredient("COTO", "Corn Tortilla", Category.WRAP));
        ingredientMap.put("GRBF", new Ingredient("GRBF", "Ground Beef", Category.PROTEIN));
        ingredientMap.put("CARN", new Ingredient("CARN", "Carnitas", Category.PROTEIN));
        ingredientMap.put("TMTO", new Ingredient("TMTO", "Diced Tomatoes", Category.VEGGIES));
        ingredientMap.put("LETC", new Ingredient("LETC", "Lettuce", Category.VEGGIES));
        ingredientMap.put("CHED", new Ingredient("CHED", "Cheddar", Category.CHEESE));
        ingredientMap.put("JACK", new Ingredient("JACK", "Monterrey Jack", Category.CHEESE));
        ingredientMap.put("SLSA", new Ingredient("SLSA", "Salsa", Category.SAUCE));
        ingredientMap.put("SRCR", new Ingredient("SRCR", "Sour Cream", Category.SAUCE));
    }

    @Override
    public Ingredient convert(String id) {
        return ingredientMap.get(id);
    }

}