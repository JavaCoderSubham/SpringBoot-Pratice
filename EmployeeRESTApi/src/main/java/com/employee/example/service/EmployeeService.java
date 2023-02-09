package com.employee.example.service;

import java.time.LocalDate;
import java.util.List;

import com.employee.example.entity.Employee;

public interface EmployeeService {

	
//	Get All Employee
	List<Employee> findAll();
	
//	Post Employee
	Employee createData(Employee employee);
	
	List<Employee> getBySalaryAndJoingDate(int salary, int yearOfJoining);
	
	public List<Employee> getAllFirstName(String firstName);
	
}
