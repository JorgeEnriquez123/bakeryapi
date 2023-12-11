package com.jorge.bakeryapi.handlers;

import com.jorge.bakeryapi.handlers.exceptions.BaseResponse;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class SuccessResponse extends BaseResponse {
    Object data;
}
