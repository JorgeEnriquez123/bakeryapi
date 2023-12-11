package com.jorge.bakeryapi.handlers;

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
