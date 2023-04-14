package com.java.test.msbackend.services.mapper;

import com.java.test.msbackend.dto.QueueMessage;
import com.java.test.msbackend.dto.integration.RequestDto;

public interface ConversionRequestMessageMapperServiceInterface {
  QueueMessage mapToQueueMessage(RequestDto conversionRequestDto);
}
