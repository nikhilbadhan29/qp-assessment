package com.apiDemo.service.impl;

import com.apiDemo.model.Order;
import com.apiDemo.repository.GroceryItemRepository;
import com.apiDemo.repository.OrderRepository;
import com.apiDemo.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImplementation implements OrderService {
    OrderRepository orderRepository;
    GroceryItemRepository groceryItemRepository;

    public OrderServiceImplementation(OrderRepository orderRepository, GroceryItemRepository groceryItemRepository) {
        this.orderRepository = orderRepository;
        this.groceryItemRepository = groceryItemRepository;
    }

    @Override
    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public List<?> getAvailableGroceryItems() {
        return groceryItemRepository.findAll();
    }
}
