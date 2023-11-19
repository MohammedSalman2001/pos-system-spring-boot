package com.possystem.possystemapi.dto.core;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderDetailsDto {
    @Id
    private  String oid;

    @Id
    private String itemCode;

    private int qty;

    private double unitePrice;

}
