package com.sadok.market.orderservice.dto;

import java.time.LocalDate;
import java.util.List;

public record OrderDTO(
        Integer id,
        LocalDate orderDate,
        double totalAmount,
        List<OrderItemDTO> orderItems
) {}
