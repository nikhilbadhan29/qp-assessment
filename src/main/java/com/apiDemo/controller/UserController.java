package com.apiDemo.controller;

import com.apiDemo.model.GroceryItem;
import com.apiDemo.model.Order;
import com.apiDemo.model.OrderItem;
import com.apiDemo.requestdto.OrderItemRequest;
import com.apiDemo.requestdto.OrderRequest;
import com.apiDemo.service.GroceryItemService;
import com.apiDemo.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final OrderService orderService;

    private final GroceryItemService groceryItemService;

    public UserController(OrderService orderService, GroceryItemService groceryItemService) {
        this.orderService = orderService;
        this.groceryItemService = groceryItemService;
    }

    @GetMapping("/grocery-items")
    public ResponseEntity<List<?>> getAvailableGroceryItems() {
        return ResponseEntity.ok(orderService.getAvailableGroceryItems());
    }

    @PostMapping("/orders")
    public ResponseEntity<Order> placeOrder(@RequestBody OrderRequest request) {
        Order order = new Order();
        order.setUserId(request.getUserId());
        order.setOrderDate(request.getOrderDate());

        List<OrderItem> orderItems = new ArrayList<>();
        for (OrderItemRequest itemRequest : request.getOrderItems()) {
            GroceryItem groceryItem = groceryItemService.getGroceryItem(itemRequest.getGroceryItemId());
            int groceryItemQuantity = groceryItem.getQuantity()-itemRequest.getQuantity();

            OrderItem orderItem = new OrderItem();
            orderItem.setOrder(order);
            orderItem.setGroceryItem(groceryItem);
            orderItem.setQuantity(itemRequest.getQuantity());
            orderItems.add(orderItem);
            
            //Updating existing Grocery Item to capture real-time changes
            groceryItem.setQuantity(groceryItemQuantity);
            groceryItem = groceryItemService.updateGroceryItem(itemRequest.getGroceryItemId(),groceryItem);
        }

        order.setOrderItems(orderItems);
        return ResponseEntity.ok(orderService.createOrder(order));
    }
}
