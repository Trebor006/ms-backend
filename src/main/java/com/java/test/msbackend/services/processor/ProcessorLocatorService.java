package com.java.test.msbackend.services.processor;

import com.java.test.msbackend.enums.MessageType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProcessorLocatorService implements ProcessorLocatorServiceInterface {

  public final ConversionResponseProcessor conversionResponseProcessor;

  @Override
  public Processor getProcessor(MessageType messageType) {
    if (messageType.equals(MessageType.CONVERSION_RESPONSE)) {
      return conversionResponseProcessor;
    }

    throw new UnsupportedOperationException();
  }
}
