package com.spring.jpa.springbootjpa.advice;

import com.spring.jpa.springbootjpa.exception.ResourceNotFoundException;
import com.spring.jpa.springbootjpa.model.Failure;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@ResponseBody
public class ControllerAdvice {

    // Try to comment out below to see default ResourceNotFoundException code and reason.
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Failure> handleResourceNotException(ResourceNotFoundException resourceNotFoundException){
        Failure failure = new Failure(HttpStatus.NOT_FOUND.value(), "Resource was not found on server side", resourceNotFoundException.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(failure);
    }
}
