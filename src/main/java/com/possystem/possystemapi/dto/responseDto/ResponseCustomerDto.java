package com.possystem.possystemapi.dto.responseDto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResponseCustomerDto {

    private String id;
    private String name;
    private String address;
    private double salary;



}
