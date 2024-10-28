package com.sadok.market.orderservice.controller;


import com.sadok.market.orderservice.dto.ProductDTO;
import com.sadok.market.orderservice.exception.ProductNotFoundException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

// Product Service Client
@FeignClient(name = "product-service")
public interface ProductServiceClient {
    @GetMapping("/products/{id}")
    @CircuitBreaker(name = "productService", fallbackMethod = "getProductFallback")
    @Retry(name = "productService")
    ProductDTO getProduct(@PathVariable Integer id);

    default ProductDTO getProductFallback(Integer id, Exception ex) {a
        throw new ProductNotFoundException("Product not found with id: " + id);
    }
}
