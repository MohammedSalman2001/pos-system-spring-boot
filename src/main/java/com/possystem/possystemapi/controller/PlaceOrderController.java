package com.possystem.possystemapi.controller;

import com.possystem.possystemapi.dto.core.OrderDto;
import com.possystem.possystemapi.service.PlaceOrderService;
import com.possystem.possystemapi.util.StandResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/orders")
public class PlaceOrderController {

    private final PlaceOrderService placeOrderService;

    public PlaceOrderController(PlaceOrderService placeOrderService) {
        this.placeOrderService = placeOrderService;
    }

    @PostMapping
    public ResponseEntity<StandResponse> save(@RequestBody OrderDto orderDto){
        placeOrderService.saveOrder(orderDto);
        return new ResponseEntity<>(
                new StandResponse(200,"Order saved",null), HttpStatus.CREATED
        );
    }
}
