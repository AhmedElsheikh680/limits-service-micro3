package com.spring.microservice.Controller;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CircuitBreakerController {


    private Logger logger = LoggerFactory.getLogger(CircuitBreakerController.class);

    @GetMapping("/sample-api")
    @CircuitBreaker(name = "sample-api", fallbackMethod="hardcodedResponse")
//    @Retry(name = "sample-api", fallbackMethod = "hardcodedResponse")
    public String sampleApi(){
        logger.info("Sample Api Call Receive");
        ResponseEntity<String> responseEntity =
                new RestTemplate().getForEntity("http://localhost:8080/some-dummy-url", String.class);
        return responseEntity.getBody();
    }
    public String hardcodedResponse(Exception e){
        return "fallback - response";
    }
}
