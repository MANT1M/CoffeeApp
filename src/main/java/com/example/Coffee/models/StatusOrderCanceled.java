package com.example.Coffee.models;

import com.example.Coffee.tables.OrderEvent;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;
@Data
@AllArgsConstructor
public class StatusOrderCanceled extends OrderEvent {
    private UUID orderId;
    private int employeeId;
    private String canceledReason;
    private String deliveryTimeLeft;

}
