package com.java.test.msbackend.components.response;

import org.springframework.http.HttpStatus;

public interface ErrorApiResponseServiceInterface {
    ApiResponse getObjectApiResponse(HttpStatus status, String message);
}
