package com.spring.security.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class UserInfo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	private String name;
	private String email;
	private String password;
	private String roles;

}
