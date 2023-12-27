package com.example.springmodels.controllers;

import com.example.springmodels.dublicateModel.OrderListMemory;
import com.example.springmodels.dublicateModel.OrderMemory;
import com.example.springmodels.models.*;
import com.example.springmodels.repos.AddressRepository;
import com.example.springmodels.repos.OrderListRepository;
import com.example.springmodels.repos.OrderRepository;
import com.example.springmodels.repos.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@PreAuthorize("hasAnyAuthority('PRODUCT_MANAGER')")
public class OrderListController {
    OrderListRepository orderListRepository;
    ProductRepository productRepository;
    OrderRepository orderRepository;

    @Autowired
    public OrderListController(OrderListRepository orderListRepository, ProductRepository productRepository, OrderRepository orderRepository) {
        this.orderListRepository = orderListRepository;
        this.productRepository = productRepository;
        this.orderRepository = orderRepository;
    }

    @GetMapping("/orderLists")
    List<OrderListMemory> index() {
        List<OrderListMemory> orderLists = new ArrayList<>();
        for (OrderList orderList : orderListRepository.findAll()) {
            orderLists.add(new OrderListMemory(orderList));
        }
        return orderLists;
    }

    @PostMapping("/orderLists")
    OrderListMemory store(@RequestBody OrderListMemory orderListMemory) {
        Product product = productRepository.findById(orderListMemory.getProduct_id()).orElseThrow();
        Order order = orderRepository.findById(orderListMemory.getOrder_id()).orElseThrow();
        orderListRepository.save(new OrderList(product, order));
        return orderListMemory;
    }

    @DeleteMapping("/orderLists")
    OrderListMemory delete(@RequestBody OrderListMemory orderListMemory) {
        OrderList orderList = orderListRepository.findById(new OrderListKey(orderListMemory.getProduct_id(), orderListMemory.getOrder_id())).orElseThrow();
        orderListRepository.delete(orderList);
        return orderListMemory;
    }
}
