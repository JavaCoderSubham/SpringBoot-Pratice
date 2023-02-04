package com.spring.motivity.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class ManagerIdNotFoundException extends RuntimeException{

	public ManagerIdNotFoundException(String message) {
		super(message);
	}
}
