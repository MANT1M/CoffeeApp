package com.example.Coffee.service;

import com.example.Coffee.models.Order;
import com.example.Coffee.tables.OrderEvent;

public interface OrderService {

        void publishEvent(OrderEvent event) throws Exception;

        Order findOrder(int id) throws Exception;


}
