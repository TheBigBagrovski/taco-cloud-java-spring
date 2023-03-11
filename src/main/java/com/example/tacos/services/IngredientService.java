package com.example.tacos.services;

import com.example.tacos.data.IngredientRepository;
import com.example.tacos.models.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class IngredientService {

    private final IngredientRepository ingredientRepository;

    @Autowired
    public IngredientService(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    public Optional<Ingredient> findById(String id) {
        return ingredientRepository.findById(id);
    }

    public Iterable<Ingredient> findAll() {
        return ingredientRepository.findAll();
    }

}