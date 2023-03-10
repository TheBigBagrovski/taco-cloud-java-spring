package com.example.tacos.dto;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class AuthDTO {

    @NotBlank(message = "Username is required")
    @Size(min = 2, message = "At least 2 characters long")
    private String username;

    @NotBlank(message = "Password is required")
    @Size(min = 3, message = "At least 3 characters long")
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
