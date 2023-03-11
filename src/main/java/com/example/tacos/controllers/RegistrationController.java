package com.example.tacos.controllers;

import com.example.tacos.models.Client;
import com.example.tacos.services.RegistrationService;
import com.example.tacos.utils.ClientValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/register")
public class RegistrationController {

    private final RegistrationService registrationService;
    private final ClientValidator clientValidator;

    @Autowired
    public RegistrationController(RegistrationService registrationService, ClientValidator clientValidator) {
        this.registrationService = registrationService;
        this.clientValidator = clientValidator;
    }

    @GetMapping
    public String registerForm() {
        return "registration";
    }

    @ModelAttribute(name = "client")
    public Client client() {
        return new Client();
    }

    @PostMapping
    public String processRegistration(@ModelAttribute("client") @Valid Client client, BindingResult bindingResult) {
        clientValidator.validate(client, bindingResult);
        if (bindingResult.hasErrors()) return "registration";
        registrationService.register(client);
        return "redirect:/login";
    }

}
