package com.java.test.msbackend.components.artemis;

import com.google.gson.Gson;
import com.java.test.msbackend.constants.GeneralConstants;
import com.java.test.msbackend.dto.QueueMessage;
import jakarta.jms.JMSException;
import jakarta.jms.Session;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class ArtemisProducer implements ProducerInterface {

  private final JmsTemplate jmsTemplate;

  @Override
  public void sendMessage(QueueMessage message) {
    log.info("sending message ::: " + new Gson().toJson(message));

    String queueBodyContent = new Gson().toJson(message);
    this.jmsTemplate.send(
        GeneralConstants.QUEUE_NAME,
            session -> session.createTextMessage(queueBodyContent));

    log.info("message already sent");
  }
}
