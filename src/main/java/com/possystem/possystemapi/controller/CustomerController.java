package com.possystem.possystemapi.controller;

import com.possystem.possystemapi.dto.requestDto.RequestCustomerDto;
import com.possystem.possystemapi.dto.responseDto.ResponseCustomerDto;
import com.possystem.possystemapi.service.CustomerService;
import com.possystem.possystemapi.util.StandResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public ResponseEntity<StandResponse> save(@RequestBody RequestCustomerDto dto){
        ResponseCustomerDto res = customerService.saveCustomer(dto);
        return new ResponseEntity<>(
                new StandResponse(200,"Customer saved",res), HttpStatus.CREATED
        );
    }

    @PutMapping
    public ResponseEntity<StandResponse> update(@RequestBody RequestCustomerDto dto){
        ResponseCustomerDto res = customerService.updateCustomer(dto);
        return new ResponseEntity<>(
                new StandResponse(200,"Customer saved",res), HttpStatus.CREATED
        );
    }

    
}
