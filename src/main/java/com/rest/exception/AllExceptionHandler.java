package com.rest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.rest.payload.ApiResponse;

@RestControllerAdvice
public class AllExceptionHandler {

	@ExceptionHandler(value = StudentNotFound.class)
	public ResponseEntity<ApiResponse> StudentNotFoundException(StudentNotFound ex) {		
		ApiResponse resp = new ApiResponse(ex.getMessage(), HttpStatus.NOT_FOUND);
		return new ResponseEntity<ApiResponse>(resp, HttpStatus.NOT_FOUND);
	}
}
