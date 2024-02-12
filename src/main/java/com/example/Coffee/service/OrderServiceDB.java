package com.example.Coffee.service;

import com.example.Coffee.models.Order;
import com.example.Coffee.models.StatusOrder;
import com.example.Coffee.tables.OrderEvent;

import java.util.List;

public class OrderServiceDB implements OrderService{
    private LastEventStore lastEventStore;
    private Store store;

        public void OrderServiceDB(LastEventStore lastEventStore, Store store) {
            this.lastEventStore = lastEventStore;
            this.store = store;
        }

        @Override
        public void publishEvent(OrderEvent event) throws Exception {
            if (event.getStatusOrder() == StatusOrder.REG) {
                lastEventStore.create(event.getId_order(), event.getStatusOrder());
            }
            if (lastEventStore.count(event.getId_order()) == 0L) {
                throw new Exception("Could not type " + event.getStatusOrder() + " firstly");
            }

            boolean updated = lastEventStore.update(event.getId_order(), event.getStatusOrder());
            if (!updated) {
                throw new Exception("Could not type " + event.getStatusOrder() + " after it was done or canceled");
            }
            store.save(event);
        }

        @Override
        public Order findOrder(int orderId) throws Exception {
            List<Order> events = store.findByOrderId(orderId);
            if (events.isEmpty()) {
                throw new Exception("Order " + orderId + " not found");
            }
            return new Order(events);
        }
    }


