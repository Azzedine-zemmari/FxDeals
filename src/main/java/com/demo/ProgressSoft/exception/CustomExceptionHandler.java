package com.demo.ProgressSoft.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

@ControllerAdvice
public class CustomExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiErreur> handleValidationException(MethodArgumentNotValidException e){
        String errors = e.getBindingResult().getFieldErrors()
                .stream()
                .map(erreur -> erreur.getField() + ": " + erreur.getDefaultMessage())
                .collect(Collectors.joining());
        ApiErreur apiErreur = new ApiErreur(400,LocalDateTime.now(),errors);
        return new ResponseEntity<>(apiErreur,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DealInvalidException.class)
    public ResponseEntity<ApiErreur> DealInvalidException(DealInvalidException e){
        ApiErreur apiErreur = new ApiErreur(400,LocalDateTime.now(),e.getMessage());
        return new ResponseEntity<>(apiErreur,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DealAlreadyExistsException.class)
    public ResponseEntity<ApiErreur> handleDealAlreadyExistsException(DealAlreadyExistsException e){
        ApiErreur apiErreur = new ApiErreur(409, LocalDateTime.now() , e.getMessage());
        return new ResponseEntity<>(apiErreur, HttpStatus.CONFLICT);
    }
    @ExceptionHandler(DealNotFoundException.class)
    public ResponseEntity<ApiErreur> handleDealNotFoundException(DealNotFoundException e){
        ApiErreur apiErreur = new ApiErreur(404, LocalDateTime.now() , e.getMessage());
        return new ResponseEntity<>(apiErreur, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(InvalidCurrencyException.class)
    public ResponseEntity<ApiErreur> handleInvalidCurrencyException(InvalidCurrencyException e){
        ApiErreur apiErreur = new ApiErreur(400,LocalDateTime.now(),e.getMessage());
        return new ResponseEntity<>(apiErreur,HttpStatus.BAD_REQUEST);
    }


}
