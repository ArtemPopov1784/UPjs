package com.example.springmodels.controllers;

import ch.qos.logback.core.status.StatusUtil;
import com.example.springmodels.models.Status;
import com.example.springmodels.repos.StatusRepository;
import org.apache.coyote.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@PreAuthorize("hasAnyAuthority('PRODUCT_MANAGER')")
public class StatusController {
    StatusRepository statusRepository;
    @Autowired
    public StatusController(StatusRepository statusRepository) {
        this.statusRepository = statusRepository;
    }
    @GetMapping("/statuses")
    List<Status> index(){
        List<Status> statusList = statusRepository.findAll();
        for(Status s : statusList){
            s.setOrders(null);
        }
        return statusList;
    }

    @GetMapping("/statuses/{id}")
    Status show(@PathVariable(name = "id") int id){
        Status element = statusRepository.findById(id).orElseThrow();
        element.setOrders(null);
        return element;
    }

    @PostMapping("/statuses")
    Status store(@RequestBody Status status){
        return statusRepository.save(status);
    }

    @PutMapping("/statuses/{id}")
    Status update(@PathVariable(name = "id") int id,
                  @RequestBody Status status){
        Status statusToUpdate = statusRepository.findById(id).orElseThrow();
        statusToUpdate.setName(status.getName());
        return statusRepository.save(statusToUpdate);
    }

    @DeleteMapping("/statuses/{id}")
    Status delete(@RequestBody Status status){
        statusRepository.deleteById(status.getId());
        return status;
    }

}
