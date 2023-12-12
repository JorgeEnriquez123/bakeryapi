package com.jorge.bakeryapi.handlers.exceptions;

import org.springframework.http.HttpStatus;

public class ProductAlreadyExists extends HttpStatusBaseException{
    public ProductAlreadyExists(String message) {
        super(message, HttpStatus.CONFLICT);
    }
}
