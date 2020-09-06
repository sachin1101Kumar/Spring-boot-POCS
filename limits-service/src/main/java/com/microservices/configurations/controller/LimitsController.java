package com.microservices.configurations.controller;

import com.microservices.configurations.beans.LimitsConfigurations;
import com.microservices.configurations.conf.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitsController {
    @Autowired
    private Configuration configuration;

    @GetMapping("/limits")
    public LimitsConfigurations getLimitsConfigurations(){
       return new LimitsConfigurations(configuration.getMin(),configuration.getMax());
    }
}
