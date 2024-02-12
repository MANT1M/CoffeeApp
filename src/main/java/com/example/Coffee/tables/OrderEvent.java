package com.example.Coffee.tables;

import com.example.Coffee.models.Order;
import com.example.Coffee.models.StatusOrder;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name="order_event")
public class OrderEvent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_order;
    private StatusOrder statusOrder;
    private int customerId;
    private LocalDateTime dateTime;
    @PrePersist
    public void prePersist() {
        this.dateTime = LocalDateTime.now();
    }


}


