package com.project.Projeto.handler;

import com.project.Projeto.exceptions.BadRequestException;
import com.project.Projeto.exceptions.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalHandlerException {

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ErrorResponse> BadRequestException(BadRequestException ex){
        ErrorResponse errorResponse = ErrorResponse.builder(ex, ProblemDetail.forStatus(HttpStatus.BAD_REQUEST))
                .build();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorResponse> NotFoundException(NotFoundException ex){

        ErrorResponse errorResponse = ErrorResponse.builder(ex, ProblemDetail.forStatus(HttpStatus.NOT_FOUND)).build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }
}
