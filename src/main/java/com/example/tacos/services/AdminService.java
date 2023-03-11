package com.example.tacos.services;

import com.example.tacos.data.ClientRepository;
import com.example.tacos.data.OrderRepository;
import com.example.tacos.data.TacoRepository;
import com.example.tacos.models.Client;
import com.example.tacos.models.Taco;
import com.example.tacos.models.TacoOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    private final OrderRepository orderRepository;
    private final ClientRepository clientRepository;
    private final TacoRepository tacoRepository;

    @Autowired
    public AdminService(OrderRepository orderRepository, ClientRepository clientRepository, TacoRepository tacoRepository) {
        this.orderRepository = orderRepository;
        this.clientRepository = clientRepository;
        this.tacoRepository = tacoRepository;
    }

    @PreAuthorize("hasRole('ADMIN')")
    public void deleteAllOrders() {
        for (TacoOrder tacoOrder : orderRepository.findAll()) {
            tacoOrder.getTacos().clear();
        }
        for (Taco taco : tacoRepository.findAll()) {
            taco.getIngredients().clear();
        }
        tacoRepository.deleteAll();
        for(Client client : clientRepository.findAll()) {
            client.getTacoOrders().clear();
        }
        orderRepository.deleteAll();
    }

}
