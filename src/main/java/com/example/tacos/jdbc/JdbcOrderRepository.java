package com.example.tacos.jdbc;

import com.example.tacos.models.TacoOrder;
import org.springframework.transaction.annotation.Transactional;

public interface JdbcOrderRepository {
    @Transactional
    TacoOrder save(TacoOrder order);
}
