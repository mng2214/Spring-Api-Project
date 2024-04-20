package com.springApi.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class OptionsController {

    @RequestMapping(method = RequestMethod.OPTIONS, path = "/options")
    public ResponseEntity handleOptions() {
        return ResponseEntity
                .ok()
                .header("Allow", "GET, POST, DELETE, PUT, OPTIONS")
                .body("This endpoint allows the following operations: Will be added");
    }
}
