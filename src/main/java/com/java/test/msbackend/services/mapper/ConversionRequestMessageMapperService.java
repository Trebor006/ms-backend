package com.java.test.msbackend.services.mapper;

import com.google.gson.Gson;
import com.java.test.msbackend.dto.QueueMessage;
import com.java.test.msbackend.dto.integration.RequestDto;
import com.java.test.msbackend.enums.MessageType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ConversionRequestMessageMapperService implements ConversionRequestMessageMapperServiceInterface {

  @Override
  public QueueMessage mapToQueueMessage(RequestDto conversionRequestDto) {
    return QueueMessage.builder()
        .type(MessageType.CONVERSION_REQUEST)
        .content(new Gson().toJson(conversionRequestDto))
        .build();
  }
}
