package com.sadok.market.productservice.dto;

public record ProductResponse(
        Long id,
        String name,
        String description,
        double price
) {
}

