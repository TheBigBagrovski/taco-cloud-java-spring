package com.example.tacos.models;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table
public class Taco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date createdAt = new Date();

    @NotBlank
    @Size(min = 2, message = "At least 2 characters long")
    private String name;

    @NotNull
    @Size(min = 1, message = "At least 1 ingredient")
    @ManyToMany
    private List<Ingredient> ingredients;

}
