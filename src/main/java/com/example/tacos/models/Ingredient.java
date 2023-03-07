package com.example.tacos.models;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class Ingredient {

    private String id;
    private String name;
    private Category category;

    public enum Category {
        WRAP, PROTEIN, VEGGIES, SAUCE, CHEESE
    }

}
