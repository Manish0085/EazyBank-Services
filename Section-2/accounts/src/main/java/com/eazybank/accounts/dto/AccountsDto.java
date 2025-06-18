package com.eazybank.accounts.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Schema(
        name = "Account",
        description = "Schema to hold Account and Customer details"
)
@Data
public class AccountsDto {

    @Schema(

            description = "Account Number"
    )
    @NotEmpty(message = "Account number cannot be empty")
    @Pattern(regexp = "^$|[0-9]{10}", message = "the Account number must be of 10 digits")
    private Long accountNumber;

    @Schema(
            description = "Account Type", example = "Current/Saving"
    )
    @NotEmpty(message = "Account type cannot be null or empty")
    private String accountType;

    @Schema(
            description = "Branch Address", example = "123 street no. 1 Preet Vihar, Meerut"
    )
    @NotEmpty(message = "Branch Address cannot be null or empty")
    private String branchAddress;
}
