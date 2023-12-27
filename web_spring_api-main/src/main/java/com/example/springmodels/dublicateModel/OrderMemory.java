package com.example.springmodels.dublicateModel;

import com.example.springmodels.models.Address;
import com.example.springmodels.models.Order;
import com.example.springmodels.models.Status;
import org.springframework.data.domain.Sort;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

public class OrderMemory {
    private int id;
    private LocalDate dateCreated;
    private int status_id;
    private int address_id;

    public OrderMemory(Order order){
        this.id = order.getId();
        this.dateCreated = LocalDate.now();
        this.status_id = order.getStatus().getId();
        this.address_id = order.getAddress().getId();
    }

    public OrderMemory() {
    }

    public OrderMemory(int id, LocalDate dateCreated, Status status, Address address) {
        this.id = id;
        this.dateCreated = LocalDate.now();
        this.status_id = status.getId();
        this.address_id = address.getId();
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

    public int getStatus_id() {
        return status_id;
    }

    public void setStatus_id(int status_id) {
        this.status_id = status_id;
    }

    public int getAddress_id() {
        return address_id;
    }

    public void setAddress_id(int address_id) {
        this.address_id = address_id;
    }
}
