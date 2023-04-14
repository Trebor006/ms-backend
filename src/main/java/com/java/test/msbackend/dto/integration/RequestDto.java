package com.java.test.msbackend.dto.integration;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RequestDto {

  @Builder.Default private String requestId = UUID.randomUUID().toString();
  private String symbol;
  private Double amount;
  private String currency;
}
