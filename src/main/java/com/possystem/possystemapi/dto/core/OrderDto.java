package com.possystem.possystemapi.dto.core;

import com.possystem.possystemapi.entity.Customer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderDto {
    private  String oid;
    private String date;
    private Customer customer;
    private List<OrderDetailsDto> orderDetails;
}
