package com.eazybank.accounts.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Setter;

@Schema(
        name = "Customer",
        description = "Schema to hold Account and Customer Data"
)
@Data
public class CustomerDto {


    @Schema(
            description = "Customer name", example = "Mohan Reddy"
    )
    @NotEmpty(message = "Name cannot be empty")
    @Size(min = 5, max = 30, message = "Length of name must be between 5 to 30")
    private String name;

    @Schema(
            description = "Customer Email Address", example = "reddymohan@gmail.com"
    )
    @NotEmpty(message = "Email cannot be empty")
    @Email(message = "Email must be in valid formate")
    private String email;

    @Schema(
            description = "Customer Contact Number", example = "0123456789"
    )
    @NotEmpty(message = "Mobile number cannot be empty")
    @Pattern(regexp = "^$|[0-9]{10}", message = "the mobile number must be of 10 digits")
    private String mobileNumber;

    private AccountsDto accountsDto;
}
