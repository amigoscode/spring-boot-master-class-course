package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZonedDateTime;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(value = ApiRequestException.class)
    public ResponseEntity<Object> handleApiRequestException(
            ApiRequestException exception
    ){

        ApiException apiException = new ApiException(
                exception.getMessage(),
                exception,
                HttpStatus.BAD_REQUEST,
                ZonedDateTime.now());
        return new ResponseEntity<>(apiException, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = NotFoundException.class)
    public ResponseEntity<Object> handleApiRequestException(
            NotFoundException exception
    ){

        ApiException apiException = new ApiException(
                exception.getMessage(),
                exception,
                HttpStatus.NOT_FOUND,
                ZonedDateTime.now());
        return new ResponseEntity<>(apiException, HttpStatus.NOT_FOUND);
    }
}
