package com.sadok.market.orderservice.dto;

public record OrderItemDTO(
        Integer id,
        Integer productId,
        int quantity
) {}
