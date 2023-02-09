package com.employee.example.service;


import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.example.entity.Employee;
import com.employee.example.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepository repository;
	
	private final Logger log = LogManager.getLogger(EmployeeServiceImpl.class);
	
	@Override
	public List<Employee> findAll() {
		log.info("before Respository | findAll() -> | ");
		List<Employee> findAll = repository.findAll();
		log.info("after Repository | findAll() -> | List Of Employee : {}", findAll);
		return findAll;
	}

	@Override
	public Employee createData(Employee employee) {
		log.info("Before Repository | createData(Employee employee) -> | Employee : {}" , employee);
		Employee save = repository.save(employee);
		log.info("After Repository | createData(Employee employee) -> | Employee : {}",employee);
		return save;
	}

	@Override
	public List<Employee> getBySalaryAndJoingDate(int salary, int yearOfJoining) {
		log.info("before Repository | getBySalaryAndJoingDate(int salary, int yearOfJoining) -> | Salary : {} | YearOfJoining : {}", salary, yearOfJoining);
		List<Employee> bySalaryAndJoingDate = repository.getBySalaryAndJoingDate(salary, yearOfJoining);
		log.info("after Repository | getBySalaryAndJoingDate(int salary, int yearOfJoining) -> | List Of Employee : {}", bySalaryAndJoingDate);
		
		return bySalaryAndJoingDate;
	}

	@Override
	public List<Employee> getAllFirstName(String firstName) {
		log.info("before Repository | getAllFirstName(String firstName) -> | FirstName : {}", firstName);
		List<Employee> allFirstName = repository.getAllFirstName(firstName);
		log.info("after Repository | getAllFirstName(String firstName) -> | List Of Employee : {}", allFirstName);
		
		return allFirstName;
	}

}
