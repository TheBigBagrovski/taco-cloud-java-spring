package com.example.tacos.dto;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class ClientDTO {

    @NotBlank(message = "Username is required")
    @Size(min = 2, message = "At least 2 characters long")
    private String username;

    @NotBlank(message = "Password is required")
    @Size(min = 3, message = "At least 3 characters long")
    private String password;

    @NotBlank(message = "Name is required")
    private String fullname;

    @NotBlank(message = "Phone number is required")
//    @Pattern(regexp = "^(\\s*)?(\\+)?([- _():=+]?\\d[- _():=+]?){10,14}(\\s*)?$")
    private String phoneNumber;

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

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
