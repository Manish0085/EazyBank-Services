package com.eazybank.cards.controller;


import com.eazybank.cards.constants.CardConstants;
import com.eazybank.cards.dto.CardDto;
import com.eazybank.cards.dto.ResponseDto;
import com.eazybank.cards.service.ICardService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
@Validated
@Tag(
        name = "EazyBank Card REST API",
        description = "EazyBank Card REST API to create, read, update and delete card"
)
public class CardController {

    private ICardService iCardService;


    @Operation(
            summary = "Create REST API",
            description = "EazyBank create REST API to create card"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "201",
                    description = "Card created successfully"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "INTERNAL SERVER ERROR"
            )
    })
    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createCard(@RequestParam
                                                      @Pattern(regexp = "^$|[0-9]{10}", message = "Invalid mobile number")
                                                      String  mobileNumber){
        iCardService.createCard(mobileNumber);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto(CardConstants.STATUS_201, CardConstants.MESSAGE_201));
    }


    @Operation(
            summary = "UPDATE REST API",
            description = "EazyBank Update REST API to update card details"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Card data updated successfully"
            ),
            @ApiResponse(
                    responseCode = "417",
                    description = "EXPECTATION_FAILED"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "INTERNAL_SERVER_ERROR"
            )
    })
    @PutMapping("/update")
    public ResponseEntity<ResponseDto> updateCard(@Valid @RequestBody CardDto cardDto){
        Boolean isUpdated = iCardService.updateCard(cardDto);
        if (isUpdated){
            return ResponseEntity
                    .status(HttpStatus.ACCEPTED)
                    .body(new ResponseDto(CardConstants.STATUS_200, CardConstants.MESSAGE_200));
        }
        return ResponseEntity
                .status(HttpStatus.EXPECTATION_FAILED)
                .body(new ResponseDto(CardConstants.STATUS_417, CardConstants.MESSAGE_417_UPDATE));
    }

    @Operation(
            summary = "FETCH REST API",
            description = "EazyBank FETCH REST API to read card data"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Data Fetched successfully"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "INTERNAL_SERVER_ERROR"
            )
    })
    @GetMapping("/fetch")
    public ResponseEntity<CardDto> fetchCardDetails(@RequestParam
                                                        @Pattern(regexp = "^$|[0-9]{10}", message = "Invalid mobile number")
                                                        String mobileNumber){
        CardDto cardDto = iCardService.fetchCardDetails(mobileNumber);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(cardDto);
    }

    @Operation(
            summary = "DELETE REST API",
            description = "EazyBank delete REST API to update card details"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Card data deleted successfully"
            ),
            @ApiResponse(
                    responseCode = "417",
                    description = "EXPECTATION_FAILED"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "INTERNAL_SERVER_ERROR"
            )
    })
    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDto> deleteCard(@RequestParam
                                                      @Pattern(regexp = "^$|[0-9]{10}", message = "Invalid mobile number")
                                                      String mobileNumber){
        boolean isDeleted = iCardService.deleteCard(mobileNumber);
        if (isDeleted){
            return ResponseEntity
                    .status(HttpStatus.ACCEPTED)
                    .body(new ResponseDto(CardConstants.STATUS_200, CardConstants.MESSAGE_200));
        }

        return ResponseEntity
                .status(HttpStatus.EXPECTATION_FAILED)
                .body(new ResponseDto(CardConstants.STATUS_417, CardConstants.MESSAGE_417_DELETE));

    }
}
