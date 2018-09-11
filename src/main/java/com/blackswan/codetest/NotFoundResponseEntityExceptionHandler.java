package com.blackswan.codetest;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * @author Mark Andrews
 */
@ControllerAdvice
public class NotFoundResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = NotFoundException.class)
    public ResponseEntity<Object> handleEntityNotFound(RuntimeException re, WebRequest request) {
        return handleExceptionInternal(re, re.getMessage(), new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }
}

