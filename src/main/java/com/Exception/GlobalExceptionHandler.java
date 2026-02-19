package com.Exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(BookNotFoundException.class)
public ResponseEntity<ErrorResponse>notFoundBookHandler(BookNotFoundException ex){
	ErrorResponse e =  new ErrorResponse(
			LocalDateTime.now(),
			HttpStatus.NOT_FOUND,
			ex.getMessage(),
			" "
			);
	
	
	return new ResponseEntity<>(e,HttpStatus.NOT_FOUND);
}
	
}
