package com.cognizant.main.globalexception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
@ControllerAdvice
public class globalexception {

	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<String> exceptionHandler(Exception e)
	{
		ResponseEntity<String> errorRespose = new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
		return errorRespose;
	}
}
