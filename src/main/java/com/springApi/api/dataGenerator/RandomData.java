package com.springApi.api.dataGenerator;

import com.github.javafaker.Faker;
import com.springApi.api.utils.Formatters;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Locale;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class RandomData {

    Faker faker = new Faker(new Locale("en"));

    Random random = new Random();

    int id = 1;

    public  String randomTimestamp() {
        long minDay = Instant.now().minus(365, ChronoUnit.DAYS).getEpochSecond();
        long maxDay = Instant.now().getEpochSecond();
        long randomDay = ThreadLocalRandom.current().nextLong(minDay, maxDay);

        Instant instant = Instant.ofEpochSecond(randomDay);
        ZonedDateTime zdt = ZonedDateTime.ofInstant(instant, ZoneId.systemDefault());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        return zdt.format(formatter);
    }

}
