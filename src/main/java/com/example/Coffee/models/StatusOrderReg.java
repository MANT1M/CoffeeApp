package com.example.Coffee.models;

import com.example.Coffee.tables.OrderEvent;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class StatusOrderReg extends OrderEvent {
    private UUID orderId;
    private int employeeId;
    private int customerId;
    private String deliveryTimeLeft;
    private int productId;
    private int price;

}
