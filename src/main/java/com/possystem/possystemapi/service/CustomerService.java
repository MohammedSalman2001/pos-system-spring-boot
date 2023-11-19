package com.possystem.possystemapi.service;

import com.possystem.possystemapi.dto.requestDto.RequestCustomerDto;
import com.possystem.possystemapi.dto.responseDto.ResponseCustomerDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CustomerService {

    public ResponseCustomerDto saveCustomer(RequestCustomerDto dto);
    public ResponseCustomerDto updateCustomer(RequestCustomerDto dto);
    public void deleteCustomer(String nic);
    public ResponseCustomerDto findCustomer(String nic);
    public List<ResponseCustomerDto>findAll();
}
