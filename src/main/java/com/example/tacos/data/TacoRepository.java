package com.example.tacos.data;

import com.example.tacos.models.Taco;
import com.example.tacos.models.TacoOrder;
import org.springframework.data.repository.CrudRepository;

public interface TacoRepository extends CrudRepository<Taco, Long> {
}
