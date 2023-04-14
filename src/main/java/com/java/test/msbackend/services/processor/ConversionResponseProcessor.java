package com.java.test.msbackend.services.processor;

import com.google.gson.Gson;
import com.java.test.msbackend.dto.integration.ResultDto;
import com.java.test.msbackend.services.ConversionRequestServiceInterface;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ConversionResponseProcessor implements Processor {

  private final ConversionRequestServiceInterface conversionRequestService;

  @Override
  public void process(String content) {
    var gson = new Gson();
    var resultDto = gson.fromJson(content, ResultDto.class);
    log.info(content);
    conversionRequestService.updateConversionRequest(resultDto.getRequestId(), content);
    log.info("saving update in mongodb");
  }
}
