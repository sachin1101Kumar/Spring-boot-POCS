package com.security.jsonwebtoken.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Logincontroller {
      
	@GetMapping("/hello")
	public String getHelloWorld() {
		return "Hello World";
	}
}
