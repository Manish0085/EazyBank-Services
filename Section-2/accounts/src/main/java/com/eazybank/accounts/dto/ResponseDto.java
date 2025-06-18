package com.eazybank.accounts.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Schema(
        name = "Success Response Schema",
        description = "Schema to hold the success response"
)
public class ResponseDto {


    @Schema(
            description = "Success Response Code", example = "200"
    )
    private String statusCode;

    @Schema(
            description = "Success Response Message", example = "Account is created successfully"
    )
    private String statusMsg;

    public ResponseDto(String statusCode, String statusMsg){
        this.statusCode = statusCode;
        this.statusMsg = statusMsg;
    }
}
