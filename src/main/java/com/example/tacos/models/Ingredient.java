package com.example.tacos.models;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
@AllArgsConstructor
public class Ingredient {

    @Id
    private String id;
    private String name;
    private Category category;

    public Ingredient() {

    }

    public enum Category {
        WRAP, PROTEIN, VEGGIES, SAUCE, CHEESE
    }

}
