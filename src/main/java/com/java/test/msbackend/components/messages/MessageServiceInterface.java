package com.java.test.msbackend.components.messages;

public interface MessageServiceInterface {

  String getMessage(String key);

  String getMessage(String key, Object[] args);
}
