package com.possystem.possystemapi.dto.responseDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResponseCustomerDto {

    public String name;
    public String nic;
    public String address;
    public double salary;
}
