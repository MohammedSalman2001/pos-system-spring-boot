package com.possystem.possystemapi.dto.responseDto;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ResponseItemDto {
    private String description;
    private int qtyOnHand;
    private double unitePrice;
}
