package com.vehicles.generator.exception;

import com.vehicles.generator.exception.exceptions.GeneratorException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(basePackages = "com.vehicles.generator.controller")
public class GlobalExceptionHandler {

    @ExceptionHandler(GeneratorException.class)
    public ResponseEntity<String> handleFileWriteException(GeneratorException e) {
        return new ResponseEntity<>(e.getLocalizedMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
