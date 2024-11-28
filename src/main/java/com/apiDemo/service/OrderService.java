package com.apiDemo.service;

import com.apiDemo.model.GroceryItem;
import com.apiDemo.model.Order;

import java.util.List;

public interface OrderService {
    public Order createOrder(Order order);
    public List<?> getAvailableGroceryItems();
}
