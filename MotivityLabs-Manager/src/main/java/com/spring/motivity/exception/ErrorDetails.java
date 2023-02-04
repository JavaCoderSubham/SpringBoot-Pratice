package com.spring.motivity.exception;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorDetails {

	private LocalDateTime timeStamp;
	private int statusCode;
	private String error;
	private String message;
	
}
