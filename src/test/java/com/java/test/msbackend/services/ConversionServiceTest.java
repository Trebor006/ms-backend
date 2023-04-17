package com.java.test.msbackend.services;

import static org.mockito.Mockito.when;

import com.google.gson.Gson;
import com.java.test.msbackend.components.artemis.ProducerInterface;
import com.java.test.msbackend.documents.ConversionRequest;
import com.java.test.msbackend.dto.ConversionRequestDto;
import com.java.test.msbackend.dto.ConversionResponseDto;
import com.java.test.msbackend.dto.QueueMessage;
import com.java.test.msbackend.dto.integration.RequestDto;
import com.java.test.msbackend.services.mapper.ConversionRequestMessageMapperServiceInterface;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ConversionServiceTest {

  @Mock private ProducerInterface artemisProducer;
  @Mock private ConversionRequestMessageMapperServiceInterface mapperService;
  @Mock private ConversionRequestServiceInterface conversionRequestService;
  @InjectMocks private ConversionService conversionService;

  @Test
  public void testGenerateConversionRequest() {
    var symbol = "BTC";
    var amount = 1.0D;
    var currency = "USD";

    ConversionRequestDto conversionRequestDto =
        ConversionRequestDto.builder().symbol(symbol).amount(amount).currency(currency).build();

    var requestDto =
        RequestDto.builder()
            .symbol(conversionRequestDto.getSymbol())
            .amount(conversionRequestDto.getAmount())
            .currency(conversionRequestDto.getCurrency())
            .build();

    conversionRequestService.createConversionRequest(Mockito.anyString());
    Mockito.verify(conversionRequestService, Mockito.times(1))
        .createConversionRequest(Mockito.anyString());

    QueueMessage queueMessageMock = Mockito.mock(QueueMessage.class);
    when(mapperService.mapToQueueMessage(Mockito.any())).thenReturn(queueMessageMock);

    when(mapperService.mapToQueueMessage(Mockito.any())).thenReturn(queueMessageMock);

    artemisProducer.sendMessage(Mockito.any());
    Mockito.verify(artemisProducer, Mockito.times(1)).sendMessage(Mockito.any());

    var result = conversionService.generateConversionRequest(requestDto);
    Assertions.assertEquals(result, requestDto.getRequestId());
  }

  @Test
  public void testGetConversionData() {

    var requestId = "ABCD";
    var symbol = "BTC";
    var amount = 1.0D;
    var currency = "USD";
    var equivalenceAmount = 25000.0D;
    var conversionResponseDto =
        ConversionResponseDto.builder()
            .requestId(requestId)
            .symbol(symbol)
            .amount(amount)
            .currency(currency)
            .equivalenceAmount(equivalenceAmount)
            .build();

    ConversionRequest conversionRequest = new ConversionRequest();
    conversionRequest.setRequestId(requestId);
    conversionRequest.setRequestDetail(new Gson().toJson(conversionResponseDto));

    when(conversionRequestService.getData(Mockito.anyString())).thenReturn(conversionRequest);

    var result = conversionService.getConversionData(requestId);
    Assertions.assertInstanceOf(ConversionResponseDto.class, result);
  }
}
