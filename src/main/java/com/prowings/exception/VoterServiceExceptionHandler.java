package com.prowings.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.prowings.entity.Error;

@ControllerAdvice
public class VoterServiceExceptionHandler {
	
	@ExceptionHandler(value = InvalidVoterException.class)
	public ResponseEntity handleInvalidVoterException(Exception e, WebRequest request)
	{
		System.out.println("Inside InvalidVoterExceptionHandler!!!");
		System.out.println("Invalid voter Exception occurred!!");
		System.out.println(e.getMessage());
		System.out.println(request.getContextPath());
		System.out.println(request.getParameterMap());
		
		Error err = new Error();
		err.setErrorMessage(e.getMessage());
		err.setHttpStatus(HttpStatus.BAD_REQUEST);
		
		return new ResponseEntity<>(err, err.getHttpStatus());
	}

}
