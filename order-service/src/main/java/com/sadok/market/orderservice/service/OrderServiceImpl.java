package com.sadok.market.orderservice.service;

import com.sadok.market.orderservice.entity.Order;
import com.sadok.market.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service

public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Optional<Order> getOrderById(Integer id) {
        return orderRepository.findById(id);
    }

    @Override
    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order updateOrder(Integer id, Order updatedOrder) {
        return orderRepository.findById(id).map((order -> {
            order.setOrderDate(updatedOrder.getOrderDate());
            order.setOrderItems(updatedOrder.getOrderItems());
            order.setTotalAmount(updatedOrder.getTotalAmount());
            return orderRepository.save(order);
        })).orElseThrow(() -> new RuntimeException("Order not found"));
    }

    @Override
    public void deleteOrder(Integer id) {
        orderRepository.deleteById(id);
    }
}
