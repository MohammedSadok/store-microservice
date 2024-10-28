package com.sadok.market.productservice.dto;

import jakarta.validation.constraints.*;

public record ProductRequest(
        @NotBlank(message = "Name should not be blank")
        String name,

        @Size(max = 255, message = "Description must be 255 characters or less")
        String description,

        @Positive(message = "Price must be greater than zero")
        double price
) {
}
