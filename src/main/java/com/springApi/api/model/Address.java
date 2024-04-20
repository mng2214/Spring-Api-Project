package com.springApi.api.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Address {

        private String street;
        private String city;
        private String zip;
        private String country;

}
