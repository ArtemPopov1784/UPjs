package com.example.springmodels.models;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class OrderListKey implements Serializable {
    @Column(name = "product_id")
    private int productID;

    @Column(name = "order_id")
    private int orderID;

    public OrderListKey() {
    }

    public OrderListKey(int productID, int orderID) {
        this.productID = productID;
        this.orderID = orderID;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }
}
