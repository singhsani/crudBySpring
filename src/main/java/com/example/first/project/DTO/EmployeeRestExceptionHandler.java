package com.example.first.project.DTO;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
@ControllerAdvice
public class EmployeeRestExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<ErrorResponse> errorHandler(CustomException ces){
        ErrorResponse err=new ErrorResponse();
        err.setStatus(HttpStatus.NOT_FOUND.value());
        err.setMessage(ces.getMessage());
        err.setTimeStamp(System.currentTimeMillis());
        return new ResponseEntity<>(err,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> errorHandler(Exception ces){
        ErrorResponse err=new ErrorResponse();
        err.setStatus(HttpStatus.NOT_FOUND.value());
        err.setMessage(ces.getMessage());
        err.setTimeStamp(System.currentTimeMillis());
        return new ResponseEntity<>(err,HttpStatus.NOT_FOUND);
    }
}
