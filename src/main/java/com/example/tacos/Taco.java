package com.example.tacos;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Data
public class Taco {

    private long id;

    private Date createdAt;

    @NotNull
    @Size(min = 2, message = "At least 2 characters long")
    private String name;

    @NotNull
    @Size(min = 1, message = "At least 1 ingredient")
    private List<Ingredient> ingredients;

}
