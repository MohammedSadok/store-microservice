package com.sadok.market.productservice.service;



import com.sadok.market.productservice.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    List<Product> getAllProducts();

    Product getProductById(Integer id);

    Product createProduct(Product product);

    Product updateProduct(Integer id, Product updatedProduct);

    void deleteProduct(Integer id);
}
