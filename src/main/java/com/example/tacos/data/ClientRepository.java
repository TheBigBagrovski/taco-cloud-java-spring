package com.example.tacos.data;

import com.example.tacos.models.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.math.BigInteger;
import java.util.Optional;

public interface ClientRepository extends CrudRepository<Client, Long> { // JPARep имеет больше функций, например пагинация, но они здесь не нужны

    Optional<Client> findByUsername(String username);

    @Query(value = "SELECT taco_orders_id FROM client_taco_orders WHERE client_id = ?1",
            countQuery = "SELECT count(taco_orders_id) FROM client_taco_orders WHERE client_id = ?1",
            nativeQuery = true)
    Page<BigInteger> findTacoOrdersByClientOrderByPlacedAtDesc(Long client_id, Pageable pageable);

}
