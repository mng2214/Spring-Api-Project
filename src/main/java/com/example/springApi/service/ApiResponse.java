package com.example.springApi.service;

import lombok.Data;


public class ApiResponse {
    private Object data;
    private String errorMessage;

    // Constructor for success
    public ApiResponse(Object data) {
        this.data = data;
    }

    // Constructor for error
    public ApiResponse(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    // Getters (and setters if needed)
    public Object getData() {
        return data;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
