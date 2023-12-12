package com.jorge.bakeryapi.handlers.exceptions;

import org.springframework.http.HttpStatus;

public class IngredientNameAlreadyExists extends HttpStatusBaseException{
    public IngredientNameAlreadyExists(String message) {
        super(message, HttpStatus.CONFLICT);
    }
}
