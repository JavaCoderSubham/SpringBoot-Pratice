package com.spring.motivity.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.motivity.entity.Manager;

public interface ManagerRepository extends JpaRepository<Manager, Integer>{

//	Custom Find Methods
	List<Manager> findByFirstName(String firstName);
	List<Manager> findByFirstNameAndLastName(String firstName, String lastName);
	
//	Custom StartWith Operator Methods
	List<Manager> findByEmpCodeStartingWith(String empCode);
	
	
//	Custom EndWith Operator Methods
	List<Manager> findByEmpCodeEndingWith(String empCode);
	
	
//	Custom Contain Operator Method
	List<Manager> findByEmpCodeContaining(String empCode);
	
//	Custom Not Contain Operator Method
	List<Manager> findByEmpCodeNotContaining(String empCode);
	
	
//	Custom Equals Operator Method
	List<Manager> findByEmpCodeEquals(String empCode);
	
	
//	Custom Not Equals Operator Method
	List<Manager> findByEmpCodeNot(String empCode);
	
//	Custom Between Operator Method
	List<Manager> findBySalaryBetween(int start, int end);
	
//	Custom Find By Like Operator Method
	List<Manager> findByFullNameLike(String fullName);
	
//	Custom Find By Greater then Equal Operator Method
	List<Manager> findBySalaryGreaterThanEqual(int salary);
	
	
}








