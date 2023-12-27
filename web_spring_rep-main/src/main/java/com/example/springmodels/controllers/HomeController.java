package com.example.springmodels.controllers;

import com.example.springmodels.models.*;
import com.example.springmodels.repos.AddressRepository;
import com.example.springmodels.repos.OrderListRepository;
import com.example.springmodels.repos.OrderRepository;
import com.example.springmodels.repos.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.net.http.HttpRequest;

@Controller
public class HomeController {

    ProductRepository productRepository;
    OrderListRepository orderListRepository;
    OrderRepository orderRepository;

    @Autowired
    public HomeController(ProductRepository productRepository, OrderListRepository orderListRepository, OrderRepository orderRepository) {
        this.productRepository = productRepository;
        this.orderListRepository = orderListRepository;
        this.orderRepository = orderRepository;
    }

    @GetMapping("/")
    String index(){
//        Product product = productRepository.findById(1).orElseThrow();
//        Order order = orderRepository.findById(4).orElseThrow();
//        OrderListKey orderListKey = new OrderListKey(product.getId(), order.getId());
//        orderListRepository.save(new OrderList(orderListKey, product, order));
        return "index";
    }
}
