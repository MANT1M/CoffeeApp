package com.example.Coffee.models;

import com.example.Coffee.tables.OrderEvent;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

//Заказ выдан
@Data
@AllArgsConstructor
public class StatusOrderReady extends OrderEvent {
    private UUID orderId;
    private int employeeId;
    private String deliveryTimeLeft;
}
