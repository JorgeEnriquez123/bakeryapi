package com.jorge.bakeryapi.handlers.exceptions.response;

import com.jorge.bakeryapi.handlers.BaseResponse;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public class ExceptionWrapper extends BaseResponse {
    // This Wrapper Class will let us identify Exception Objects
    // This also shares BaseResponse's attributes to All ExceptionClasses
}
