package com.eazybank.accounts.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@Schema(
        name = "Error Response Dto",
        description = "Schema to hold Error Response"
)
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

    public ErrorResponseDto(String apiPath, HttpStatus errorCode, String errorMsg, LocalDateTime now){
        this.apiPath = apiPath;
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
        this.errorTime = LocalDateTime.now();
    }
}
