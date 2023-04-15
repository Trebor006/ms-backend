package com.java.test.msbackend.dto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ConversionRequestDtoTest {

  @Test
  public void testGettersAndSetters() {
    var symbol = "BTC";
    var amount = 1.0D;
    var currency = "USD";

    ConversionRequestDto conversionRequestDto =
        ConversionRequestDto.builder().symbol(symbol).amount(amount).currency(currency).build();

    Assertions.assertEquals(symbol, conversionRequestDto.getSymbol());
    Assertions.assertEquals(amount, conversionRequestDto.getAmount());
    Assertions.assertEquals(currency, conversionRequestDto.getCurrency());
  }
}
