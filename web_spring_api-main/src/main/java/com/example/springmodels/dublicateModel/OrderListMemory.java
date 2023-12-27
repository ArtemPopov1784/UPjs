package com.example.springmodels.dublicateModel;

import com.example.springmodels.models.Order;
import com.example.springmodels.models.OrderList;
import com.example.springmodels.models.OrderListKey;
import com.example.springmodels.models.Product;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

@RestController
@PreAuthorize("hasAnyAuthority('PRODUCT_MANAGER')")
public class OrderListMemory {
    private int product_id;
    private int order_id;
    public OrderListMemory() {
    }
    public OrderListMemory(int product_id, int order_id) {
        this.product_id = product_id;
        this.order_id = order_id;
    }
    public OrderListMemory(Product product, Order order) {
        this.product_id = product.getId();
        this.order_id = order.getId();
    }
    public OrderListMemory(OrderList orderList) {
        this.product_id = orderList.getProduct().getId();
        this.order_id = orderList.getOrder().getId();
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }
}
