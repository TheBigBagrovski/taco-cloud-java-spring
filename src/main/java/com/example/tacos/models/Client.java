package com.example.tacos.models;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@Entity
@Table
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "Username is required")
    @Size(min = 2, message = "At least 2 characters long")
    @Column(unique = true)
    private String username;

    @NotBlank(message = "Password is required")
    @Size(min = 3, message = "At least 3 characters long")
    private String password;

    @NotBlank(message = "Name is required")
    private String fullname;

    @NotBlank(message = "Phone number is required")
//    @Pattern(regexp = "^(\\s*)?(\\+)?([- _():=+]?\\d[- _():=+]?){10,14}(\\s*)?$")
    private String phoneNumber;

    private String role;

}
