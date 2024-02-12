package com.example.Coffee.controllers;

import com.example.Coffee.models.Order;
import com.example.Coffee.models.StatusOrder;
import com.example.Coffee.service.Store;
import com.example.Coffee.tables.OrderEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Repository
    public class DbStore implements Store {
        private JdbcTemplate jdbcTemplate;

        @Autowired
        public DbStore(JdbcTemplate jdbcTemplate) {
            this.jdbcTemplate = jdbcTemplate;

        }


        @Override
        public void save(OrderEvent event) {
            String query = "INSERT INTO order_event(statusOrder, id_order, customerId) VALUES(?, ?, ?)";
            jdbcTemplate.update(query, event.getStatusOrder(), event.getId_order(), event.getCustomerId(),event.getDateTime());
        }
    //Поиск записей в бд
        @Override
        public List<Order> findByOrderId(int orderId) {
            List<Order> result = new ArrayList<>();
            String query = "SELECT * FROM events WHERE order_id = ?";
            List<Map<String, Object>> rows = jdbcTemplate.queryForList(query, orderId);

            for (Map<String, Object> row : rows) {
                Order order = new Order(
                        (UUID) row.get("id_order"),
                        (StatusOrder) row.get("statusOrder"),
                        (int) row.get("customerId"),
                        (String) row.get("deliveryTimeLeft")
                );

                result.add(new Order(order.getOrderId(), order.getStatusOrders(), order.getCustomerId(), order.getDeliveryTimeLeft()));
            }

            return result;
        }
    }

