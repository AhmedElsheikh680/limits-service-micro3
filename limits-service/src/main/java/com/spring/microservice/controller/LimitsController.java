package com.spring.microservice.controller;

import com.spring.microservice.config.LimitsConfig;
import com.spring.microservice.model.Limits;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class LimitsController {

    @Autowired
    private LimitsConfig limitsConfig;

    // http://localhost:8080/api/v1/limits
    @GetMapping("/limits")
    public Limits retrieveLimits(){
        return new Limits(limitsConfig.getMin(), limitsConfig.getMax());
    }
}
