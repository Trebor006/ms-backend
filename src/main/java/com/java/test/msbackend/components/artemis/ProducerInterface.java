package com.java.test.msbackend.components.artemis;

import com.java.test.msbackend.dto.QueueMessage;

public interface ProducerInterface {
  void sendMessage(QueueMessage message);
}
