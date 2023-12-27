package com.example.springmodels.repos;

import com.example.springmodels.models.OrderList;
import com.example.springmodels.models.OrderListKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderListRepository extends JpaRepository<OrderList, OrderListKey> {

}
