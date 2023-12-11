package com.jorge.bakeryapi.handlers.exceptions;

import org.springframework.http.HttpStatus;

public class HttpStatusBaseException extends RuntimeException{
    HttpStatus httpStatus;

    public HttpStatusBaseException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }
}
