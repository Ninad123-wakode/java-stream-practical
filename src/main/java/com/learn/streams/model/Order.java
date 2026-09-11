package com.learn.streams.model;

import java.util.List;

public class Order {
    private String orderId;
    private List<Item> items;

    public Order(String orderId, List<Item> items) {
        this.orderId = orderId;
        this.items = items;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
