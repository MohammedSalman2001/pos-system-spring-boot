package com.possystem.possystemapi.repo;

import com.possystem.possystemapi.entity.OrderDetails;
import com.possystem.possystemapi.entity.OrderItem_PK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailsRepo extends JpaRepository<OrderDetails, OrderItem_PK> {
}
