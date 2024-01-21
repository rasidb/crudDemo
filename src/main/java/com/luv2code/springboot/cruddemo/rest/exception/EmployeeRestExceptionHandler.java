package com.luv2code.springboot.cruddemo.rest.exception;

import com.luv2code.springboot.cruddemo.rest.exception.response.EmployeeErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class EmployeeRestExceptionHandler {
    //add an exception handler using @ExceptionHandler
    @ExceptionHandler
    public ResponseEntity<EmployeeErrorResponse> handlerException(EmployeeNotFoundException e) {
        //create a StudentErrorResponse
        EmployeeErrorResponse error = new EmployeeErrorResponse();
        error.setStatusCode(HttpStatus.NOT_FOUND.value());
        error.setMessage(e.getMessage());
        error.setTimeStamp(System.currentTimeMillis());
        //return ResponseEntity
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<EmployeeErrorResponse> otherExceptions(EmployeeBadRequestException e) {
        EmployeeErrorResponse studentErrorResponse = new EmployeeErrorResponse();
        studentErrorResponse.setStatusCode(HttpStatus.BAD_REQUEST.value());
        studentErrorResponse.setMessage(e.getMessage());
        studentErrorResponse.setTimeStamp(System.currentTimeMillis());
        return new ResponseEntity<>(studentErrorResponse, HttpStatus.BAD_REQUEST);
    }
}
