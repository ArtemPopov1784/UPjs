package com.example.springmodels.controllers;

import com.example.springmodels.models.Order;
import com.example.springmodels.models.OrderList;
import com.example.springmodels.repos.OrderListRepository;
import com.example.springmodels.repos.OrderRepository;
import com.example.springmodels.repos.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/product")
@PreAuthorize("hasAnyAuthority('PRODUCT_MANAGER')")
public class OrderController {

    OrderRepository orderRepository;
    OrderListRepository orderListRepository;

    @Autowired
    public OrderController(OrderRepository orderRepository, OrderListRepository orderListRepository) {
        this.orderRepository = orderRepository;
        this.orderListRepository = orderListRepository;
    }

    @GetMapping("/order")
    String index(Model model) {
        Iterable<OrderList> orderLists = orderListRepository.findAll();
        model.addAttribute("orderList", orderLists);
        return "productManager/order/index";
    }

}
