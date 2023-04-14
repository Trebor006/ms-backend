package com.java.test.msbackend.services.processor;

import com.java.test.msbackend.enums.MessageType;

public interface ProcessorLocatorServiceInterface {
  Processor getProcessor(MessageType messageType);
}
