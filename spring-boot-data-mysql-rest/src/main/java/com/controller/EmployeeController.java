package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.domain.Employee;
import com.domain.EmployeeRepository;



@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@RequestMapping(value="/create",method=RequestMethod.POST)
	public Employee createEmployee(@RequestBody Employee employee)
	{
		
		System.out.println("before created "+employee);
		Employee persistEmployee = employeeRepository.save(employee);
		System.out.println("after created "+persistEmployee);
		return persistEmployee;
	}
	
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	public void deleteEmployee()
	{
		System.out.println("hello i  am happy");
	}
	
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public void updateEmployee()
	{
		System.out.println("hello i  am happy");
	}
	
	@RequestMapping(value="/list",method=RequestMethod.POST)
	public void listEmployees()
	{
		System.out.println("hello i  am happy");
	}
	
	@RequestMapping(value="/employee",method=RequestMethod.POST)
	public void findEmployeeByName()
	{
		System.out.println("hello i  am happy");
	}
	
	
}
