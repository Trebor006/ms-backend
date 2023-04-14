package com.java.test.msbackend.repositories;

import com.java.test.msbackend.documents.ConversionRequest;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConversionRequestRepository extends MongoRepository<ConversionRequest, String> {
  ConversionRequest findByRequestId(String requestId);
}
