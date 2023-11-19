package com.possystem.possystemapi.controller;

import com.possystem.possystemapi.dto.core.OrderDto;
import com.possystem.possystemapi.dto.responseDto.ResponseOrderDetailsDto;
import com.possystem.possystemapi.service.PlaceOrderService;
import com.possystem.possystemapi.util.StandResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @DeleteMapping(params = {"oid"})
    public ResponseEntity<StandResponse> delete(@RequestParam String oid){
        placeOrderService.delete(oid);
        return new ResponseEntity<>(
                new StandResponse(200,"Order deleted",null), HttpStatus.CREATED
        );
    }

    @GetMapping("/list")
    public ResponseEntity<StandResponse> findAll(){
        List<OrderDto> all = placeOrderService.findAll();
        return new ResponseEntity<>(
                new StandResponse(200,"get All",all), HttpStatus.CREATED
        );
    }

    @GetMapping("/place-order-join")
    public ResponseEntity<StandResponse> findJoinQueryData(){
        List<ResponseOrderDetailsDto> orderDetailsJoinQuery = placeOrderService.getOrderDetailsJoinQuery();
        return new ResponseEntity<>(
                new StandResponse(200,"get All",orderDetailsJoinQuery), HttpStatus.CREATED
        );
    }

    @PutMapping
    public ResponseEntity<StandResponse> update (@RequestBody OrderDto dto){
       placeOrderService.update(dto);
        return new ResponseEntity<>(
                new StandResponse(200,"get All",null), HttpStatus.CREATED
        );
    }


}
