package com.jorge.bakeryapi.handlers.exceptions;

import org.springframework.http.HttpStatus;

public class RoleAlreadyExists extends HttpStatusBaseException{
    public RoleAlreadyExists(String message) {
        super(message, HttpStatus.CONFLICT);
    }
}
