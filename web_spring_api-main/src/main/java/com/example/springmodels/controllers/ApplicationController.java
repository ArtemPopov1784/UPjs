package com.example.springmodels.controllers;

import com.example.springmodels.dublicateModel.ApplicationMemory;
import com.example.springmodels.models.Application;
import com.example.springmodels.models.ModelUser;
import com.example.springmodels.repos.ApplicationRepository;
import com.example.springmodels.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@PreAuthorize("hasAnyAuthority('ADMIN')")
public class ApplicationController {
    ApplicationRepository applicationRepository;
    UserRepository userRepository;
    @Autowired
    public ApplicationController(ApplicationRepository applicationRepository, UserRepository userRepository){
        this.applicationRepository = applicationRepository;
        this.userRepository = userRepository;
    }
    @GetMapping("/applications")
    List<ApplicationMemory> index(){
       List<ApplicationMemory> applications = new ArrayList<>();
       for(Application application : applicationRepository.findAll()){
           applications.add(new ApplicationMemory(application));
       }
       return applications;
    }
    @PostMapping("/applications")
    ApplicationMemory store(@RequestBody ApplicationMemory applicationMemory){
        ModelUser user = userRepository.findById(applicationMemory.getUser_id()).orElseThrow();
        applicationMemory.setId(applicationRepository.save(new Application(applicationMemory, user)).getId());
        return applicationMemory;
    }
    @PutMapping("/applications/{id}")
    ApplicationMemory update(@PathVariable(name = "id") int id, @RequestBody ApplicationMemory applicationMemory){
        ModelUser user = userRepository.findById(applicationMemory.getUser_id()).orElseThrow();
        Application applicationToUpdate = applicationRepository.findById(id).orElseThrow();
        applicationToUpdate.setReason(applicationMemory.getReason());
        applicationToUpdate.setText(applicationMemory.getText());
        applicationToUpdate.setLocalDate(LocalDate.now());
        applicationRepository.save(applicationToUpdate);
        return applicationMemory;
    }
    @DeleteMapping("/applications")
    ApplicationMemory delete(@RequestBody ApplicationMemory application){
        applicationRepository.deleteById(application.getId());
        return application;
    }
}
