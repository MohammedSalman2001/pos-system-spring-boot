package com.possystem.possystemapi.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@Entity
public class Customer {
    @Id
    public String cusId;
    @Column(unique = true)
    public String nic;
    public String name;
    public String address;
    public double salary;



}
