package com.springApi.api;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

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
