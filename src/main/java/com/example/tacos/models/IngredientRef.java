package com.example.tacos.models;

import lombok.Data;

import java.io.Serializable;

@Data
public class IngredientRef implements Serializable {
    private final String ingredient;
}
