package com.jorge.bakeryapi.handlers;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class ValidationHandlerResponse {
    private Integer httpStatus;
    @JsonFormat(pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime timestamp;
    private Map<String, String> errors;
}
