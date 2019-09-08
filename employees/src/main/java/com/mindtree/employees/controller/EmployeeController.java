package com.mindtree.employees.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.employees.entity.Employee;

@RestController
public class EmployeeController {
	
	@Autowired
	private JmsTemplate jmsTemplate;
	
	@PostMapping("/send")
	public void sender(@RequestBody Employee employee)
	{
		jmsTemplate.convertAndSend("emp",employee.toString());
	}

}
