package com.example.api.Responses;

import lombok.Data;

@Data
public class GetUsersResponse {
    private int id;
    private String name;
    private int age;
    private String email;
    private Address address;
    private String timestamp;

    @Data
    public static class Address {
        private String street;
        private String city;
        private String zip;
        private String country;
    }
    /*
        {
        "id": 10,
        "name": "Ms. Francis Koepp",
        "age": 39,
        "email": "jedidiah.harris@hotmail.com",
        "address": {
            "street": "434 Frami Way",
            "city": "Fletcherton",
            "zip": "39680",
            "country": "USA"
        },
        "timestamp": "20231210174252"
    }
     */
}
