package com.project.Projeto.handler;

import com.project.Projeto.exceptions.BadRequestException;
import com.project.Projeto.exceptions.InternalServerErrorException;
import com.project.Projeto.exceptions.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalHandlerException {

    @ExceptionHandler(InternalServerErrorException.class)
    public ResponseEntity<ErrorResponse> InternalErrorException(InternalServerErrorException ex){
        ErrorResponse errorResponse = ErrorResponse.builder(ex, ProblemDetail.forStatus(HttpStatus.INTERNAL_SERVER_ERROR))
                .build();

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ErrorResponse> BadRequestException(BadRequestException ex){

        ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);
        problemDetail.setTitle("Má requisição enviada ao servidor");
        problemDetail.setDetail("Algo passado no JSON foi passado de forma incorreta, corrija seu JSON");

        ErrorResponse errorResponse = ErrorResponse.builder(ex, problemDetail)
                .build();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorResponse> NotFoundException(NotFoundException ex){

        ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.NOT_FOUND);
        problemDetail.setTitle("Dados não encontrados");
        problemDetail.setDetail("os dados ao qual está procurando não foi achado");

        ErrorResponse errorResponse = ErrorResponse.builder(ex, problemDetail).build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }
}

