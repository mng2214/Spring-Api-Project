package com.springApi.api.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
public class User {

    private int id;
    private String name;
    private int age;
    private String email;
    private Address address;
    private String dateCreated;

}

