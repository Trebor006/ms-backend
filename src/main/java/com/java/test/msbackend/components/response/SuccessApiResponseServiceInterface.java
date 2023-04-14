package com.java.test.msbackend.components.response;

public interface SuccessApiResponseServiceInterface {
    <T> ApiResponse createSuccessResponse(T data);
}
