package com.example.tacos.services;

import com.example.tacos.data.OrderRepository;
import com.example.tacos.models.Taco;
import com.example.tacos.models.TacoOrder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Slf4j
@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Transactional
    public void save(TacoOrder tacoOrder) {
        orderRepository.save(tacoOrder);
        log.info("Order submitted: {}", tacoOrder);
    }

    public void processTaco(TacoOrder tacoOrder, Taco taco) {
        tacoOrder.addTaco(taco);
        log.info("Processing taco: {}", taco); // Logger
    }
}
