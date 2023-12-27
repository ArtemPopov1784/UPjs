package com.example.springmodels.controllers;

import com.example.springmodels.dublicateModel.RoleMemory;
import com.example.springmodels.models.ModelUser;
import com.example.springmodels.models.RoleEnum;
import com.example.springmodels.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@PreAuthorize("hasAnyAuthority('ADMIN')")
public class RoleChangerController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users")
    Iterable<ModelUser> index() {
        Iterable<ModelUser> users = userRepository.findAll();
        return users;
    }

    @PutMapping("/users/{id}")
    ModelUser update(@RequestBody RoleMemory roles, @PathVariable(name = "id") long id){
        ModelUser user = userRepository.findById(id).orElseThrow();
        user.getRoles().clear();
        if(roles != null){
            for(String role : roles.getRoles()){
                user.getRoles().add(RoleEnum.valueOf(role));
            }
        }

        userRepository.save(user);
        return user;
    }
}
