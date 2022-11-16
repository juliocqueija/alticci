package com.alticci.controller;

import com.alticci.controller.dto.response.AlticciResponseDTO;
import com.alticci.exception.dto.ErrorResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

import javax.validation.constraints.PositiveOrZero;

@Tag(name = "Alticci API", description = "Returns value from Alticci sequence")
public interface AlticciController {

    @Operation(
            description = "Returns the Alticci sequence result for the given number",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Result successfully calculated"),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Invalid number passed",
                            content = @Content(schema = @Schema(implementation = ErrorResponseDTO.class))
                    ),
                    @ApiResponse(
                            responseCode = "500",
                            description = "Could not calculate value, caused StackOverflow",
                            content = @Content(schema = @Schema(implementation = ErrorResponseDTO.class))
                    )
            }
    )
    ResponseEntity<AlticciResponseDTO> calculateAlticci(
            @Parameter(description = "Alticci sequence number")
            @PositiveOrZero(message = "Input number must be 0 or higher")
            Long num
    );

}
