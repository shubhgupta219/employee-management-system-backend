package com.ems.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	
	public ResponseEntity<String> handleException(Exception ex){
		
		return ResponseEntity
				.badRequest()
				.body(ex.getMessage());
	}
	
}
