package com.possystem.possystemapi.dto.responseDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResponseOrderDetailsDto {

//order
    private  String oId;
    private String date;
    private  String id;

    private String itemCode;
    private int qty;
    private double unitePrice;
}
