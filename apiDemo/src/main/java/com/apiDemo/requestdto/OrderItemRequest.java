package com.apiDemo.requestdto;

public class OrderItemRequest {
    private Long groceryItemId;
    private int quantity;

    public OrderItemRequest(){

    }

    public OrderItemRequest(Long groceryItemId, int quantity) {
        this.groceryItemId = groceryItemId;
        this.quantity = quantity;
    }

    public Long getGroceryItemId() {
        return groceryItemId;
    }

    public void setGroceryItemId(Long groceryItemId) {
        this.groceryItemId = groceryItemId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // Getters and Setters
}

