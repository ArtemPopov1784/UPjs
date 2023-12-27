package com.example.springmodels.models;

import javax.persistence.*;

@Entity
@Table(name = "order_list")
public class OrderList {

    @EmbeddedId
    OrderListKey id;

    @ManyToOne
    @MapsId("productID")
    @JoinColumn(name = "product_id")
    Product product;

    @ManyToOne
    @MapsId("orderID")
    @JoinColumn(name = "order_id")
    Order order;

    public OrderList() {
    }

    public OrderList(OrderListKey id) {
        this.id = id;
    }

    public OrderList(OrderListKey id, Product product, Order order) {
        this.id = id;
        this.product = product;
        this.order = order;
    }

    public OrderList(Product product, Order order) {
        this.product = product;
        this.order = order;
    }

    public OrderListKey getId() {
        return id;
    }

    public void setId(OrderListKey id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
