package com.microservices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.bean.LimitsConfigurations;
import com.microservices.configurations.LimitsConf;

@RestController
public class LimitsController {
	
	@Autowired
	private LimitsConf limitsConfigurations;

	@GetMapping("/limits")
	public LimitsConfigurations getLimitConfigurations() {
		return new LimitsConfigurations(limitsConfigurations.getMinimum(), limitsConfigurations.getMaximum());
	}
}
