package com.example.springApi.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {

    private static int idCounter = 1;

    private int id;
    private String name;
    private int age;
    private String email;
    private Address address;
    private String timestamp;

    @Data
    @AllArgsConstructor
    public static class Address {
        private String street;
        private String city;
        private String zip;
        private String country;
    }

    public User( String name, int age, String email, Address address, String timestamp) {
        this.id = ++idCounter;
        this.name = name;
        this.age = age;
        this.email = email;
        this.address = address;
        this.timestamp = timestamp;
    }
}

