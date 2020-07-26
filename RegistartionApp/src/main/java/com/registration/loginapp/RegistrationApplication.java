package com.registration.loginapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.registration.loginapp.bo.LoginBO;
import com.registration.loginapp.bo.impl.LoginBOImpl;
import com.registration.loginapp.service.LoginService;
import com.registration.loginapp.service.LoginServiceImpl;

@SpringBootApplication
public class RegistrationApplication {

	public static void main(String[] args) {
		SpringApplication.run(RegistrationApplication.class, args);
	}
	
	@Bean
	public LoginBO getLoginBO() {
		return new LoginBOImpl();
	}
	@Bean
	public LoginService getLoginService() {
		return new LoginServiceImpl();
	}

}
