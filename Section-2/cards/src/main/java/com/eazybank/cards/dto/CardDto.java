package com.eazybank.cards.dto;

import com.eazybank.cards.entity.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;

@Data
public class CardDto {



    @NotEmpty(message = "Mobile number should not be empty")
    @Pattern(regexp = "^$|[0-9]{10}", message = "Invalid mobile number")
    @Schema(
            description = "mobile number of customer", example = "0123456789"
    )
    private String mobileNumber;

    @NotEmpty(message = "Card Number should not be empty")
    @Pattern(regexp = "^$|[0-9]{12}", message = "Card number is not valid")
    @Schema(
            description = "12 digit Card number", example = "102345678901"
    )
    private String cardNumber;

    @Schema(
            description = "Type of card", example = "DEBIT/CREDIT"
    )
    @NotEmpty(message = "Card type should not be null")
    private String cardType;

    @Schema(
            description = "Total limit available against card", example = "10000"
    )
    @Positive(message = "Total card limit should be greater than 0")
    private int totalLimit;

    @Schema(
            description = "Total amount used against card", example = "1100"
    )
    @Positive(message = "Total Amount used should be equal or greater then 0")
    private int amountUsed;

    @Schema(
            description = "Total amount available against card", example = "100000"
    )
    @PositiveOrZero(message = "Total available amount should be equal or greater than 0")
    private int availableAmount;


}
