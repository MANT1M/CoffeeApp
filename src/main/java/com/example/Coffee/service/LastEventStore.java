package com.example.Coffee.service;


import com.example.Coffee.models.Order;
import com.example.Coffee.models.StatusOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class LastEventStore {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public LastEventStore(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


        public void create(int orderId, StatusOrder type) {
            String sql = "INSERT INTO order_event(id_order, statusOrder) " +
                    "VALUES (?, ?) ON CONFLICT DO NOTHING";
            jdbcTemplate.update(sql, orderId, type.getValue());
        }

        public boolean update(int orderId, StatusOrder type) {
            String sql = "UPDATE last_event SET event_type = ? " +
                    "WHERE order_id = ? AND event_type in (0, 1, 2)";
            int rowsUpdated = jdbcTemplate.update(sql, type.getValue(), orderId);
            return rowsUpdated > 0;
        }

        public long count(int orderId) {
            String sql = "SELECT count(order_id) FROM last_event " +
                    "WHERE order_id = ?";
            return jdbcTemplate.queryForObject(sql, Long.class, orderId);
        }
    }

