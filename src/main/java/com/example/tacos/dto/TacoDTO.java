package com.example.tacos.dto;

import com.example.tacos.models.Ingredient;

import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

public class TacoDTO {

    @NotBlank(message = "Name your taco")
    @Size(min = 2, message = "At least 2 characters long")
    private String name;

    @NotNull
    @Size(min = 1, message = "At least 1 ingredient")
    private List<Ingredient> ingredients;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }
}
