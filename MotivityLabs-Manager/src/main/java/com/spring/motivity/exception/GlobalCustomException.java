package com.spring.motivity.exception;

import java.time.LocalDateTime;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalCustomException {
	
	private Logger log = LogManager.getLogger(GlobalCustomException.class);

	@ExceptionHandler(ManagerIdNotFoundException.class)
	public ResponseEntity<ErrorDetails> managerIdNotFound() {
		
		log.error("Manager ID Not Found Exception : ");
		
		ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), 404, "Not Found", "Manager ID Not Found");
		return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.NOT_FOUND);
	}
	
}
