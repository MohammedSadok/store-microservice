package com.sadok.market.orderservice.mapper;

import com.sadok.market.orderservice.dto.OrderDTO;
import com.sadok.market.orderservice.entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;


@Mapper(componentModel = "spring")
public interface OrderMapper {
    @Mapping(target = "orderItems", source = "orderItems")
    OrderDTO toDTO(Order order);

    @Mapping(target = "orderItems", source = "orderItems")
    Order toEntity(OrderDTO orderDTO);

    List<OrderDTO> toDTOList(List<Order> orders);
    List<Order> toEntityList(List<OrderDTO> orderDTOs);
}

