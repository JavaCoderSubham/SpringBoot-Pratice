package com.employee.example.entity;

import java.time.LocalDate;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Entity
@Table(name = "employee_db")
public class Employee {

	@Id
	@GeneratedValue
	private int employeeId;
	private String firstName;
	private String lastName;
	private int salary;
	private String dept;
	private int yearOfJoining;
	
}
