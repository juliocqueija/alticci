package com.alticci.controller;

import com.alticci.controller.dto.response.AlticciResponseDTO;
import com.alticci.service.AlticciService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.PositiveOrZero;

@RestController
@RequestMapping("/alticci")
@RequiredArgsConstructor
public class AlticciControllerImpl implements AlticciController {

    private final AlticciService alticciService;

    @GetMapping(value = "/{num}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AlticciResponseDTO> calculateAlticci(
            @Valid @PositiveOrZero(message = "Input number must be 0 or higher") @PathVariable Long num
    ) {
        long result = alticciService.calculate(num);
        return ResponseEntity.ok(
                AlticciResponseDTO
                        .builder()
                        .number(num)
                        .result(result)
                        .build()
        );
    }

}
