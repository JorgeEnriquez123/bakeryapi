package com.jorge.bakeryapi.handlers.exceptions.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class ValidationHandlerResponse extends ExceptionWrapper {
    private Map<String, String> errors;
}
