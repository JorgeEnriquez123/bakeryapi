package com.jorge.bakeryapi.handlers.exceptions;

import org.springframework.http.HttpStatus;

public class UniqueViolationException extends HttpStatusBaseException{
    public UniqueViolationException(String message) {
        super(message, HttpStatus.CONFLICT);
    }
}
