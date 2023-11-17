package com.example.springApi.api.controller;

import com.example.springApi.api.model.User;
import com.example.springApi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

//    @GetMapping("/user")
//    public User getUser(@RequestParam Integer id){
//        Optional<User> user = userService.getUser(id);
//        return user.orElse(null);
//    }

    @GetMapping("/user")
    public ResponseEntity<Object> getUser(@RequestParam Integer id) {
        Optional<User> user = userService.getUser(id);
//        if (user.isPresent()) {
//            return ResponseEntity.ok(user.get()); // Return user with 200 OK status
//        } else {
//            String errorMsg = "User not found";
//            User.ErrorResponse errorResponse = new User.ErrorResponse(errorMsg, id);
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
//        }
        return (user.isPresent()) ? ResponseEntity.ok(user.get()) : ResponseEntity.status(HttpStatus.NOT_FOUND).body(new User.ErrorResponse("User not found", id));

    }

    @GetMapping("/allusers")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }




}