package com.jorge.bakeryapi.handlers.exceptions;


import org.springframework.http.HttpStatus;

public class UsernameAlreadyTakenException extends HttpStatusBaseException{
    public UsernameAlreadyTakenException(String message) {
        super(message, HttpStatus.CONFLICT);
    }
}
