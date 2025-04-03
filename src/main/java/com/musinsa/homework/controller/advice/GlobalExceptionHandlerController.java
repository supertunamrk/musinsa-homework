package com.musinsa.homework.controller.advice;

import com.musinsa.homework.enums.DefaultErrorType;
import com.musinsa.homework.exception.ApiRuntimeException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

@RestControllerAdvice
public class GlobalExceptionHandlerController {
    @ExceptionHandler(ApiRuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ApiRuntimeException apiRuntimeException(ApiRuntimeException e) {
        return e;
    }

    @ExceptionHandler({NoHandlerFoundException.class, Exception.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ApiRuntimeException exception(Exception e) {
        return new ApiRuntimeException(DefaultErrorType.UNKNOWN);
    }
}