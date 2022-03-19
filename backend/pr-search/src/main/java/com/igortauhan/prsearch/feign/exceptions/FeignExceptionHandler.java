package com.igortauhan.prsearch.feign.exceptions;

import feign.FeignException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
public class FeignExceptionHandler {

    @ExceptionHandler(value = {FeignException.class})
    public ResponseEntity<StandardError> feignException(FeignException ex, HttpServletResponse response) {
        StandardError error = new StandardError(System.currentTimeMillis(), ex.status(), "Feign Exception");
        return ResponseEntity.status(ex.status()).body(error);
    }
}
