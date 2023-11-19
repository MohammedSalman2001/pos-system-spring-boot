package com.possystem.possystemapi.dto.core;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ItemDto {
    private String code;
    private String description;
    private int qtyOnHand;
    private double unitePrice;
}
