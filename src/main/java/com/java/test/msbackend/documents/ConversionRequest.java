package com.java.test.msbackend.documents;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "conversionRequest")
public class ConversionRequest {

  @Getter @Setter private String requestId;

  @Getter @Setter private String requestDetail;
}
