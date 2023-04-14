package com.java.test.msbackend.controllers;

import com.java.test.msbackend.components.response.ApiResponse;
import com.java.test.msbackend.dto.ConversionRequestDto;
import org.springframework.http.ResponseEntity;

public interface ConversionControllerInterface {

  ResponseEntity<ApiResponse> convert(ConversionRequestDto conversionRequestDto);

  ResponseEntity<ApiResponse> getConversionById(String requestId);
}
