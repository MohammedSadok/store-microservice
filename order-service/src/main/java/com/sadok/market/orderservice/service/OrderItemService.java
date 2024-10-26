package com.sadok.market.orderservice.service;


import com.sadok.market.orderservice.entity.OrderItem;

import java.util.List;
import java.util.Optional;
public interface OrderItemService {
    List<OrderItem> getAllOrderItems();

    Optional<OrderItem> getOrderItemById(Integer id);

    OrderItem createOrderItem(OrderItem orderItem);

    OrderItem updateOrderItem(Integer id, OrderItem updatedOrderItem);

    void deleteOrderItem(Integer id);
}
