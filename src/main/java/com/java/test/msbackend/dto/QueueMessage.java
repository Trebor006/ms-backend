package com.java.test.msbackend.dto;

import com.java.test.msbackend.enums.MessageType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QueueMessage {

  private MessageType type;
  private String content;
}
