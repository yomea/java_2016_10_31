package com.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.entity.Employee;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	private Employee employee;

	@RequestMapping("/info")
	public String index() {
		
		return employee.getName() + "-->" + employee.getSalary();
		
	}
	
	
	
}
