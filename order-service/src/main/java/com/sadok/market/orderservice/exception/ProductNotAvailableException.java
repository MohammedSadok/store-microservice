package com.sadok.market.orderservice.exception;

public class ProductNotAvailableException extends OrderServiceException {
    public ProductNotAvailableException(String message) {
        super(message);
    }
}
