package com.possystem.possystemapi.service.impl;

import com.possystem.possystemapi.dto.core.CustomerDto;
import com.possystem.possystemapi.dto.requestDto.RequestCustomerDto;
import com.possystem.possystemapi.dto.responseDto.ResponseCustomerDto;
import com.possystem.possystemapi.entity.Customer;
import com.possystem.possystemapi.repo.CustomerRepo;
import com.possystem.possystemapi.service.CustomerService;
import com.possystem.possystemapi.util.Generator;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {


    private final CustomerRepo customerRepo;

    private  final ModelMapper mapper;

    private final Generator generator;

    @Autowired
    public CustomerServiceImpl(CustomerRepo customerRepo, ModelMapper mapper, Generator generator) {
        this.customerRepo = customerRepo;
        this.mapper = mapper;
        this.generator = generator;
    }

    @Override
    public ResponseCustomerDto saveCustomer(RequestCustomerDto dto) {
        CustomerDto customerDto = mapper.map(dto, CustomerDto.class);
        String customerId = generator.generateKey("customer");
        customerDto.setCusId(customerId);
        if(!customerRepo.existsByNic(customerDto.getNic())){
            return mapper.map(customerRepo.save(mapper.map(customerDto, Customer.class)),ResponseCustomerDto.class);
        }else {
            throw new RuntimeException("customer Nic :" + customerDto.getNic() +" Already Exist..!");
        }

    }

    @Override
    public ResponseCustomerDto updateCustomer(RequestCustomerDto dto) {
        CustomerDto customerDto = mapper.map(dto, CustomerDto.class);
        if(customerRepo.existsByNic(customerDto.getNic())){
            customerRepo.updateCustomer(customerDto.getName(), customerDto.getAddress(), customerDto.getSalary(), customerDto.getNic());
        return null;

        }else {
            throw new RuntimeException("customer Nic :" + customerDto.getNic() +" Not Found..!");
        }
    }

    @Override
    public void deleteCustomer(String nic) {

    }

    @Override
    public ResponseCustomerDto findCustomer(String nic) {
        if(customerRepo.existsByNic(nic)){
            return mapper.map(customerRepo.findByNic(nic),ResponseCustomerDto.class);
        }else{
            throw new RuntimeException("customer Nic :" + nic +" Not Found..!");
        }

    }

    @Override
    public List<ResponseCustomerDto> findAll() {
        return null;
    }
}
