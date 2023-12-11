package com.example.springApi.service;

import com.example.springApi.api.model.User;
import com.github.javafaker.Faker;
import java.text.SimpleDateFormat;
import java.util.*;


public class UserBuilder {

    public static Faker faker = new Faker();
    public static Random random = new Random();

    public static User buildUser() {
        return new User(
                faker.name().fullName(),
                random.nextInt(65),
                faker.internet().emailAddress(),
                buildAddress(),
                new SimpleDateFormat("yyyyMMddHHmmss").format(Calendar.getInstance().getTime()));
    }


    public static User.Address buildAddress() {
        return new User.Address(
                faker.address().streetAddress(),
                faker.address().city(),
                faker.address().zipCode(),
                "USA");
    }

}
