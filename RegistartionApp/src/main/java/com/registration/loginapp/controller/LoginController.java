package com.registration.loginapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.registration.loginapp.bo.UserBO;
import com.registration.loginapp.service.LoginService;

@RestController
public class LoginController {
	
	@Autowired
	LoginService service;
	
	@PostMapping("/save")
	public UserBO saveUser(@RequestBody UserBO user) {
		UserBO bo = null;
		if(user!=null) {
		 	 bo=service.saveUser(user);
		}
		return bo;
	}
	
	@GetMapping("/getAllUsers")
	public List<UserBO> getAllUsers(){
		return service.getAllUsers();
	}

}
