package com.example.springApi.service;

import com.example.springApi.api.model.User;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse {
    private Object data;
    private String errorMessage;

    // Constructor for successful response
    public ApiResponse(Object data) {
        this.data = data;
    }

    // Constructor for error response
    public ApiResponse(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
