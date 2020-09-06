package com.restfulservices.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class EmployeeException extends RuntimeException {
    public EmployeeException(String empId) {
        super(empId);
    }

}
