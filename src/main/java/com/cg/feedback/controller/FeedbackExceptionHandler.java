package com.cg.feedback.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cg.feedback.exception.CustomException;

@RestControllerAdvice
public class FeedbackExceptionHandler {
	
	@ExceptionHandler(CustomException.class)
	public ResponseEntity<String> userExceptionHandler(CustomException exception)
	{
		return new ResponseEntity<>(exception.getMessage(),HttpStatus.BAD_REQUEST);
	}
	
//	@ExceptionHandler(Exception.class)
//	public ResponseEntity<String> userExceptionHandler(Exception exception)
//	{
//		return new ResponseEntity<>(exception.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
//	}
}
