package com.example.tacos.jpa;

import com.example.tacos.models.TacoOrder;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<TacoOrder, Long> {
//    TacoOrder save(TacoOrder order);
}
