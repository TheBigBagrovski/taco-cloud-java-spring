package com.example.tacos.data;

import com.example.tacos.models.TacoOrder;

public interface OrderRepository {

    TacoOrder save(TacoOrder order);

}
