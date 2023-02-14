package com.example.tacos;

import lombok.Data;
import org.hibernate.validator.constraints.CreditCardNumber;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class TacoOrder {

    private long id;

    private Date placedAt;

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

    @CreditCardNumber(message = "Not a valid credit card number") // проверка алгоритмом луна https://www.creditcardvalidator.org/articles/luhn-algorithm
    private String ccNumber;

    @Pattern(regexp = "^(0[1-9]|1[0-2])(/)([2-9][0-9])$", message = "Valid format: MM/YY")
    private String ccExpiration;

    @Pattern(regexp = "^[0-9]{3,4}$", message = "Invalid CVV") // @Digits не проверяет на минимальное число цифр
    private String ccCVV;

    private List<Taco> tacos = new ArrayList<>();

    public void addTaco(Taco taco) {
        this.tacos.add(taco);
    }
}
