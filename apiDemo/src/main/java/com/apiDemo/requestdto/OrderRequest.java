package com.apiDemo.requestdto;

import java.util.Date;
import java.util.List;

public class OrderRequest {
    private Long userId;
    private Date orderDate;
    private List<OrderItemRequest> orderItems;

    public OrderRequest(){

    }

    public OrderRequest(Long userId, Date orderDate, List<OrderItemRequest> orderItems) {
        this.userId = userId;
        this.orderDate = orderDate;
        this.orderItems = orderItems;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public List<OrderItemRequest> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItemRequest> orderItems) {
        this.orderItems = orderItems;
    }
}
