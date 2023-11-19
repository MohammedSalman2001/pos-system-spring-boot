package com.possystem.possystemapi.service;

import com.possystem.possystemapi.dto.core.OrderDto;
import com.possystem.possystemapi.dto.queryInterfaces.OrderDetailsInterface;
import com.possystem.possystemapi.dto.responseDto.ResponseOrderDetailsDto;
import com.possystem.possystemapi.entity.Orders;

import java.util.List;

public interface PlaceOrderService {
    public OrderDto saveOrder(OrderDto orderDto);

    public void delete(String id);

    public List<OrderDto> findAll();

    public List<ResponseOrderDetailsDto> getOrderDetailsJoinQuery();



}
