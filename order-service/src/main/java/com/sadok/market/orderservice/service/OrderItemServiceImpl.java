package com.sadok.market.orderservice.service;


import com.sadok.market.orderservice.entity.OrderItem;
import com.sadok.market.orderservice.repository.OrderItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@RequiredArgsConstructor
@Service
public class OrderItemServiceImpl implements OrderItemService {
    private final OrderItemRepository orderItemRepository;

    @Override
    public List<OrderItem> getAllOrderItems() {
        return orderItemRepository.findAll();
    }

    @Override
    public Optional<OrderItem> getOrderItemById(Integer id) {
        return orderItemRepository.findById(id);
    }

    @Override
    public OrderItem createOrderItem(OrderItem orderItem) {
        return orderItemRepository.save(orderItem);
    }

    @Override
    public OrderItem updateOrderItem(Integer id, OrderItem updatedOrderItem) {
        return orderItemRepository.findById(id)
                .map(orderItem -> {
                    orderItem.setQuantity(updatedOrderItem.getQuantity());
                    orderItem.setOrder(updatedOrderItem.getOrder());
                    return orderItemRepository.save(orderItem);
                })
                .orElseThrow(() -> new RuntimeException("OrderItem not found"));
    }

    @Override
    public void deleteOrderItem(Integer id) {
        orderItemRepository.deleteById(id);
    }
}
