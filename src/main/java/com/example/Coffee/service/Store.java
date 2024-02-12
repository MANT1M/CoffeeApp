package com.example.Coffee.service;

import com.example.Coffee.models.Order;
import com.example.Coffee.tables.OrderEvent;

import java.util.List;

public interface Store {
    void save(OrderEvent event);

    List<Order> findByOrderId(int orderId);

}
