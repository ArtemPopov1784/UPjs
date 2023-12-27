package com.example.springmodels.controllers;

import com.example.springmodels.models.Category;
import com.example.springmodels.models.Status;
import com.example.springmodels.repos.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@PreAuthorize("hasAnyAuthority('PRODUCT_MANAGER')")
public class CategoryController {
    CategoryRepository categoryRepository;

    @Autowired
    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @GetMapping("/categories")
    List<Category> index(){
        List<Category> categoryList = categoryRepository.findAll();
        for(Category c : categoryList){
            c.setProducts(null);
        }
        return categoryList;
    }

    @GetMapping("/categories/{id}")
    Category show(@PathVariable(name = "id") int id){
        Category e = categoryRepository.findById(id).orElseThrow();
        e.setProducts(null);
        return e;
    }

    @PostMapping("/categories")
    Category store(@RequestBody Category category){
        return categoryRepository.save(category);
    }

    @PutMapping("/categories/{id}")
    Category update(@PathVariable(name = "id") int id,
                    @RequestBody Category category){
        Category categoryToUpdate = categoryRepository.findById(id).orElseThrow();
        categoryToUpdate.setName(category.getName());
        return categoryRepository.save(categoryToUpdate);
    }

    @DeleteMapping("/categories/{id}")
    Category delete(@RequestBody Category category){
        categoryRepository.deleteById(category.getId());
        return category;
    }
}
