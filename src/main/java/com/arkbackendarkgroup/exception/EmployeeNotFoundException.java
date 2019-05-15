package com.arkbackendarkgroup.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EmployeeNotFoundException extends RuntimeException{

    Logger logger = LoggerFactory.getLogger(EmployeeNotFoundException.class);
    public EmployeeNotFoundException(String message){

        super(message);

    }
    public EmployeeNotFoundException(Long id) {
        super("Employee id not found : " + id);
    }
    public EmployeeNotFoundException(String messsage , Throwable cause){

        super(messsage,cause);
    }
}
