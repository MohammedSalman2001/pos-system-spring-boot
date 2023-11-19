package com.possystem.possystemapi.repo;


import com.possystem.possystemapi.dto.queryInterfaces.OrderDetailsInterface;
import com.possystem.possystemapi.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PlaceOrderRepo extends JpaRepository<Orders,String> {


    @Query(nativeQuery = true,value = "SELECT o.oid,o.date,o.customerId as id, d.item_code as itemCode,d.qty,d.unite_price as unitePrice FROM orders o INNER JOIN order_details d on o.oid=d.oid")
    List<OrderDetailsInterface> getAllOrderDetails();


}
