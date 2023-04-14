package com.java.test.msbackend.services;

import com.java.test.msbackend.dto.ConversionResponseDto;
import com.java.test.msbackend.dto.integration.RequestDto;

public interface ConversionServiceInterface {
  String generateConversionRequest(RequestDto conversionRequestDto);

  ConversionResponseDto getConversionData(String requestId);
}
