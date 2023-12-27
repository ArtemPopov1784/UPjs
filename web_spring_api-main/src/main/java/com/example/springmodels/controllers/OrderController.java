package com.example.springmodels.controllers;

import com.example.springmodels.dublicateModel.OrderMemory;
import com.example.springmodels.models.Address;
import com.example.springmodels.models.Order;
import com.example.springmodels.models.Status;
import com.example.springmodels.repos.AddressRepository;
import com.example.springmodels.repos.OrderRepository;
import com.example.springmodels.repos.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@PreAuthorize("hasAnyAuthority('PRODUCT_MANAGER')")
public class OrderController {
    OrderRepository orderRepository;
    StatusRepository statusRepository;
    AddressRepository addressRepository;
    @Autowired
    public OrderController(OrderRepository orderRepository, StatusRepository statusRepository, AddressRepository addressRepository) {
        this.orderRepository = orderRepository;
        this.statusRepository = statusRepository;
        this.addressRepository = addressRepository;
    }

    @GetMapping("/orders")
    List<OrderMemory> index(){
        List<OrderMemory> orders = new ArrayList<>();
        for(Order order : orderRepository.findAll()){
            orders.add(new OrderMemory(order));
        }
        return orders;
    }
    @PostMapping("/orders")
    OrderMemory store(@RequestBody OrderMemory order){
        Status status = statusRepository.findById(order.getStatus_id()).orElseThrow();
        Address address =  addressRepository.findById(order.getAddress_id()).orElseThrow();

        order.setId(orderRepository.save(new Order(status, address)).getId());

        return order;
    }
    @PutMapping("/orders/{id}")
    OrderMemory update(@PathVariable(name = "id") int id, @RequestBody OrderMemory order){
        Status status = statusRepository.findById(order.getStatus_id()).orElseThrow();
        Address address =  addressRepository.findById(order.getAddress_id()).orElseThrow();

        Order orderToUpdate = orderRepository.findById(id).orElseThrow();
        orderToUpdate.setDateCreated(LocalDate.now());
        orderToUpdate.setAddress(address);
        orderToUpdate.setStatus(status);

        orderRepository.save(orderToUpdate);
        return order;
    }
    @DeleteMapping("/orders")
    OrderMemory delete(@RequestBody OrderMemory order){
        orderRepository.deleteById(order.getId());
        return order;
    }




}
