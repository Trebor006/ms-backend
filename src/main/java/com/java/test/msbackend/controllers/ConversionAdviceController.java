package com.java.test.msbackend.controllers;

import com.java.test.msbackend.components.response.ApiResponse;
import com.java.test.msbackend.components.response.ErrorApiResponseServiceInterface;
import com.java.test.msbackend.exceptions.ConversionRequestNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
@RequiredArgsConstructor
public class ConversionAdviceController {

  private final ErrorApiResponseServiceInterface errorApiResponseService;

  @ExceptionHandler(ConversionRequestNotFoundException.class)
  public ResponseEntity<ApiResponse> conversionRequestNotFoundExceptionHandler(
      ConversionRequestNotFoundException exception) {

    var responseError =
        errorApiResponseService.getObjectApiResponse(HttpStatus.NOT_FOUND, exception.getMessage());

    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseError);
  }
}
