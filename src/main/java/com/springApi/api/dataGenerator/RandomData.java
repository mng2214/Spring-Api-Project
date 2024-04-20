package com.springApi.api.dataGenerator;

import com.github.javafaker.Faker;
import com.springApi.api.utils.Formatters;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Locale;
import java.util.Random;

public class RandomData {

    Faker faker = new Faker(new Locale("en"));

    Random random = new Random();

    int id = 1;

    long randomDays = random.nextInt(30);
    long randomHours = random.nextInt(24);

    Instant instant = Instant.now().minus(randomDays, ChronoUnit.DAYS).minus(randomHours, ChronoUnit.HOURS);
    LocalDateTime randomTimestamp = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
}
