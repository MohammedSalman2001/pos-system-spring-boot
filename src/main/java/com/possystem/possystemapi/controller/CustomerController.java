package com.possystem.possystemapi.controller;



import com.possystem.possystemapi.dto.requestDto.RequestCustomerDto;
import com.possystem.possystemapi.dto.responseDto.ResponseCustomerDto;
import com.possystem.possystemapi.service.CustomerService;
import com.possystem.possystemapi.util.StandResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/customers")
@CrossOrigin
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public ResponseEntity<StandResponse> save(@RequestBody RequestCustomerDto dto){
      /*  System.out.println(dto.toString());
        System.out.println("save customer");*/
        ResponseCustomerDto customerDto = customerService.saveCustomer(dto);
        return new ResponseEntity<StandResponse>(
                new StandResponse(200,"saved",customerDto), HttpStatus.CREATED
        );
    }

    @PutMapping
    public ResponseEntity<StandResponse> update(@RequestBody RequestCustomerDto dto){
        ResponseCustomerDto customerDto = customerService.updateCustomer(dto);
        return new ResponseEntity<StandResponse>(
                new StandResponse(200,"saved",customerDto), HttpStatus.CREATED
        );
    }

    @DeleteMapping(params = {"id"})
    public ResponseEntity<StandResponse> delete(@RequestParam String id){
        customerService.deleteCustomer(id);
        return new ResponseEntity<StandResponse>(
                new StandResponse(200,"saved",null), HttpStatus.CREATED
        );
    }

    @GetMapping(path = "list")
    public ResponseEntity<StandResponse> getAll(){
        List<ResponseCustomerDto> allCustomer = customerService.getAllCustomer();
        return new ResponseEntity<StandResponse>(
                new StandResponse(200,"saved",allCustomer), HttpStatus.CREATED
        );
    }

    @GetMapping(path = "{searchId}")
    public ResponseEntity<StandResponse> get(@PathVariable("searchId") String id){
        ResponseCustomerDto customerDto = customerService.searchCustomer(id);
        return new ResponseEntity<StandResponse>(
                new StandResponse(200,"searchId",customerDto), HttpStatus.CREATED
        );

    }
}
