package com.jorge.bakeryapi.handlers.exceptions;


import org.springframework.http.HttpStatus;

public class UsernameAlreadyExists extends HttpStatusBaseException{
    public UsernameAlreadyExists(String message) {
        super(message, HttpStatus.CONFLICT);
    }
}
