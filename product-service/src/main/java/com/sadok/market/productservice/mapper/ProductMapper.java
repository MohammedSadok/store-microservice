package com.sadok.market.productservice.mapper;


import com.sadok.market.productservice.dto.ProductRequest;
import com.sadok.market.productservice.dto.ProductResponse;
import com.sadok.market.productservice.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    // Maps Product to ProductResponse
    ProductResponse toProductResponse(Product product);

    // Maps ProductRequest to Product
    @Mapping(target = "id", ignore = true)  // Ignore ID when creating new Product
    Product toProduct(ProductRequest productRequest);

    // Maps Product to Product (for updates)
    void updateProductFromRequest(ProductRequest productRequest, @MappingTarget Product product);
}
