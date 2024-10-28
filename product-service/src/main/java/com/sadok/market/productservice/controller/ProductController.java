package com.sadok.market.productservice.controller;


import com.sadok.market.productservice.dto.ProductRequest;
import com.sadok.market.productservice.dto.ProductResponse;
import com.sadok.market.productservice.entity.Product;
import com.sadok.market.productservice.mapper.ProductMapper;
import com.sadok.market.productservice.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;
    private final ProductMapper productMapper;

    @GetMapping
    public List<ProductResponse> getAllProducts() {
        return productService.getAllProducts().stream().map(productMapper::toProductResponse).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> getProductById(@PathVariable Integer id) {
        Product product = productService.getProductById(id);
        return ResponseEntity.ok(productMapper.toProductResponse(product));
    }

    @PostMapping
    public ProductResponse createProduct(@RequestBody @Valid ProductRequest productRequest) {
        Product product = productMapper.toProduct(productRequest);
        Product savedProduct = productService.createProduct(product);
        return productMapper.toProductResponse(savedProduct);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductResponse> updateProduct(@PathVariable Integer id, @RequestBody @Valid ProductRequest productRequest) {
        try {
            Product existingProduct = productService.getProductById(id);
            productMapper.updateProductFromRequest(productRequest, existingProduct);
            Product updatedProduct = productService.updateProduct(id, existingProduct);
            return ResponseEntity.ok(productMapper.toProductResponse(updatedProduct));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Integer id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
}

