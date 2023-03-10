package com.example.tacos.data;

import com.example.tacos.models.Client;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ClientRepository extends CrudRepository<Client, Long> { // JPARep имеет больше функций, например пагинация, но они здесь не нужны

    Optional<Client> findByUsername(String username);

}
