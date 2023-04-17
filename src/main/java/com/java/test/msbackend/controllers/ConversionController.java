package com.java.test.msbackend.controllers;

import com.google.gson.Gson;
import com.java.test.msbackend.components.messages.MessageServiceInterface;
import com.java.test.msbackend.components.response.ApiResponse;
import com.java.test.msbackend.components.response.SuccessApiResponseServiceInterface;
import com.java.test.msbackend.dto.ConversionRequestDto;
import com.java.test.msbackend.dto.ConversionResponseDto;
import com.java.test.msbackend.dto.integration.RequestDto;
import com.java.test.msbackend.services.ConversionServiceInterface;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/conversions")
@RequiredArgsConstructor
public class ConversionController implements ConversionControllerInterface {

  private final ConversionServiceInterface conversionService;
  private final SuccessApiResponseServiceInterface successApiResponseService;
  private final MessageServiceInterface messageService;

  @Override
  @PostMapping
  public ResponseEntity<ApiResponse> convert(
      @RequestBody ConversionRequestDto conversionRequestDto) {
    log.info(
        messageService.getMessage(
            "conversion.init.message", new String[] {new Gson().toJson(conversionRequestDto)}));
    var requestDto =
        RequestDto.builder()
            .symbol(conversionRequestDto.getSymbol())
            .amount(conversionRequestDto.getAmount())
            .currency(conversionRequestDto.getCurrency())
            .build();

    var requestId = conversionService.generateConversionRequest(requestDto);

    return ResponseEntity.ok(successApiResponseService.createSuccessResponse(requestId));
  }

  @Override
  @GetMapping("/{requestId}")
  public ResponseEntity<ApiResponse> getConversionById(@PathVariable String requestId) {
    ConversionResponseDto conversionData = conversionService.getConversionData(requestId);
    return ResponseEntity.ok(successApiResponseService.createSuccessResponse(conversionData));
  }
}
