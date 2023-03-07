package com.example.tacos.services;

import com.example.tacos.data.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AdminOrderService {

    private final OrderRepository orderRepository;

    public AdminOrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @PreAuthorize("hasRole('ADMIN')")
    public void deleteAllOrders() {
        orderRepository.deleteAll();
        log.info("Orders cleared");
    }

}
