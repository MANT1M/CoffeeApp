package com.example.Coffee.tables;


import com.example.Coffee.models.Order;
import com.example.Coffee.models.StatusOrder;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="last_event")
public class LastEvents {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_order;
    private StatusOrder statusOrder;

}
