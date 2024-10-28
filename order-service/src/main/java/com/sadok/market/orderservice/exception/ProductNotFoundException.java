package com.sadok.market.orderservice.exception;

public class ProductNotFoundException extends OrderServiceException {
    public ProductNotFoundException(String message) {
        super(message);
    }
}
