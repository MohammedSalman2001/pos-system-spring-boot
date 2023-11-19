package com.possystem.possystemapi.service;

import com.possystem.possystemapi.dto.requestDto.RequestCustomerDto;
import com.possystem.possystemapi.dto.responseDto.ResponseCustomerDto;

import java.util.List;

public interface CustomerService {

    public ResponseCustomerDto saveCustomer(RequestCustomerDto customer);
    public void deleteCustomer(String id);

    public ResponseCustomerDto updateCustomer(RequestCustomerDto customer);

    public ResponseCustomerDto searchCustomer(String id);

    public List<ResponseCustomerDto> getAllCustomer();
}
