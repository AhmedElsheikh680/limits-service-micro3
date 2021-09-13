package com.spring.microservice.Controller;

import com.spring.microservice.model.CurrencyExchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;


@RestController
public class CurrencyExchangeController {

    @Autowired
    private Environment environment;

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyExchange retrieveExchangeValue(@PathVariable String from, @PathVariable String to){
          CurrencyExchange currencyExchange = new CurrencyExchange(1001L, "USD", "INR", BigDecimal.valueOf(50));
          currencyExchange.setEnvironment(environment.getProperty("server.port"));
          return currencyExchange;
    }
}
