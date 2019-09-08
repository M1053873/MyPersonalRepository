package com.mindtree.employees.receiver;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.mindtree.employees.entity.Employee;
@Component
public class EmployeeReceiver 
{
	@JmsListener(destination="emp")
	public void receiver(String employee)
	{
		System.out.println("Received");
		System.out.println(employee);
	}
}
