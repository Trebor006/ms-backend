package com.java.test.msbackend.services;

import com.google.gson.Gson;
import com.java.test.msbackend.components.artemis.ProducerInterface;
import com.java.test.msbackend.components.messages.MessageServiceInterface;
import com.java.test.msbackend.documents.ConversionRequest;
import com.java.test.msbackend.dto.ConversionResponseDto;
import com.java.test.msbackend.dto.integration.RequestDto;
import com.java.test.msbackend.exceptions.ConversionRequestNotFoundException;
import com.java.test.msbackend.services.mapper.ConversionRequestMessageMapperServiceInterface;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ConversionService implements ConversionServiceInterface {

  private final ProducerInterface artemisProducer;
  private final ConversionRequestMessageMapperServiceInterface mapperService;
  private final ConversionRequestServiceInterface conversionRequestService;
  private final MessageServiceInterface messageService;

  @Override
  public String generateConversionRequest(RequestDto conversionRequestDto) {
    String requestString = new Gson().toJson(conversionRequestDto);
    log.info(
        messageService.getMessage(
            "process.generating.conversion.request", new String[] {requestString}));

    conversionRequestService.createConversionRequest(conversionRequestDto.getRequestId());

    var queueMessage = mapperService.mapToQueueMessage(conversionRequestDto);
    artemisProducer.sendMessage(queueMessage);

    log.info(messageService.getMessage("process.generating.conversion.request.finished"));

    return conversionRequestDto.getRequestId();
  }

  @Override
  public ConversionResponseDto getConversionData(String requestId) {
    ConversionRequest conversionRequest = conversionRequestService.getData(requestId);
    if (conversionRequest == null) {
      var message =
          messageService.getMessage("conversion.data.not.found", new String[] {requestId});
      log.info(message);
      throw new ConversionRequestNotFoundException(message);
    }

    return new Gson().fromJson(conversionRequest.getRequestDetail(), ConversionResponseDto.class);
  }
}
