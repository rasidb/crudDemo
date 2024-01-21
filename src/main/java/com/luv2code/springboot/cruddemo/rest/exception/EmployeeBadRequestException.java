package com.luv2code.springboot.cruddemo.rest.exception;

public class EmployeeBadRequestException extends RuntimeException {
    public EmployeeBadRequestException() {
    }

    public EmployeeBadRequestException(String message) {
        super(message);
    }

    public EmployeeBadRequestException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmployeeBadRequestException(Throwable cause) {
        super(cause);
    }
}
