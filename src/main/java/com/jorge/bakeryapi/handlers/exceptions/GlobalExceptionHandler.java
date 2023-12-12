package com.jorge.bakeryapi.handlers.exceptions;

import com.jorge.bakeryapi.handlers.exceptions.response.ExceptionResponse;
import com.jorge.bakeryapi.handlers.exceptions.response.ValidationHandlerResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ValidationHandlerResponse invalidArgumentHandler(MethodArgumentNotValidException ex){
        Map<String, String> errorMap = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error -> {
            errorMap.put(error.getField(), error.getDefaultMessage());
        });
        return ValidationHandlerResponse.builder()
                .status(HttpStatus.BAD_REQUEST.value())
                .timestamp(LocalDateTime.now())
                .errors(errorMap)
                .build();
    }
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(RuntimeException.class)
    public ExceptionResponse internalServerError(RuntimeException ex){
        return buildExceptionResponse(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
    }

    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ExceptionResponse methodNotAllowed(HttpRequestMethodNotSupportedException ex){
        return buildExceptionResponse(HttpStatus.METHOD_NOT_ALLOWED, ex.getMessage());
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public ExceptionResponse notFoundException(NotFoundException ex){
        return buildExceptionResponse(HttpStatus.NOT_FOUND, ex.getMessage());
    }

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(UsernameAlreadyExists.class)
    public ExceptionResponse usernameAlreadyTaken(UsernameAlreadyExists ex){
        return buildExceptionResponse(HttpStatus.CONFLICT, ex.getMessage());
    }

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(RoleAlreadyExists.class)
    public ExceptionResponse roleAlreadyTaken(RoleAlreadyExists ex){
        return buildExceptionResponse(HttpStatus.CONFLICT, ex.getMessage());
    }

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(CategoryAlreadyExists.class)
    public ExceptionResponse categoryAlreadyTaken(CategoryAlreadyExists ex){
        return buildExceptionResponse(HttpStatus.CONFLICT, ex.getMessage());
    }

    public ExceptionResponse buildExceptionResponse(HttpStatus httpStatus, String exceptionMessage){
        return ExceptionResponse.builder()
                .status(httpStatus.value())
                .timestamp(LocalDateTime.now())
                .message(exceptionMessage)
                .build();
    }
}
