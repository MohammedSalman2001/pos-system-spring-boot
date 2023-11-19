package com.possystem.possystemapi.dto.requestDto;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class RequestItemDto {
    private String description;
    private int qtyOnHand;
    private double unitePrice;
}
