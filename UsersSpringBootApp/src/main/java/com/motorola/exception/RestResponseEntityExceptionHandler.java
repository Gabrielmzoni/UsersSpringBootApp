package com.motorola.exception;

import java.net.http.HttpHeaders;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandler 
  extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value 
      = { IllegalArgumentException.class, IllegalStateException.class })
    protected ResponseEntity<Object> handleConflict(
      RuntimeException ex, WebRequest request) {
		/*
		 * String bodyOfResponse = "This should be application specific"; return
		 * handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(),
		 * HttpStatus.CONFLICT, request);
		 */
    	Map errors = new HashMap<>();
    	errors.put("Error Message", ex.getMessage());
    	
    	
    	return new ResponseEntity<Object>(errors,HttpStatus.NOT_FOUND);
    	
    }
}