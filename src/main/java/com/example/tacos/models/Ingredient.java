package com.example.tacos.models;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@SuppressWarnings("JpaObjectClassSignatureInspection")
@Data
// @Table jdbc
@Entity
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
//@RequiredArgsConstructor
public class Ingredient /*implements Persistable*/ {

    @Id
    private String id;
    private String name;
    private Category category;

    public enum Category {
        WRAP, PROTEIN, VEGGIES, SAUCE, CHEESE
    }

}
