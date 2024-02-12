package com.example.Coffee.models;


import com.example.Coffee.service.Store;
import com.example.Coffee.tables.OrderEvent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.*;
import java.util.UUID;

@AllArgsConstructor
@Data

public class Order {
    private UUID orderId;   //уникальный id заказа
    private int customerId; //заказчик
    private int employeeId;  //сотрудник
    private String  deliveryTimeLeft;
    private String cancelReason; //причина отмены
    private int productId;
    private int price;  //стоимость заказа

    private StatusOrder statusOrders;  //статус заказа
    private LocalDateTime orderTimeCreation;
    private List<Order> events;



    public Order(UUID orderId, StatusOrder statusOrders,  int customerId, String deliveryTimeLeft) {
        this.orderId =orderId;
        this.statusOrders=statusOrders;
        this.customerId=customerId;
        this.deliveryTimeLeft=deliveryTimeLeft;
    }

    public Order(List<Order> events) {
        this.events=events;
    }






}
