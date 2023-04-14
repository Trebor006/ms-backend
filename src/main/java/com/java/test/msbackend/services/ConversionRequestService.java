package com.java.test.msbackend.services;

import com.java.test.msbackend.documents.ConversionRequest;
import com.java.test.msbackend.repositories.ConversionRequestRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ConversionRequestService implements ConversionRequestServiceInterface {

  public static final String REQUEST_ID = "requestId";
  public static final String REQUEST_DETAIL = "requestDetail";
  private final ConversionRequestRepository conversionRequestRepository;
  private final MongoTemplate mongoTemplate;

  @Override
  @Transactional
  public void createConversionRequest(String requestId) {
    log.info("saving to MongoDB :: " + requestId);

    ConversionRequest conversionRequest = new ConversionRequest(requestId, null);
    conversionRequestRepository.insert(conversionRequest);
  }

  @Override
  @Transactional
  public void updateConversionRequest(String requestId, String newDetail) {
    log.info("updating to MongoDB :: " + requestId + ", newDetail:" + newDetail);

    Query query = Query.query(Criteria.where(REQUEST_ID).is(requestId));
    Update update = new Update().set(REQUEST_DETAIL, newDetail);
    mongoTemplate.updateFirst(query, update, ConversionRequest.class);
  }

  @Override
  public ConversionRequest getData(String requestId) {
    log.info("updating to MongoDB :: " + requestId);

    Query query = Query.query(Criteria.where(REQUEST_ID).is(requestId));
    return mongoTemplate.findOne(query, ConversionRequest.class);
  }
}
