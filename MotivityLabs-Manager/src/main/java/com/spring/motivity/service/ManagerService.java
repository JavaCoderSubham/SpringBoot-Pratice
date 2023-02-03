package com.spring.motivity.service;

import java.util.List;

import com.spring.motivity.entity.Manager;

public interface ManagerService {
	
	List<Manager> getAll();
	
	Manager getById(int id);
	
	Manager createData(Manager manager);
	
	Manager updateData(Manager manager);
	
	String deleteData(int id);
	
//	Custom Find Methods
	List<Manager> findByFirstName(String firstName);
	
//	Custom Find And Methods
	List<Manager> findByFirstNameAndLastName(String firstName, String lastName);
	
//	Custom Find Starting With Method
	List<Manager> findByEmpCodeStartingWith(String empCode);
	
//	Custom Find Ending With Method
	List<Manager> findByEmpCodeEndingWith(String empCode);

//	Custom Find Contain Method
	List<Manager> findByEmpCodeContains(String empCode);
	
//	Custom Find Not Contain Method
	List<Manager> findByEmpCodeNotContains(String empCode);
	
	
//	Custom Find Equals Method
	List<Manager> findByEmpCodeEqual(String empCode);
	
	
//	Custom Find Not Equals Method
	List<Manager> findByEmpCodeNotEqual(String empCode);
	
	
//	Custom Find Between Method
	List<Manager> findBySalaryBetween(int start, int end);

	
//	Custom Find Full Name Like Method
	List<Manager> findByFullNameLike(String fullName);
	
	
//	Custom Find Greater Then Equals Method
	List<Manager> findBySalaryGreaterThanEqual(int salary);
	
	
	
	
}





