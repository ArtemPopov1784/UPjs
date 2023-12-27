package com.example.springmodels.controllers;

import com.example.springmodels.dublicateModel.AddressMemory;
import com.example.springmodels.models.Address;
import com.example.springmodels.models.ModelUser;
import com.example.springmodels.repos.AddressRepository;
import com.example.springmodels.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@PreAuthorize("hasAnyAuthority('PRODUCT_MANAGER')")
public class AddressController {
    AddressRepository addressRepository;
    UserRepository userRepository;
    @Autowired
    public AddressController(AddressRepository addressRepository, UserRepository userRepository) {
        this.addressRepository = addressRepository;
        this.userRepository = userRepository;
    }
    @GetMapping("/addresses")
    List<AddressMemory> index() {
        List<AddressMemory> addresses = new ArrayList<>();
        for(Address address : addressRepository.findAll()){
            addresses.add(new AddressMemory(address));
        }
        return addresses;
    }

    @PostMapping("/addresses")
    AddressMemory store(@RequestBody AddressMemory addressMemory){
        ModelUser user = userRepository.findById(addressMemory.getUser_id()).orElseThrow();
        addressMemory.setId(addressRepository.save(new Address(addressMemory, user)).getId());
        return addressMemory;
    }
    @PutMapping("/addresses/{id}")
    AddressMemory update(@PathVariable(name = "id") int id, @RequestBody AddressMemory address){
        ModelUser user = userRepository.findById(address.getUser_id()).orElseThrow();
        Address addressToUpdate = addressRepository.findById(id).orElseThrow();
        addressToUpdate.setCity(address.getCity());
        addressToUpdate.setStreet(address.getStreet());
        addressToUpdate.setHouse(address.getHouse());
        addressToUpdate.setEntrance(address.getEntrance());
        addressToUpdate.setApartment(address.getApartment());
        addressToUpdate.setModelUser(user);
        addressRepository.save(addressToUpdate);
        return address;
    }
    @DeleteMapping("/addresses")
    AddressMemory delete(@RequestBody AddressMemory addressMemory){
        addressRepository.deleteById(addressMemory.getId());
        return addressMemory;
    }

}
