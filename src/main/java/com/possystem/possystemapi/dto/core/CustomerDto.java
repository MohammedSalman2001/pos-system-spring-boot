package com.possystem.possystemapi.dto.core;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerDto {
    public String cusId;
    public String name;
    public String nic;
    public String address;
    public double salary;
}
