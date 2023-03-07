package com.example.tacos.models;

import lombok.Data;

@Data
public class Ingredient {

    private String id;
    private String name;
    private Category category;

    public enum Category {
        WRAP, PROTEIN, VEGGIES, SAUCE, CHEESE
    }

    public Ingredient(String id, String name, Category category) {
        this.id = id;
        this.name = name;
        this.category = category;
    }

}
