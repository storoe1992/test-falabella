package com.test.falabella.controller;

import com.test.falabella.domain.request.ErrorResponse;
import com.test.falabella.exceptions.RepositoryEntityException;
import com.test.falabella.exceptions.NotValidUrlException;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.annotation.Priority;

@ControllerAdvice
@Priority(Ordered.HIGHEST_PRECEDENCE)
public class AdviceController {


    @ExceptionHandler(value = {NotValidUrlException.class})
    public ResponseEntity<ErrorResponse> handleBadRequestParam(NotValidUrlException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse(e.getMessage()));
    }

    @ExceptionHandler(value = {Exception.class, RepositoryEntityException.class})
    public ResponseEntity<ErrorResponse> handleGenericError(Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ErrorResponse(e.getMessage()));
    }

}
