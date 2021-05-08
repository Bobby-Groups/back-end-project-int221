package com.springboot.app.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ApiRequestException extends RuntimeException {
	  private static final long serialVersionUID = 1L;

public ApiRequestException(String message) {
	super(message);
	
}




 
 
 
}
