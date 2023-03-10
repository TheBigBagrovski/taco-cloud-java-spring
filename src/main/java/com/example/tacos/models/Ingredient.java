package com.example.tacos.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table
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
