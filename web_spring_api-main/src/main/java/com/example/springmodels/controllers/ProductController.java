package com.example.springmodels.controllers;

import com.example.springmodels.models.Category;
import com.example.springmodels.models.Product;
import com.example.springmodels.dublicateModel.ProductMemory;
import com.example.springmodels.repos.CategoryRepository;
import com.example.springmodels.repos.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@PreAuthorize("hasAnyAuthority('PRODUCT_MANAGER')")
public class ProductController {
    ProductRepository productRepository;
    CategoryRepository categoryRepository;

    @Autowired
    public ProductController(ProductRepository productRepository, CategoryRepository categoryRepository){
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @GetMapping("/products")
    List<ProductMemory> index(){
        List<ProductMemory> products = new ArrayList<>();
        for (Product product : productRepository.findAll()){
            products.add(new ProductMemory(product));
        }
        return products;
    }

    @PostMapping("/products")
    ProductMemory store(@RequestBody ProductMemory product){
        Category category = categoryRepository.findById(product.getCategory_id()).orElseThrow();
        product.setId(productRepository.save(new Product(product, category)).getId());
        return product;
    }

    @PutMapping("/products/{id}")
    ProductMemory update(@PathVariable(name = "id") int id, @RequestBody ProductMemory product){
        Category category = categoryRepository.findById(product.getCategory_id()).orElseThrow();
        Product productToUpdate = productRepository.findById(id).orElseThrow();
        productToUpdate.setName(product.getName());
        productToUpdate.setDescription(product.getDescription());
        productToUpdate.setPrice(product.getPrice());
        productToUpdate.setCategory(category);
        productRepository.save(productToUpdate);
        return product;
    }

    @DeleteMapping("/products/{id}")
    ProductMemory delete(@RequestBody ProductMemory productMemory){
        productRepository.deleteById(productMemory.getId());
        return productMemory;
    }




}
