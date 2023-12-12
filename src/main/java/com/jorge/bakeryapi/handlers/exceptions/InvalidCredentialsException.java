package com.jorge.bakeryapi.handlers.exceptions;

import org.springframework.http.HttpStatus;

public class InvalidCredentialsException extends HttpStatusBaseException{
    public InvalidCredentialsException(String message) {
        super(message, HttpStatus.UNAUTHORIZED);
    }
}
