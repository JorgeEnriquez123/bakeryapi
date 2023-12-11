package com.jorge.bakeryapi.handlers.exceptions;

import org.springframework.http.HttpStatus;

public class NotFoundException extends HttpStatusBaseException{
    public NotFoundException(String message) {
        super(message, HttpStatus.NOT_FOUND);
    }
}
