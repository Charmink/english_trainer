package com.english_trainer.english_trainer.controllers;

import com.english_trainer.english_trainer.exceptions.NullResultException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.english_trainer.english_trainer.errorResponse.Error;

@RestControllerAdvice
public class ExceptionController {
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(NullResultException.class)
    public Error onNullResult(NullResultException exception){
        return new Error("Incorrect parameters", exception.getMessage());
    }

}