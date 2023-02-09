package com.employee.example.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.employee.example.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

	
	@Query("select u from Employee u where u.salary > ?1 and u.yearOfJoining > ?2")
	public List<Employee> getBySalaryAndJoingDate(int salary, int yearOfJoining);

	@Query("select u from Employee u where u.firstName=?1")
	public List<Employee> getAllFirstName(String firstName);
	
	
}
