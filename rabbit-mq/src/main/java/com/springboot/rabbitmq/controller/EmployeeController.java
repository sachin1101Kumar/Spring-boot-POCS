package com.springboot.rabbitmq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.rabbitmq.model.Employee;
import com.springboot.rabbitmq.service.RabbitMQSender;

@RestController
public class EmployeeController {

	@Autowired
	RabbitMQSender rabbitMQSender;
	
	@RequestMapping("/producer")
	public String producer(@RequestParam("name") String empName,@RequestParam("id") String id) {
		Employee employee=new Employee();
		employee.setId(id);
		employee.setName(empName);
		
		rabbitMQSender.send(employee);
		
		return "Message sent successfully....";
		
		
	}
}
