package com.example.demo.exception;

import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

// private final, getter, public constructor, equals, hashcode
// and to string
public record ApiException (String message,
                            Throwable throwable,
                            HttpStatus httpStatus,
                            ZonedDateTime zonedDateTime) {
}
