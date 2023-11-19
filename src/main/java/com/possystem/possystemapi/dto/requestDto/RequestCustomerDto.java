package com.possystem.possystemapi.dto.requestDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RequestCustomerDto {
    public String name;
    public String nic;
    public String address;
    public double salary;
}
