package com.example.tacos.jpa;

import com.example.tacos.models.Ingredient;
import org.springframework.data.repository.CrudRepository;

public interface IngredientRepository extends CrudRepository<Ingredient, String> {

//    List<Ingredient> findAll();

//    Optional<Ingredient> findById(String id);

//    Ingredient save(Ingredient ingredient);

}
