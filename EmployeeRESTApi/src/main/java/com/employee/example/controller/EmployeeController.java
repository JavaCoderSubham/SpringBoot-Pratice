package com.employee.example.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.employee.example.entity.Employee;
import com.employee.example.service.EmployeeService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService service;

	private final Logger log = LogManager.getLogger(EmployeeController.class);

	@GetMapping
	@ApiOperation(value = "For Get All Employees" ,notes = "This is for Read All Employee")
	public List<Employee> getAll() {
		
		log.info("============ getALL Method Start ============");
		log.info("Before Insert data | getAll() -> | ");
		List<Employee> findAll = service.findAll();
		
		log.info("after return Data | getAll() -> | employee : {}",findAll);
		log.info("============ getALL Method End ============");
		
		return findAll;
	}

	@PostMapping
	@ApiOperation(value = "Create Data", notes = "This is for Creating Employee")
	public Employee createData(@RequestBody Employee employee) {
		
		log.info("============ createData Method Start ============");
		log.info("before insert Data | createData(Employee employee) -> | Employee Value : {}",employee);
		Employee createData = service.createData(employee);
		log.info("after insert Data | Employee Created : {}",createData);
		log.info("============ createData Method End ============");
		
		return createData;
	}

	@GetMapping("/salaryWithYear")
	@ApiOperation(value = "Get By Salary With Joining Year", 
		notes = "This URI Use for Getting Employee which have Salary greater than param value and greater than param year")
	public List<Employee> getBySalaryAndJoingDate(@RequestParam int salary, 
							@RequestParam int yearOfJoining) {
		
		log.info("============ getBySalaryAndJoingDate Method Start ============");
		log.info("before insert data | getBySalaryAndJoingDate(int salary, int yearOfJoining) -> | Salary : {} | YearOFJoining : {}",salary,yearOfJoining);
		List<Employee> bySalaryAndJoingDate = service.getBySalaryAndJoingDate(salary, yearOfJoining);
		log.info("after insert data | getBySalaryAndJoingDate(int salary, int yearOfJoining) -> | List Of Employee : {}", bySalaryAndJoingDate);
		log.info("============ getBySalaryAndJoingDate Method End ============");

		return bySalaryAndJoingDate;
	}
	
	@GetMapping("/getFirstName")
	@ApiOperation(value = "Get By First Name", 
		notes = "/getFirstName End Point Use for filtering FirstName Which You Pass and save type of First Name Employees are return")
	public List<Employee> getAllFirstName(@RequestParam String firstName) {
		
		log.info("============ getAllFirstName Method Start ============");
		log.info("before insert Data | getAllFirstName(String firstName) -> | First Name : {}",firstName);
		List<Employee> allFirstName = service.getAllFirstName(firstName);
		log.info("after insert data | getAllFirstName(String firstName) -> | List oF Employee : {}",allFirstName);
		log.info("============ getAllFirstName Method End ============");

		return allFirstName;
	}

}










