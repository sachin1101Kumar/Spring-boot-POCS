package com.restfulservices;

import com.restfulservices.beans.Employee;
import com.restfulservices.respository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	@Autowired
	EmployeeRepository employeeRepository;
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Employee employee=new Employee("Sachin","tech.sachinkumar@gmail.com");
		employeeRepository.save(employee);
	}
	@Bean
	public LocaleResolver localeResolver(){
		//SessionLocaleResolver sessionLocaleResolver=new SessionLocaleResolver();
		/*if we gonn pass the locale as a parameter from
		Headers accept language and we are explicitly sending the locale to method*/
		AcceptHeaderLocaleResolver sessionLocaleResolver=new AcceptHeaderLocaleResolver();
		sessionLocaleResolver.setDefaultLocale(Locale.US);
		return sessionLocaleResolver;
	}
	/*There is no need of this if we define a property in application .properties spring.messages.basename*/
/*	@Bean
	public ResourceBundleMessageSource messageSource(){
		ResourceBundleMessageSource resourceBundleMessageSource=new ResourceBundleMessageSource();
		resourceBundleMessageSource.setBasename("message");
		return resourceBundleMessageSource;
	}*/
}
