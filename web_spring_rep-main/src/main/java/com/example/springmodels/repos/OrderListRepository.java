package com.example.springmodels.repos;

import com.example.springmodels.models.OrderList;
import com.example.springmodels.models.OrderListKey;
import org.springframework.data.repository.CrudRepository;

public interface OrderListRepository extends CrudRepository<OrderList, OrderListKey> {

}
