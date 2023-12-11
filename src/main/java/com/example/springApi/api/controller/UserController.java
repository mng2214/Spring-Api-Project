package com.example.springApi.api.controller;

import com.example.springApi.api.model.User;
import com.example.springApi.service.ApiResponse;
import com.example.springApi.service.UserService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
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

    @GetMapping("/user")
    public ResponseEntity<ApiResponse> getUser(@RequestParam Integer id) {
        Optional<User> user = userService.getUser(id);
        return user.map(value -> ResponseEntity.ok(new ApiResponse(value))).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ApiResponse("User not found")));
    }


    //get call list of users
    @GetMapping("/allusers")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

}