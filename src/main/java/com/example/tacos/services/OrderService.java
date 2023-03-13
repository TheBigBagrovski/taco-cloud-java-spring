package com.example.tacos.services;

import com.example.tacos.data.ClientRepository;
import com.example.tacos.data.OrderRepository;
import com.example.tacos.models.Taco;
import com.example.tacos.models.TacoOrder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final ClientRepository clientRepository;

    public OrderService(OrderRepository orderRepository, ClientRepository clientRepository) {
        this.orderRepository = orderRepository;
        this.clientRepository = clientRepository;
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

    @Transactional
    public List<TacoOrder> findTacoOrdersByClientOrderByPlacedAtDesc(String username, int page, int itemsPerPage) {
        List<TacoOrder> orderList = new ArrayList<>();
        List<BigInteger> idList = clientRepository.findTacoOrdersByClientOrderByPlacedAtDesc(clientRepository.findByUsername(username).get().getId(), PageRequest.of(page, itemsPerPage)).getContent();
        for (BigInteger id : idList) {
            Long longId = id.longValue();
            orderList.add(orderRepository.findById(longId).get());
        }
        return orderList;
    }

}
