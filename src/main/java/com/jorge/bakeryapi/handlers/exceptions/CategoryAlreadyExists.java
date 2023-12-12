package com.jorge.bakeryapi.handlers.exceptions;

import org.springframework.http.HttpStatus;

public class CategoryAlreadyExists extends HttpStatusBaseException{
    public CategoryAlreadyExists(String message) {
        super(message, HttpStatus.CONFLICT);
    }
}
