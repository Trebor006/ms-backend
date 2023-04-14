package com.java.test.msbackend.components.messages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

@Component
public class MessageService implements MessageServiceInterface {
  private final MessageSource messageSource;

  @Autowired
  public MessageService(MessageSource messageSource) {
    this.messageSource = messageSource;
  }

  @Override
  public String getMessage(String key) {
    return getMessage(key, null);
  }

  @Override
  public String getMessage(String key, Object[] args) {
    return messageSource.getMessage(key, args, LocaleContextHolder.getLocale());
  }
}
