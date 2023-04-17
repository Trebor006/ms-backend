package com.java.test.msbackend.components.artemis;

import com.google.gson.Gson;
import com.java.test.msbackend.components.messages.MessageServiceInterface;
import com.java.test.msbackend.constants.GeneralConstants;
import com.java.test.msbackend.dto.QueueMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class ArtemisProducer implements ProducerInterface {

  private final JmsTemplate jmsTemplate;
  private final MessageServiceInterface messageService;

  @Override
  public void sendMessage(QueueMessage message) {
    log.info(
        messageService.getMessage(
            "artemis.process.confirm.sending.message",
            new String[] {new Gson().toJson(message)}));

    String queueBodyContent = new Gson().toJson(message);
    this.jmsTemplate.send(
        GeneralConstants.QUEUE_NAME, session -> session.createTextMessage(queueBodyContent));

    log.info(messageService.getMessage("process.confirm.sent.message"));
  }
}
