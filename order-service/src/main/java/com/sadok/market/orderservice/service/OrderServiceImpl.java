package com.sadok.market.orderservice.service;

import com.sadok.market.orderservice.controller.ProductServiceClient;
import com.sadok.market.orderservice.dto.ProductDTO;
import com.sadok.market.orderservice.entity.Order;
import com.sadok.market.orderservice.entity.OrderItem;
import com.sadok.market.orderservice.exception.OrderNotFoundException;
import com.sadok.market.orderservice.exception.ProductNotFoundException;
import com.sadok.market.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final ProductServiceClient productServiceClient;

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Optional<Order> getOrderById(Integer id) {
        return orderRepository.findById(id);
    }

    @Override
    @Transactional
    public Order createOrder(Order order) {
        validateProducts(order.getOrderItems());
        calculateTotalAmount(order);
        return orderRepository.save(order);
    }

    @Override
    @Transactional
    public Order updateOrder(Integer id, Order updatedOrder) {
        return orderRepository.findById(id)
                .map(existingOrder -> {
                    validateProducts(updatedOrder.getOrderItems());
                    existingOrder.setOrderDate(updatedOrder.getOrderDate());
                    existingOrder.setOrderItems(updatedOrder.getOrderItems());
                    calculateTotalAmount(existingOrder);
                    return orderRepository.save(existingOrder);
                })
                .orElseThrow(() -> new OrderNotFoundException("Order not found with id: " + id));
    }

    @Override
    public void deleteOrder(Integer id) {
        orderRepository.deleteById(id);
    }

    private void validateProducts(List<OrderItem> orderItems) {
        orderItems.forEach(item -> {
            ProductDTO product = productServiceClient.getProduct(item.getProductId());
            if (product == null) {
                throw new ProductNotFoundException("Product not found with id: " + item.getProductId());
            }
        });
    }

    private void calculateTotalAmount(Order order) {
        double totalAmount = order.getOrderItems().stream()
                .mapToDouble(item -> {
                    ProductDTO product = productServiceClient.getProduct(item.getProductId());
                    return product.price() * item.getQuantity();
                })
                .sum();
        order.setTotalAmount(totalAmount);
    }
}
