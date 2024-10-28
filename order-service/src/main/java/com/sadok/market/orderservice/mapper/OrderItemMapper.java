package com.sadok.market.orderservice.mapper;

import com.sadok.market.orderservice.dto.OrderItemDTO;
import com.sadok.market.orderservice.entity.OrderItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderItemMapper {
    @Mapping(target = "productId", source = "productId")
    OrderItemDTO toDTO(OrderItem orderItem);

    @Mapping(target = "order", ignore = true)
    OrderItem toEntity(OrderItemDTO orderItemDTO);

    List<OrderItemDTO> toDTOList(List<OrderItem> orderItems);
    List<OrderItem> toEntityList(List<OrderItemDTO> orderItemDTOs);
}
