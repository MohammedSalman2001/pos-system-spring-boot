package com.possystem.possystemapi.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@Entity
public class Customer {
    @Id
    public String cusId;
    public String name;
    public String address;
    public double salary;
}
