package com.possystem.possystemapi.dto.requestDto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RequestCustomerDto {

    private String id;
    private String name;
    private String address;
    private double salary;



}
