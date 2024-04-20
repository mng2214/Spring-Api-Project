package com.springApi.api.dataGenerator;

import com.springApi.api.model.Address;
import com.springApi.api.model.User;
import com.springApi.api.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class UserDataGenerator extends RandomData implements CommandLineRunner {

    UserService userService;

    public UserDataGenerator(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void run(String... args) throws Exception {

        for (int i = 0; i < 10; i++) {

            Address address = Address.builder()
                    .street(faker.address().streetAddress())
                    .city(faker.address().city())
                    .zip(faker.address().zipCode())
                    .country("USA").build();

            User user = User.builder()
                    .id(id++)
                    .name(faker.name().fullName())
                    .age(random.nextInt(100))
                    .email(faker.internet().emailAddress())
                    .address(address)
                    .dateCreated(randomTimestamp).build();

            userService.save(user);
        }

    }


}
