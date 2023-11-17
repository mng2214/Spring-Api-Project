package com.example.springApi.service;

import com.example.springApi.api.model.User;
import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.Random;

public class UserBuilder {

    public static Faker faker = new Faker();
    public static Random random = new Random();
    public static User buildUser() {
        return new User(
                faker.random().nextInt(1, 50),
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
