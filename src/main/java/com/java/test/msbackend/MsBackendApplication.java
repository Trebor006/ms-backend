package com.java.test.msbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class MsBackendApplication {

  public static void main(String[] args) {
    SpringApplication.run(MsBackendApplication.class, args);
  }
}
