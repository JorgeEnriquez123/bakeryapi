package com.jorge.bakeryapi.handlers.exceptions;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class ExceptionResponse {
    private Integer httpStatus;
    private String message;
}
