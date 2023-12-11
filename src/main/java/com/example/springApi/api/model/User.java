package com.example.springApi.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {

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

    @Data
    @AllArgsConstructor
    public static class ErrorResponse {
        private String message;
        private Integer userId;

        // Getters (and possibly setters, depending on your requirements)
    }
}

