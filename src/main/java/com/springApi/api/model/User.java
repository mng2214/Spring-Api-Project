package com.springApi.api.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.SneakyThrows;
import org.springframework.beans.BeanUtils;

@Data
@Builder
@AllArgsConstructor
public class User {

    private Integer id;
    private String name;
    private int age;
    private String email;
    private Address address;
    private String dateCreated;

    @SneakyThrows
    public void updateFields(User sourceUser) {
        BeanUtils.copyProperties(sourceUser, this);
    }

}

