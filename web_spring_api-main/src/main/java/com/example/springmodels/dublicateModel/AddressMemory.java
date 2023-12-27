package com.example.springmodels.dublicateModel;

import com.example.springmodels.models.Address;
import com.example.springmodels.models.ModelUser;



public class AddressMemory {
    private int id;
    private String city;
    private String street;
    private String house;
    private String entrance;
    private String apartment;
    private Long user_id;

    public AddressMemory() {
    }

    public AddressMemory(int id, String city, String street, String house, String entrance, String apartment, long user_id) {
        this.id = id;
        this.city = city;
        this.street = street;
        this.house = house;
        this.entrance = entrance;
        this.apartment = apartment;
        this.user_id = user_id;
    }

    public AddressMemory(Address address) {
        this.id = address.getId();
        this.city = address.getCity();
        this.street = address.getStreet();
        this.house = address.getHouse();
        this.entrance = address.getEntrance();
        this.apartment = address.getApartment();
        this.user_id = address.getModelUser().getID_User();
    }

    public AddressMemory(Address address, ModelUser user) {
        this.id = address.getId();
        this.city = address.getCity();
        this.street = address.getStreet();
        this.house = address.getHouse();
        this.entrance = address.getEntrance();
        this.apartment = address.getApartment();
        this.user_id = user.getID_User();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public String getEntrance() {
        return entrance;
    }

    public void setEntrance(String entrance) {
        this.entrance = entrance;
    }

    public String getApartment() {
        return apartment;
    }

    public void setApartment(String apartment) {
        this.apartment = apartment;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "AddressMemory{" +
                "id=" + id +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", house='" + house + '\'' +
                ", entrance='" + entrance + '\'' +
                ", apartment='" + apartment + '\'' +
                ", user_id=" + user_id +
                '}';
    }
}
