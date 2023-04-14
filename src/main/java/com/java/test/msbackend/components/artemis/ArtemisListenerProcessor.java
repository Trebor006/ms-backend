package com.java.test.msbackend.components.artemis;

import com.google.gson.Gson;
import com.java.test.msbackend.dto.QueueMessage;
import com.java.test.msbackend.services.processor.ProcessorLocatorServiceInterface;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ArtemisListenerProcessor implements ListenerProcessorInterface {

  private final ProcessorLocatorServiceInterface processorService;

  @Override
  public void process(String content) {
    var gson = new Gson();
    var queueMessage = gson.fromJson(content, QueueMessage.class);
    var processor = processorService.getProcessor(queueMessage.getType());
    processor.process(queueMessage.getContent());
  }
}
