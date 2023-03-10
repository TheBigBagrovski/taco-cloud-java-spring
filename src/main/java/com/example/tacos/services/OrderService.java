package com.example.tacos.services;

import com.example.tacos.data.OrderRepository;
import com.example.tacos.models.Order;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Transactional
    public void save(Order order) {
        orderRepository.save(order);
    }

}
