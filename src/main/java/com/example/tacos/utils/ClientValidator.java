package com.example.tacos.utils;

import com.example.tacos.models.Client;
import com.example.tacos.services.ClientService;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


@Component
public class ClientValidator implements Validator {

    private final ClientService clientDetailsService;

    public ClientValidator(ClientService clientService) {
        this.clientDetailsService = clientService;
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
