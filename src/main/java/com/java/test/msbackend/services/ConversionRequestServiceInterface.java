package com.java.test.msbackend.services;

import com.java.test.msbackend.documents.ConversionRequest;

public interface ConversionRequestServiceInterface {

  void createConversionRequest(String requestId);

  void updateConversionRequest(String requestId, String newDetail);

  ConversionRequest getData(String requestId);
}
