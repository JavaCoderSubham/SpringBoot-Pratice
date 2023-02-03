package com.spring.motivity.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//import lombok.NonNull;
//import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Entity
@Data
//@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Manager {

	@Id
	@GeneratedValue
	private int managerId;
//	@NonNull
	private String firstName;
//	@NonNull
	private String lastName;
	private String fullName;	// not Need to in Constructor 
//	@NonNull
	private String dept;
//	@NonNull
	private int salary;
//	@NonNull
	private String empCode;
	
}







