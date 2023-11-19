package com.possystem.possystemapi.repo;


import com.possystem.possystemapi.entity.Item;
import com.possystem.possystemapi.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaceOrderRepo extends JpaRepository<Orders,String> {


}
