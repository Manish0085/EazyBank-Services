package com.eazybank.cards.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ErrorResponseDto {

    @Schema(
            description = "Api Path on which the error is encountered"
    )
    private String apiPath;

    @Schema(
            description = "Error code to show the type of error"
    )
    private HttpStatus errorCode;

    @Schema(
            description = "Error message"
    )
    private String errorMsg;

    @Schema(
            description = "Time at which the error is encountered"
    )
    private LocalDateTime errorTime;


}
