package com.vehicles.controller.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;

@RestControllerAdvice(basePackages = "com.vehicles.controller")
public class GlobalExceptionHandler {

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<String> handleConstraintViolationException(final ConstraintViolationException e) {
        final String message = e.getMessage().substring(e.getMessage().lastIndexOf(":") + 2);
        return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
    }


}
