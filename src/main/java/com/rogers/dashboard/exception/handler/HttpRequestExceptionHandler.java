package com.rogers.dashboard.exception.handler;

import com.rogers.dashboard.exception.HttpRequestException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class HttpRequestExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(HttpRequestExceptionHandler.class);

    @ExceptionHandler(HttpRequestException.class)
    public ResponseEntity<String> myExceptionHandler(HttpRequestException e) {
        LOGGER.error(e.getMessage());
        return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
