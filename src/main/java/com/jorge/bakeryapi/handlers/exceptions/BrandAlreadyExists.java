package com.jorge.bakeryapi.handlers.exceptions;

import org.springframework.http.HttpStatus;

public class BrandAlreadyExists extends HttpStatusBaseException{
    public BrandAlreadyExists(String message) {
        super(message, HttpStatus.CONFLICT);
    }
}
