package com.example.tacos;

import lombok.Data;

@Data
public class Ingredient {

    private final String id;
    private final String name;
    private final Category category;

    public enum Category {
        WRAP, PROTEIN, VEGGIES, SAUCE, CHEESE
    }

}
