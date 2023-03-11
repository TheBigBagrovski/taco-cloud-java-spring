package com.example.tacos.models;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table
public class TacoOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date placedAt = new Date();

    @NotBlank(message = "Name is required")
    private String deliveryName;

    @NotBlank(message = "Street is required")
    private String deliveryStreet;

    @NotBlank(message = "City is required")
    private String deliveryCity;

    @NotBlank(message = "State is required")
    private String deliveryState;

    @NotBlank(message = "Zip code is required")
    private String deliveryZip;

    @NotBlank(message = "Card number is required")
    //    @CreditCardNumber(message = "Not a valid credit card number")
    // проверка алгоритмом луна https://www.creditcardvalidator.org/articles/luhn-algorithm
    private String ccNumber;

    @NotBlank(message = "Card expiration date is required")
    @Pattern(regexp = "^(0[1-9]|1[0-2])(/)([2-9][0-9])$", message = "Valid format: MM/YY")
    private String ccExpiration;

    @NotBlank(message = "CVV is required")
    @Pattern(regexp = "^[0-9]{3,4}$", message = "Invalid CVV") // @Digits не проверяет на минимальное число цифр
    @Column(name = "cc_cvv")
    private String ccCVV;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Taco> tacos = new ArrayList<>();

    public void addTaco(Taco taco) {
        this.tacos.add(taco);
    }
}
