package com.example.tacos.jdbc;

import com.example.tacos.models.Ingredient;

import java.util.Optional;

public interface JdbcIngredientRepository {
    Iterable<Ingredient> findAll();

    Optional<Ingredient> findById(String id);

    Ingredient save(Ingredient ingredient);
}
