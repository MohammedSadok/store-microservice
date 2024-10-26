package com.sadok.market.orderservice.service;

import com.sadok.market.orderservice.entity.Order;

import java.util.List;
import java.util.Optional;

public interface OrderService {

    List<Order> getAllOrders();

    Optional<Order> getOrderById(Integer id);

    Order createOrder(Order order);

    Order updateOrder(Integer id, Order updatedOrder);

    void deleteOrder(Integer id);
}
