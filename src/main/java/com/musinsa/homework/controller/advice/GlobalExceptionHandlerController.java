package com.musinsa.homework.controller.advice;

import com.musinsa.homework.enums.DefaultErrorType;
import com.musinsa.homework.exception.ApiRuntimeException;
import jakarta.validation.ConstraintViolationException;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.util.Objects;


@RestControllerAdvice
public class GlobalExceptionHandlerController {
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandlerController.class);

    @ExceptionHandler(ApiRuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<ApiRuntimeException> apiRuntimeException(ApiRuntimeException e) {
        logger.error("API ERROR || CODE => {} :: MESSAGE => {}", e.getErrorCode(), e.getErrorMessage(), e);

        if (StringUtils.equals(e.getErrorCode(), DefaultErrorType.INVALID_PARAMETER.getCode())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e);
        }

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
    }

    @ExceptionHandler({BindException.class, MethodArgumentNotValidException.class})
    public ResponseEntity<ApiRuntimeException> http400BindExceptionCase(BindException e) {
        logger.error("MESSAGE => {}", e.getMessage(), e);

        return this.generateErrorMessageForBindException(e);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ApiRuntimeException> http400ConstraintViolationExceptionCase(ConstraintViolationException e) {
        logger.error("MESSAGE => {}", e.getMessage(), e);

        return this.generateErrorMessageForConstraintViolationException(e);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ApiRuntimeException> http400ConstraintHttpMessageNotReadableExceptionCase(HttpMessageNotReadableException e) {
        logger.error("MESSAGE => {}", e.getMessage(), e);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiRuntimeException(DefaultErrorType.HTTP_400.getCode()
                , DefaultErrorType.HTTP_400.getMessage() + " Please check your parameter type."));
    }

    @ExceptionHandler({NoResourceFoundException.class, MethodArgumentTypeMismatchException.class})
    public ResponseEntity<ApiRuntimeException> http404(Exception e) {
        logger.error("MESSAGE => {}", e.getMessage(), e);

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiRuntimeException(DefaultErrorType.HTTP_404));
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<ApiRuntimeException> http405(HttpRequestMethodNotSupportedException e) {
        logger.error("MESSAGE => {}", e.getMessage(), e);

        return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED)
                .body(new ApiRuntimeException(DefaultErrorType.HTTP_405.getCode()
                        , DefaultErrorType.HTTP_405.getMessage() + " Allow methods => " + e.getSupportedHttpMethods()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiRuntimeException> exception(Exception e) {
        logger.error("MESSAGE => {}", e.getMessage(), e);

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiRuntimeException(DefaultErrorType.UNKNOWN));
    }

    private ResponseEntity<ApiRuntimeException> generateErrorMessageForBindException(BindException e) {
        StringBuilder sb = new StringBuilder();

        sb.append(DefaultErrorType.INVALID_PARAMETER.getMessage());
        e.getBindingResult().getFieldErrors().forEach(fieldError ->
                sb.append(" ")
                        .append("WRONG VALUE => ").append(Objects.nonNull(fieldError.getRejectedValue()) ? fieldError.getRejectedValue().toString() : "null")
                        .append(" :: ")
                        .append("MESSAGE => ").append(fieldError.getDefaultMessage()));

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiRuntimeException(DefaultErrorType.INVALID_PARAMETER.getCode(), sb.toString()));
    }

    private ResponseEntity<ApiRuntimeException> generateErrorMessageForConstraintViolationException(ConstraintViolationException e) {
        StringBuilder sb = new StringBuilder();

        sb.append(DefaultErrorType.INVALID_PARAMETER.getMessage());
        e.getConstraintViolations().forEach(violation ->
                sb.append(" ")
                        .append("WRONG VALUE => ").append(Objects.nonNull(violation.getInvalidValue()) ? violation.getInvalidValue().toString() : "null")
                        .append(" :: ")
                        .append("MESSAGE => ").append(violation.getMessage()));

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiRuntimeException(DefaultErrorType.INVALID_PARAMETER.getCode(), sb.toString()));
    }
}