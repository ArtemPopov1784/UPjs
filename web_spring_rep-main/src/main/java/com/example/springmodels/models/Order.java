package com.example.springmodels.models;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private LocalDate dateCreated;

    @ManyToOne
    @JoinColumn(name = "status_id", nullable = false)
    private Status status;

    @ManyToOne
    @JoinColumn(name = "address_orders_id", nullable = false)
    private Address address;

    // Аннотация @ManyToMany указывает на отношение многие ко многим между текущей
    // сущностью и сущностью Product
    @ManyToMany
    // Аннотация @JoinTable определяет таблицу, которая будет содержать соответствия
    // между order_id и product_id
    @JoinTable(name = "order_list", joinColumns = @JoinColumn(name = "order_id"),
            // Аннотация @JoinColumn указывает на столбец в таблице, который содержит ссылку
            // на текущую сущность (order_id)
            // Аннотация @inverseJoinColumns указывает на столбец в таблице, который
            // содержит ссылку на связанную сущность (product_id)
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    // Поле products представляет собой список продуктов, связанных с текущим
    // заказом
    private List<Product> products;

    public Order(LocalDate dateCreated, Status status, List<Product> products) {
        this.dateCreated = dateCreated;
        this.status = status;
        this.products = products;
    }

    public Order(int id, LocalDate dateCreated, Status status, List<Product> products) {
        this.id = id;
        this.dateCreated = dateCreated;
        this.status = status;
        this.products = products;
    }

    public Order(int id, LocalDate dateCreated, Status status, Address address) {
        this.id = id;
        this.dateCreated = dateCreated;
        this.status = status;
        this.address = address;
    }

    public Order(LocalDate dateCreated, Status status, Address address) {
        this.dateCreated = dateCreated;
        this.status = status;
        this.address = address;
    }

    public Order() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
