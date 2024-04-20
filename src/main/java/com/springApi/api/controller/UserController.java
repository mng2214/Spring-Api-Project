package com.springApi.api.controller;

import com.springApi.api.model.User;
import com.springApi.api.ApiResponse;
import com.springApi.api.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@RestController
@AllArgsConstructor
@RequestMapping("/user")
public class UserController {

    private static Logger log = Logger.getLogger(UserController.class.getName());

    private final UserService userService;

    @GetMapping("/all")
    public List<User> getAllUsers() {
        log.info("Get all users");
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Integer id) {
        User user = userService.findById(id);
        if (user != null) log.info("Get user by id: " + id);
        return (user == null)
                ? ResponseEntity.status(HttpStatus.NOT_FOUND).body(null)
                : ResponseEntity.ok(user);
    }

    @PostMapping("/add")
    public User addUser(@RequestBody User user) {
        log.info("Add user: " + user);
        return userService.save(user);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable Integer id) {
        User user = userService.findById(id);
        if (user != null) log.info("Delete user by id: " + id);
        return (user == null)
                ? ResponseEntity.status(HttpStatus.NOT_FOUND).build()
                : ResponseEntity.ok(userService.deleteById(id));
    }


}