package com.springboot.app.exception;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ApiExceptionHandler {
	
	@ExceptionHandler(value = ApiRequestException.class)
	public ResponseEntity<Object> handleException(ApiRequestException exception,WebRequest request){
		
		ApiException apiexception = new ApiException(new Date(), exception.getMessage(), request.getDescription(false));
		
		 return new ResponseEntity<>(apiexception, HttpStatus.NOT_FOUND);
	   };
	   

	   
	
}
