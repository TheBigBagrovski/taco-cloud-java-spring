package com.example.tacos.utils;

import com.example.tacos.models.Client;
import com.example.tacos.services.ClientDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


@Component
public class ClientValidator implements Validator {

    private final ClientDetailsService clientDetailsService;

    public ClientValidator(ClientDetailsService clientDetailsService) {
        this.clientDetailsService = clientDetailsService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Client.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Client client = (Client) target;
        if(clientDetailsService.findByUsername(client.getUsername()).isPresent()) {
            errors.rejectValue("username", "", "Username is taken");
        }
    }
}
