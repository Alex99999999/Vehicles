package com.vehicles.generator.exception;

import com.vehicles.generator.exception.exceptions.FileWriteException;
import com.vehicles.generator.exception.exceptions.JsonException;
import com.vehicles.generator.exception.exceptions.NoSuchWriterException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(basePackages = "com.vehicles.generator.controller")
public class GlobalExceptionHandler {

    @ExceptionHandler(FileWriteException.class)
    public ResponseEntity<String> handleFileWriteException(FileWriteException e) {
        return new ResponseEntity<>(e.getLocalizedMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(NoSuchWriterException.class)
    public ResponseEntity<String> handleNoSuchWriterException(NoSuchWriterException e) {
        return new ResponseEntity<>(e.getLocalizedMessage(), HttpStatus.NOT_IMPLEMENTED);
    }

    @ExceptionHandler(JsonException.class)
    public ResponseEntity<String> handleJsonException(JsonException e) {
        return new ResponseEntity<>(e.getLocalizedMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
