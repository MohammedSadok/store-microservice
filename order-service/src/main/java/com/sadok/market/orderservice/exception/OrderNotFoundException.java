package com.sadok.market.orderservice.exception;

// Specific Exceptions
public class OrderNotFoundException extends OrderServiceException {
    public OrderNotFoundException(String message) {
        super(message);
    }
}
