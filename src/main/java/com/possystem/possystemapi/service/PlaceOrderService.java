package com.possystem.possystemapi.service;

import com.possystem.possystemapi.dto.core.OrderDto;

public interface PlaceOrderService {
    public OrderDto saveOrder(OrderDto orderDto);

}
