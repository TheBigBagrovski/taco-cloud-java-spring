package com.example.tacos.controllers;

import com.example.tacos.models.TacoOrder;
import com.example.tacos.services.ClientService;
import com.example.tacos.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;
import java.security.Principal;


@Controller
@RequestMapping("/orders")
@SessionAttributes("tacoOrder")
public class OrderController {

    private final OrderService orderService;
    private final ClientService clientService;

    @Autowired
    public OrderController(OrderService orderService, ClientService clientService) {
        this.orderService = orderService;
        this.clientService = clientService;
    }

    @GetMapping("/current")
    public String order() {
        return "order";
    }

    @PostMapping
    public String processOrder(@Valid TacoOrder tacoOrder,
                               Errors errors,
                               SessionStatus sessionStatus,
                               Principal principal) {
        if (errors.hasErrors()) return "order";
        clientService.processTacoOrder(tacoOrder, principal.getName());
        orderService.save(tacoOrder);
        sessionStatus.setComplete();
        return "redirect:/";
    }

}