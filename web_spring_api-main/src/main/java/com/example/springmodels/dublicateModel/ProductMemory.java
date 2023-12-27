package com.example.springmodels.dublicateModel;

import com.example.springmodels.models.Category;
import com.example.springmodels.models.Product;

import javax.persistence.Column;

public class ProductMemory {
    private int id;
    private String name;
    private double price;
    private String description;
    private int category_id;

    public ProductMemory() {
    }

    public ProductMemory(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.price = product.getPrice();
        this.description = product.getDescription();
        this.category_id = product.getCategory().getId();
    }

    public ProductMemory(Product product, int category_id){
        this.id = product.getId();
        this.name = product.getName();
        this.price = product.getPrice();
        this.description = product.getDescription();
        this.category_id = category_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }
}
